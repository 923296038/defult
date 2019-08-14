package com.service;

import com.pojo.Message;
import java.util.List;

public interface MessageService {
    int insertMessage(Message message);
    boolean deleteMessage(Long id);
    boolean updateMessage(Message message);
    boolean updateReply(Message message);
    List<Message> findByUserName(String user_name);
    List<Message> findAllMessage();
    Message findByID(Long id);
    boolean upMessage(Long id);
    boolean downMessage(Long id);
}
