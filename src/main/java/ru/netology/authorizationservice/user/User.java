package ru.netology.authorizationservice.user;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String name;
    private String password;
}
