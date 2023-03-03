package ru.netology.authorizationservice.model;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    @NotEmpty
    @Min(1)
    @Max(50)
    private String name;
    @NotEmpty
    private String password;
    private List<Authorities> authorities = null;

    public User (String name, String password) {
        this.name = name;
        this.password = password;
    }
}
