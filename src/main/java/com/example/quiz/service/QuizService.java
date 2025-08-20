package com.example.quiz.service;

import com.example.quiz.dto.MemberDto;
import com.example.quiz.dto.QuizDto;
import com.example.quiz.entity.Member;
import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.MemberRepository;
import com.example.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    // 리포지토리 통해서 멤버리스트 가져오기
    public List<QuizDto> getAllList() {
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

    public void insertQuiz(QuizDto dto) {
        // 3. 서비스에서 DTO를 entity로 바꾼다.
//        Member member = new Member();
//        member.setName(dto.getName());
//        member.setAge(dto.getAge());
//        member.setAddress(dto.getAddress());
        // 우리가 만든 toDto를 이용해서 member 엔티티 생성핫기
        Quiz quiz = QuizDto.toDto(dto);

        // 4. repository를 이용해서 저장한다.
        quiz = repository.save(quiz);
        System.out.println("===================");
        System.out.println(quiz);

    }

    public void deleteQuiz(Long id) {
        // 삭제처리
        repository.deleteById(id);
    }

    public QuizDto findMember(Long updateId) {
        // 검색해보기
        // 비어있는지 검사해서 찾으면 DTO로 변환 후 돌려주고
        // 없으면 null 리턴
        Quiz quiz = repository.findById(updateId).orElse(null);
        // member가 null 인지 확인
        if(ObjectUtils.isEmpty(quiz)){
            return null;
        }else {
            return QuizDto.fromQuizEntity(quiz);
        }

    }

    public void updateQuiz(QuizDto dto) {
        // 1. 받은 DTO를 entity로 변환
        Quiz quiz = QuizDto.toDto(dto);
        // 2. 수정 요청
        repository.save(quiz);
    }

    public List<QuizDto> searchQuiz(String type, String keyword) {
        // 조건 1.
        // 1. type이 비어 있을 때 : 전체 검색
        // 2. type = 'name' -> searchName
        // 3. type = 'address' -> searchAddress

        switch (type){
            case "id" :
                return repository.searchId(keyword)
                        .stream()
                        .map(x -> QuizDto.fromQuizEntity(x))
                        .toList();
            case "question" :
                return repository.searchQuestion(keyword)
                        .stream()
                        .map(x->QuizDto.fromQuizEntity(x))
                        .toList();
            default:
                return repository
                        .searchQuery()
                        .stream()
                        .map(x -> QuizDto.fromQuizEntity(x))
                        .toList();
        }

    }
}
