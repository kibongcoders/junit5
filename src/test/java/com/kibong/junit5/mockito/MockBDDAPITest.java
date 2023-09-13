package com.kibong.junit5.mockito;

import com.kibong.junit5.domain.Member;
import com.kibong.junit5.domain.Study;
import com.kibong.junit5.member.MemberService;
import com.kibong.junit5.study.StudyRepository;
import com.kibong.junit5.study.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class MockBDDAPITest {

    @Test
    @DisplayName("BDD API 테스트")
    void bddApiTest(@Mock MemberService memberService, @Mock StudyRepository studyRepository){

        //Given
        Study study = new Study(10, "테스트");
        Member member = new Member();
        member.setEmail("kibong@email.com");
        member.setId(1L);

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        Optional<Member> byId = memberService.findById(1L);

        StudyService studyService = new StudyService(memberService, studyRepository);

        //When
        Study newStudy = studyService.createNewStudy(byId.get().getId(), study);

        //Then
        assertEquals(newStudy.getOwnerId(), member.getId());
        then(memberService).should(times(1)).notify(study);
        then(memberService).shouldHaveNoMoreInteractions();
    }
}
