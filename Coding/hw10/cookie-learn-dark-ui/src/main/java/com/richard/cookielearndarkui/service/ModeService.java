package com.richard.cookielearndarkui.service;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

public interface ModeService {

    String setMode(String session, String mode);

    String getMode(String session);
}
