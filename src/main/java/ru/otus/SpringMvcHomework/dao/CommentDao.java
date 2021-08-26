package ru.otus.SpringMvcHomework.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringMvcHomework.domain.Comment;


@Component
public interface CommentDao extends JpaRepository<Comment, Long> {
    void deleteByBookId(Long id);
}
