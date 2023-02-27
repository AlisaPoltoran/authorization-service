package ru.netology.authorizationservice.service;


import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.exception.InvalidCredentials;
import ru.netology.authorizationservice.exception.UnauthorizedUser;
import ru.netology.authorizationservice.repository.UserRepository;
import ru.netology.authorizationservice.model.User;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        // Первый if, получается, больше не нужен, так как мы проверям,
        // есть ли имя и пароль до выполения метода контроллера, правильно?
        if (!StringUtils.hasLength(user.getName()) || !StringUtils.hasLength(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (CollectionUtils.isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown name " + user.getName());
        }
        return userAuthorities;
    }
}
