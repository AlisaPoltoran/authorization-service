package ru.netology.authorizationservice.resolver;


import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.model.User;

import java.util.List;
import java.util.Map;

public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameter().getType() == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {


        Map<String, String[]> nameAndPassword = ((ServletWebRequest) webRequest)
                .getRequest()
                .getParameterMap();

        String name = nameAndPassword.get("user")[0];
        String password = nameAndPassword.get("password")[0];

        return new User(name, password);
    }
}
