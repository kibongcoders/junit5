package com.kibong.junit5.SessionZero;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

public class TaggingFilteringTest{
    @Test
    @Tag("fast")
    @DisplayName("Tagging Fast 테스트")
    void taggingFastTest() {
        System.out.println("fast");
    }

    @Test
    @Tag("slow")
    @DisplayName("Tagging Slow 테스트")
    void taggingSlowTest() {
        System.out.println("slow");
    }
    @FateTest
    @DisplayName("커스텀 태그 테스트")
    void customTagTest() {
        System.out.println("custom tag test");
    }
}
