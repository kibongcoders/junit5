package com.kibong.junit5.mockito;

import com.kibong.junit5.member.MemberService;
import com.kibong.junit5.study.StudyRepository;
import com.kibong.junit5.study.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class MockObjectTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    @DisplayName("인스턴스를 통해 생성")
    void createInstanceStudyTest(){
        StudyService studyService = new StudyService(memberService, studyRepository);
    }

    @Test
    @DisplayName("애노테이션을 통해 생성")
    void createAnnotationTest(){
        StudyService studyService = new StudyService(memberService, studyRepository);
    }

    @Test
    @DisplayName("생성자를 사용해서 생성")
    void createConstructorTest(@Mock MemberService memberService, @Mock StudyRepository studyRepository){
        StudyService studyService = new StudyService(memberService, studyRepository);
    }
}
