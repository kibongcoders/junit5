package com.kibong.junit5.SessionZero;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    /**
     * BeforeTestExecutionCallback, AfterTestExecutionCallback 인터페이스를 구현해서 확장할 수 있다.
     *
     */
    private long THRESHOLD;

    public FindSlowTestExtension(long THRESHOLD) {
        this.THRESHOLD = THRESHOLD;
    }

    //실행 전
    @Override
    public void beforeTestExecution(ExtensionContext context){
        ExtensionContext.Store store = getStore(context);
        store.put("START_TIME", System.currentTimeMillis());
    }

    //실행 후
    @Override
    public void afterTestExecution(ExtensionContext context){
        //리플렉션으로 메소드의 애노테이션을 가져올 수 있다.
        SlowTest annotation = context.getRequiredTestMethod().getAnnotation(SlowTest.class);
        String methodName = context.getRequiredTestMethod().getName();
        ExtensionContext.Store store = getStore(context);

        Long startTime = store.remove("START_TIME", long.class);
        long duration = System.currentTimeMillis() - startTime;

        if(duration > THRESHOLD && annotation == null){
            System.out.printf("[%s]가 @SlowTest 애노테이션이 있는지 메소드를 확인해주세요.\n",methodName);
        }
    }

    private static ExtensionContext.Store getStore(ExtensionContext context) {
        String className = context.getRequiredTestClass().getName(); //클래스 정보 가져오기
        String methodName = context.getRequiredTestMethod().getName(); //메소드 정보 가져오기
        //store는 데이터를 넣고 뺄수 있다.
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(className, methodName));
        return store;
    }
}
