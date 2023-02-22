package ru.netology.authorizationservice.user;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Value
public class User {
    @NotEmpty
    @Min(1)
    @Max(50)
    private String name;
    @NotEmpty
    private String password;
}
