package com.chuwa.redbook.controller;

import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SessionController {
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);
    @GetMapping("/log-session")
    public String logSession(HttpSession session) {
        Enumeration<String> attributeNames = session.getAttributeNames();
        logger.info("Session ID: {}",
                session.getId());
        while
        (attributeNames.hasMoreElements()) {
            String attributeName =
                    attributeNames.nextElement();
            Object attributeValue =
                    session.getAttribute(attributeName);
            logger.info("Attribute: {} - Value: {}", attributeName, attributeValue);
        }
        return "Session logged";
    }
}