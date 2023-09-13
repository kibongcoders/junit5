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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockObjectCheckTest {

    @Test
    @DisplayName("Mock 객체 체크 테스트")
    void objectCheckTest(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        Study study = new Study(10, "테스트");

        Member member = new Member();
        member.setEmail("kibong@email.com");
        member.setId(1L);

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        Optional<Member> byId = memberService.findById(1L);


        StudyService studyService = new StudyService(memberService, studyRepository);

        Study newStudy = studyService.createNewStudy(byId.get().getId(), study);

        assertEquals(newStudy.getOwnerId(), member.getId());

        //Mock 객체를 얼마나 사용하고 있는지 확인 가능
        verify(memberService, times(1)).notify(study);
        verify(memberService, never()).validate(any());
        verifyNoMoreInteractions(memberService);

    }
}
