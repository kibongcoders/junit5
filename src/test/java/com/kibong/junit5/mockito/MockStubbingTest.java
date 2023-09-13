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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockStubbingTest {

    //stubbing해서 값을 넘겨 줄 수 있다.

    @Test
    @DisplayName("생성자를 사용해서 생성")
    void createStubbingTest(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {

        Member member = new Member();
        member.setEmail("kibong@email.com");
        member.setId(1L);

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        assertEquals("kibong@email.com", memberService.findById(1L).get().getEmail());
        assertEquals("kibong@email.com", memberService.findById(1L).get().getEmail());


        StudyService studyService = new StudyService(memberService, studyRepository);
    }

    @Test
    @DisplayName("stubbing 예외 테스트")
    void stubbingThrowTest(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {

        when(memberService.findById(1L)).thenThrow(new RuntimeException());
        memberService.findById(1L);

        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);
        memberService.validate(1L);
    }

    @Test
    @DisplayName("stubbing 여러 리턴 테스트")
    void stubbingBuilder(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        Member member = new Member();
        member.setEmail("kibong@email.com");
        member.setId(1L);

        when(memberService.findById(1L))
                .thenReturn(Optional.of(member))
                .thenThrow(new IllegalArgumentException())
                .thenReturn(Optional.empty());

        assertEquals("kibong@email.com", memberService.findById(1L).get().getEmail());
        assertThrows(IllegalArgumentException.class, () -> {
            memberService.findById(1L);
        });

        assertTrue(memberService.findById(1L).isEmpty());
    }

    @Test
    @DisplayName("stubbing 여러 리턴 테스트")
    void stubbingExampleTest(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        Study study = new Study(10, "테스트");

        Member member = new Member();
        member.setEmail("kibong@email.com");
        member.setId(1L);

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        Optional<Member> byId = memberService.findById(1L);
        if (byId.isPresent()) {

            StudyService studyService = new StudyService(memberService, studyRepository);

            Study newStudy = studyService.createNewStudy(byId.get().getId(), study);

            assertEquals(newStudy.getOwnerId(), member.getId());
        }
    }
}

