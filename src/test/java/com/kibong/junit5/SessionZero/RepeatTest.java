package com.kibong.junit5.SessionZero;

import com.kibong.junit5.study.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatTest {

    //반복하는 테스트
    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10, name = "{displayName} {displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo){

        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    //파라미터에 따라 반복하는 테스트
    @DisplayName("파라미터 String 반복 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있습니다."})
    void parameterizedTest(String message){
        System.out.println(message);
    }

    @DisplayName("파라미터 Empty Null 반복 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있습니다."})
    @EmptySource
    @NullSource
    @NullAndEmptySource
    void EmptyNullTest(String message){
        System.out.println(message);
    }

    @DisplayName("Enum 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @EnumSource(StudyEnum.class)
    void EnumTest(StudyEnum studyEnum){
        System.out.println(studyEnum);
    }

    @DisplayName("인스턴스 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {10,20,40})
    void instanceTest(@ConvertWith(StudyConverter.class) Study study){
        System.out.println("study.getLimit() = " + study.getLimit());
    }

    @DisplayName("csv 반복 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, '스프링'"})
    void csvTest(ArgumentsAccessor argumentsAccessor){
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        System.out.println("study.getLimit() = " + study.getLimit());
        System.out.println("study.getName() = " + study.getName());
    }

    @DisplayName("ArgumentsAggregator 반복 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"10, '자바 스터디'", "20, '스프링'"})
    void argumentsAggregatorTest(@AggregateWith(StudyAggregator.class) Study study){
        System.out.println("study.getLimit() = " + study.getLimit());
        System.out.println("study.getName() = " + study.getName());
    }

    static class StudyConverter extends SimpleArgumentConverter{
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "스터디만 변경 가능합니다.");
            return  new Study(Integer.parseInt(source.toString()));
        }
    }

    //ArgumentsAggregator 제약 조건 static inner 이거나 public 클래스 이거나
    static class StudyAggregator implements ArgumentsAggregator{
        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            return new Study(accessor.getInteger(0), accessor.getString(1));
        }
    }

}
