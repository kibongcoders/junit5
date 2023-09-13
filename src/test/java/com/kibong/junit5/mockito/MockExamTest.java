package com.kibong.junit5.mockito;

import com.kibong.junit5.domain.Member;
import com.kibong.junit5.domain.StudyStatus;
import com.kibong.junit5.member.MemberService;
import com.kibong.junit5.domain.Study;
import com.kibong.junit5.study.StudyRepository;
import com.kibong.junit5.study.StudyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MockExamTest {

    @Test
    void openStudy(@Mock MemberService memberService, @Mock StudyRepository studyRepository){
        Member member = new Member();
        member.setId(1L);
        member.setEmail("kibong@email.com");

        Study study = new Study(10, "더 자바 테스트");
        given(studyRepository.save(study)).willReturn(study);

        StudyService studyService = new StudyService(memberService, studyRepository);
        Study newStudy = studyService.openStudy(study);

        assertEquals(newStudy.getStatus(), StudyStatus.OPENED);
        assertNotNull(study.getOpenedDateTime());
        then(memberService).should(times(1)).notify(newStudy);
    }
}
