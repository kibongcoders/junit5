package com.kibong.junit5;

import com.kibong.junit5.domain.Study;
import com.kibong.junit5.domain.StudyStatus;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AssertionTest {

    @Test
    @DisplayName("assertEquals 테스트")
    void assertEqualsTest() {
        Study study = new Study(10);
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");

    }

    @Test
    @DisplayName("assertEqualsSupplier 테스트")
    void assertEqualsSupplierTest() {
        Study study = new Study(10);
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
        assertEquals(StudyStatus.DRAFT, study.studyStatus, () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다.");
    }

    @Test
    @DisplayName("assertTrue 테스트")
    void assertTrueTest() {
        Study study = new Study(0);
        study.setLimit(11);
        assertTrue(study.getLimit() > 10, () -> "스터디는 10보다 큽니까?");
    }

    @Test
    @DisplayName("assertAll 테스트")
    void assertAllTest() {
        Study study = new Study();
        study.setLimit(11);
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.studyStatus, "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + "여야 한다."),
                () -> assertTrue(study.getLimit() > 10, () -> "스터디는 10보다 큽니까?")
        );
    }
    @Test
    @DisplayName("assertThrows 테스트")
    void assertThrowsTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(10).setLimit(20));
        String message = exception.getMessage();
        assertEquals("스터디의 제한은 10입니다.", message);
    }

    @Test
    @DisplayName("assertTimeout 테스트")
    void assertTimeoutTest() {
        Study study = new Study(10);

        assertTimeout(Duration.ofMillis(300), () -> {
            study.getStudyStatus();
        });

        assertTimeoutPreemptively(Duration.ofMillis(300), () -> {
            study.getStudyStatus();
        });
    }
}
