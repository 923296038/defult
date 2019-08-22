package com.serviceImpl;

import com.controller.BannerController;
import com.mapper.PasswordMapper;
import com.pojo.Password;
import com.service.PasswordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "passwordService")
public class PasswordServiceImpl implements PasswordService {
    @Autowired
    PasswordMapper passwordMapper;
    private static final Logger log= LogManager.getLogger(PasswordService.class);
    @Override
    public boolean updatePassword(Password password) {
        String current_pswd = passwordMapper.getPswd();
        log.error(current_pswd);
        boolean flag = password.getPrevious_pswd().equals(current_pswd)
                &&password.getNew_pswd().equals(password.getRepeat_pswd());
        log.error(password);
        log.error(flag);
        if(flag) {
            passwordMapper.updatePassword(password);
            return true;
        }
        else return false;
    }
}
