package com.calcio.it.springmvcseriea.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static String getSessionUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //AnonymousAuthenticationToken - это класс в Spring Security, который представляет аутентификацию анонимного пользователя.
        // Этот токен используется в тех случаях, когда пользователь не был аутентифицирован,
        // но ему был предоставлен доступ к ресурсам с помощью конфигурации безопасности Spring Security.
        // Токен содержит информацию о роли анонимного пользователя и может быть использован для проверки прав доступа к ресурсам.

        if (!(authentication instanceof AnonymousAuthenticationToken)){

            //Вернет email а не юзернейм, скорее всего, потому что в таблице email идет сразу после id
            //Если выбрать getPrincipal, то вернется Object с первым параметром username = имеил адресс, а второй будет засекреченный пароль

            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return null;
    }
}
