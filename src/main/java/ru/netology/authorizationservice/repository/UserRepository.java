package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.controller.Authorities;
import ru.netology.authorizationservice.user.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    Map<User, List<Authorities>> usersAuthorities = new ConcurrentHashMap<>();

    @PostConstruct
    private void fillMap() {
        User alisa = new User("Alisa", "123");
        List<Authorities> alisaAuthorities = new ArrayList<>();
        alisaAuthorities.add(Authorities.WRITE);
        usersAuthorities.put(alisa, alisaAuthorities);
    }

    public List<Authorities> getUserAuthorities(String name, String password) {
        User tempUser = new User(name, password);
        if (usersAuthorities.containsKey(tempUser)) {
            return usersAuthorities.get(tempUser);
        }
        return null;
    }
}
