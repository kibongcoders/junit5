package com.kibong.junit5.SessionZero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InstanceTest {

    //Junit5는 테스트 마다 인스턴스를 초기화 한다.
    //Junit5은 테스트 마다 새로운 인스턴스를 생성한다 의존성 때문
    //절대적으로 순서가 정해져 있는 것은 아니다.
    //@TestInstance(TestInstance.Lifecycle.PER_CLASS) 으로 변경 가능하다 기본적으로는 PER_METHOD
    //Junit5에서는 테스트당 인스턴스가 아닌 클래스 마다 인스턴스를 생성 할 수 있도록 변경
    //@BeforeAll @AfterAll도 static이 아닌 public으로 생성 가능하다.
    //왜냐? 테스트당 생성되는 것이 아닌 클래스당 생성되기에 static하지 않아도 된다.

    int value = 1;

    @BeforeAll
    void beforeAll(){

    }

    @BeforeAll
    void afterAll(){

    }


    @Test
    void instanceTestOne(){
        System.out.println("value = " + value);
        System.out.println(this);
        value++;
    }

    @Test
    void instanceTestTwo(){
        System.out.println("value = " + value);
        System.out.println(this);
        value++;
    }
}
