//package ru.otus.SpringMvcHomework.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import ru.otus.SpringMvcHomework.dao.UserDao;
//import ru.otus.SpringMvcHomework.domain.User;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class AppUserDetailsService implements UserDetailsService {
//
//    private final UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        Optional<User> userByLogin = userDao.findByLogin(login);
//        return new UserDetailsImpl(userByLogin.get());
//    }
//}
