package ru.otus.SpringMvcHomework.service;

import org.springframework.stereotype.Service;
import ru.otus.SpringMvcHomework.domain.Comment;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> getByBookId(long bookId);

    void deleteCommentByBookId(Long id);

    void insertComment(Comment comment);
}
