package com.example.quiz.repository;

import com.example.quiz.entity.Member;
import com.example.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query(value = " SELECT * FROM quiz ORDER BY id ", nativeQuery = true)
    List<Quiz> searchQuery();

    // 이름으로 검색
    @Query(value = " SELECT * FROM quiz WHERE name LIKE %:keyword% ORDER BY id", nativeQuery = true)
    List<Quiz> searchId(@Param("keyword")String keyword);
    // 주소로 검색
    @Query(value = " SELECT * FROM quiz WHERE question LIKE %:keyword% ORDER BY id", nativeQuery = true)
    List<Quiz> searchQuestion(@Param("keyword")String keyword);
}
