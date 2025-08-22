package com.example.quiz.repository;

import com.example.quiz.entity.Play;
import com.example.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {
        @Query(value = " SELECT * FROM quiz ORDER BY RAND() LIMIT 1",nativeQuery = true)
        List<Quiz> searchPlay(@Param("keyword")String keyword);

        List<Play> findByQuizId(Long quizId);

        List<Play> findByMemberId(Long memberId);
}
