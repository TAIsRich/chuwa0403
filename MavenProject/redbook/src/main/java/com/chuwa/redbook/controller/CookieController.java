package com.chuwa.redbook.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CookieController {
    @GetMapping("/read-cookie/HttpServletRequest")
    public String readCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("myCookie".equals(cookie.getName())) {
                    return "Cookie value: " + cookie.getValue();
                }
            }
        }
        return "Cookie not found";
    }

    @GetMapping("/read-cookie/RequestParam")
    public String
    readCookie(@CookieValue(value = "myCookie", required = false, defaultValue = "defaultvalue") String myCookie) {
        return "Cookie value: " + myCookie;
    }
}
