package com.richard.cookielearndarkui.controller;

import com.richard.cookielearndarkui.service.ModeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Enumeration;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@RestController
@Slf4j
public class SessionController {

    private final ModeService modeService;
    @Autowired
    public SessionController(ModeService modeService) {
        this.modeService = modeService;
    }

    @GetMapping("/log-session")
    public String logSession(HttpSession session) {
        Enumeration<String> attributeNames = session.getAttributeNames();

        log.info("Session ID: {}", session.getId());

        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = session.getAttribute(attributeName);
            log.info("Attribute: {} - Value: {}", attributeName, attributeValue);
        }

        return "Session logged";
    }

    @PostMapping("/mode")
    public String setMode(HttpSession session,
                          @PathParam(value = "mode") String mode) {

        String sessionId = session.getId();
        modeService.setMode(sessionId, mode);

        return "Set!";
    }

    @GetMapping("/mode")
    public String getMode(HttpSession session) {
        String sessionId = session.getId();

        return modeService.getMode(sessionId);
    }
}
