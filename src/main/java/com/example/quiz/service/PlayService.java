package com.example.quiz.service;

import com.example.quiz.entity.Member;
import com.example.quiz.entity.Play;
import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.MemberRepository;
import com.example.quiz.repository.PlayRepository;
import com.example.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayService {

    private final PlayRepository repository;
    private final QuizRepository quizRepository;
    private final MemberRepository memberRepository;

    public PlayService(PlayRepository repository, QuizRepository quizRepository, MemberRepository memberRepository) {
        this.repository = repository;
        this.quizRepository = quizRepository;
        this.memberRepository = memberRepository;
    }

    public void savePlay(Long memberId, Long quizId, boolean userAnswer) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));

        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("퀴즈 없음"));

        boolean correct = (quiz.isAnswerTrue() == userAnswer);

        Play play = Play.builder()
                .member(member)
                .quiz(quiz)
                .userAnswer(userAnswer)
                .correct(correct)
                .build();

        repository.save(play);
    }

    public double getQuizAccuracyRate(Long quizId) {
        List<Play> plays = repository.findByQuizId(quizId);
        if (plays.isEmpty()) return 0.0;

        long correctCount = plays.stream().filter(Play::isCorrect).count();
        return ((double) correctCount / plays.size()) * 100;
    }

    public List<Play> getPlayHistoryByMember(Long memberId) {
        return repository.findByMemberId(memberId);
    }
}
//    public List<PlayDto> getAllList() {
//        List<Quiz> quizList = repository.findAll();
//        System.out.println(quizList);
//        // 비어있는 DTO List 만들기
////  ---- List<MemberDto> dtoList = new ArrayList<>();
//
//        // Entity List를 DTO List로 변환
////        for (int i = 0; i < memberList.size(); i++) {
////            // 리스트에 있는 엔티티를 하나씩 읽어서
////            // Dto에 담는다.
////            MemberDto dto = new MemberDto();
////            dto.setId(memberList.get(i).getId());
////            dto.setName(memberList.get(i).getName());
////            dto.setAge(memberList.get(i).getAge());
////            dto.setAddress(memberList.get(i).getAddress());
////            dtoList.add(dto);
////        }
//        // fromMemberEntity 메서드로 작업하기
////        ----dtoList = memberList
//        return quizList
//                .stream()
//                .map( x -> QuizDto.fromQuizEntity(x))
//                .toList();
//
////        return dtoList;
//    }

//}
