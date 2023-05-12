package com.richard.cookielearndarkui.service.impl;

import com.richard.cookielearndarkui.dao.ModeRepository;
import com.richard.cookielearndarkui.entity.Mode;
import com.richard.cookielearndarkui.service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Service
public class ModeServiceImpl implements ModeService {

    private final ModeRepository modeRepository;
    @Autowired
    public ModeServiceImpl(ModeRepository modeRepository) {
        this.modeRepository = modeRepository;
    }

    @Override
    public String setMode(String session, String mode) {
        Mode savedMode = new Mode();
        savedMode.setMode(mode);
        savedMode.setSessionId(session);

        modeRepository.save(savedMode);
        return "Saved";
    }

    @Override
    public String getMode(String session) {
        Optional<Mode> mode = modeRepository.findModeBySessionId(session);
        return mode.get().getMode();
    }
}
