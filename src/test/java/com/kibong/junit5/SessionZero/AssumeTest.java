package com.kibong.junit5.SessionZero;

import com.kibong.junit5.study.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumeTest {

    @Test
    @DisplayName("assumeTrue 테스트")
    void assumeTrueTest(){
        assumeTrue("LOCA".equalsIgnoreCase(System.getenv("TEST_ENV")));
        System.out.println(System.getenv("TEST_ENV"));
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("assumingThat 테스트")
    void assumingThatTest(){

        assumingThat("LOCA".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {
            System.out.println(System.getenv("TEST_ENV"));
            Study study = new Study(10);
            assertThat(study.getLimit()).isGreaterThan(0);
        });

        System.out.println(System.getenv("TEST_ENV"));
    }
    @Test
    @DisplayName("enabledOs 테스트")
    @EnabledOnOs(OS.MAC)
    void enabledOsTest(){
        System.out.println("MAC");
    }

    @Test
    @DisplayName("enabledJre 테스트")
    @EnabledOnJre(JRE.JAVA_17)
    void enabledJreTest(){
        System.out.println("Jre11");
    }

    @Test
    @DisplayName("EnabledIfEnvironmentVariable 테스트")
    @EnabledIfSystemProperty(named = "java.version" , matches = "17.0.6")
    void enabledIfSystemPropertyTest(){
        System.out.println(System.getProperty("java.version"));
    }

    @Test
    @DisplayName("EnabledIfEnvironmentVariable 테스트")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void enabledIfEnvironmentVariableTest(){
        System.out.println(System.getenv("TEST_ENV"));
    }

    @Test
    @DisplayName("EnabledIf 테스트")
    @EnabledIf("conditionTrue")
    void enabledIfTest(){
        System.out.println("EnabledIf");
    }

    boolean conditionTrue(){
        return true;
    }
}
