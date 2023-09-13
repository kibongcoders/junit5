package com.kibong.junit5;

import com.kibong.junit5.domain.Study;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    //스프링 부트 2.2 부터 기본으로 Junit5
    //Junit5 부터 public을 사용하지 않아도 됨 어차피 리플랙션으로 클래스와 메소드를 찾음

    //반드시 static을 사용할 것 private X
    //@BeforeAll 모든 테스트가 실행 되기전 한번만 실행
    //@AfterAll 모든 테스트가 실행 된 후 한번만 실행

    //굳이 static일 필요 없음
    //@BeforeEach 각 테스트가 실행 되기전 한번씩 실행
    //@AfterEach 각 테스트가 실행 된 후 한번씩 실행

    //@Disabled 테스트 실행하고 싶지 않을 때
    //코드가 있는데 Deprecated 되었을 때

    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
    }

    @Test
    void create1(){
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }


    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }

    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }
}