package com.kibong.junit5.SessionZero;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

//@ExtendWith(FindSlowTestExtension.class) 선언적으로 가능
public class ExtensionTest {

    /*
        Junit4에 비해 Junit5는 확장 모델을 등록하는 것이 간단해졌다.
        Junit4에서는 @RunWith(Runner), TestRule, MethodRule 등이 있었지만
        Junit5에서는 Extension 하나로 확장 모델을 만들 수 있다.
    */

    //인스턴스로 만드는 방법이 가장 좋다.
    //내가 원하지 않는 Extension을 사용할 수도 있기에 명시적으로 선언해주는 방법이 가장 좋다.
    @RegisterExtension
    FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);


    @Test
    @DisplayName("확장 테스트")
    @SlowTest
    void extensionSlowTest() throws InterruptedException {
        Thread.sleep(1005);
        System.out.println("확장 테스트");
    }
}
