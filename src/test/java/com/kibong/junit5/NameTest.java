package com.kibong.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NameTest {

    //기본적으로 메소드 이름으로 나타남
    //under score를 쓰는게 케이스가 읽기가 편함

    //@DisplayNameGeneration 클래스에 있는 모든 테스트에 적용 가능

    //@DisplayName 테스트 결과에 나타나는 이름 설정 - 권장
    //under score를 쓰더라도 한계가 있음

    @Test
    @DisplayName("스터디 만들기")
    void create_new_study() {
        Study study = new Study(10);
        System.out.println("create");
    }

    @Test
    void create_one() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }


    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }
}
