package com.example.quiz.service;

import com.example.quiz.dto.PlayDto;
import com.example.quiz.dto.QuizDto;
import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.PlayRepository;
import com.example.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayService {

    private final PlayRepository repository;
    private final QuizRepository QuizRepository;

    public PlayService(PlayRepository repository, QuizRepository quizRepository) {
        this.repository = repository;
        this.QuizRepository = quizRepository;
    }

    public List<PlayDto> getAllList() {
        List<Quiz> quizList = repository.findAll();
        System.out.println(quizList);
        // 비어있는 DTO List 만들기
//  ---- List<MemberDto> dtoList = new ArrayList<>();

        // Entity List를 DTO List로 변환
//        for (int i = 0; i < memberList.size(); i++) {
//            // 리스트에 있는 엔티티를 하나씩 읽어서
//            // Dto에 담는다.
//            MemberDto dto = new MemberDto();
//            dto.setId(memberList.get(i).getId());
//            dto.setName(memberList.get(i).getName());
//            dto.setAge(memberList.get(i).getAge());
//            dto.setAddress(memberList.get(i).getAddress());
//            dtoList.add(dto);
//        }
        // fromMemberEntity 메서드로 작업하기
//        ----dtoList = memberList
        return quizList
                .stream()
                .map( x -> QuizDto.fromQuizEntity(x))
                .toList();

//        return dtoList;
    }

}
