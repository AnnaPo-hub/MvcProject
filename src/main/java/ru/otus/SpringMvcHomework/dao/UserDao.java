package ru.otus.SpringMvcHomework.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringMvcHomework.domain.User;

import java.util.Optional;

@Component
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
