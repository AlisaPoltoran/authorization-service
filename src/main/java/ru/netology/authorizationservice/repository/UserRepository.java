package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.exception.UnauthorizedUser;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.model.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    List<User> users = new CopyOnWriteArrayList<>();

    @PostConstruct
    private void fillMap() {
        users.add(new User("Alisa", "123", List.of(Authorities.DELETE, Authorities.WRITE)));
        users.add(new User("Tony", "222", List.of(Authorities.READ)));
        users.add(new User("Leto", "30", List.of(Authorities.DELETE, Authorities.WRITE, Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(User user) {
        List<User> tempUser = users.stream()
                .filter(k -> k.getName().equals(user.getName()))
                .filter(k -> k.getPassword().equals(user.getPassword()))
                .collect(Collectors.toList());
        if (tempUser.isEmpty()) {
            throw new UnauthorizedUser("Unknown name " + user.getName());
        } else {
            return tempUser.get(0).getAuthorities();
        }
    }
}
