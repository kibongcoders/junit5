package com.kibong.junit5.SessionZero;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTest {

    //Junit5은 내부적으로 정해져 있는 순서가 있기는 하다.
    //하지만 그 알고리즘은 언제나 바뀔수 있으므로 순서를 정해두는것이 좋다.
    //테스트는 서로간에 의존성이 있어서는 안된다 -> 테스트가 다른 테스트에 영향을 미치면 안된다.
    //하지만 시나리오 테스트 할 때는 의존성을 테스트 해야하므로 필요한 부분이 있다.

    int value = 1;

    @Test
    @Order(1)
    void orderTestOne(){
        System.out.println("orderTestOne");
        System.out.println("orderTestOne value = " + value);
        System.out.println();
        value++;
    }

    @Test
    @Order(2)
    void orderTestTwo(){
        System.out.println("orderTestTwo");
        System.out.println("orderTestTwo value = " + value);
        System.out.println();
        value++;
    }

    @Test
    @Order(3)
    void orderTestThree(){
        System.out.println("orderTestThree");
        System.out.println("orderTestThree value = " + value);
        System.out.println();
        value++;
    }

    @Test
    @Order(4)
    void orderTestFour(){
        System.out.println("orderTestFour");
        System.out.println("orderTestFour value = " + value);
        System.out.println();
        value++;
    }
}
