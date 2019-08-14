package com.mapper;

import com.pojo.Message;
import java.util.List;

public interface MessageMapper {
    int insertMessage(Message message);
    boolean deleteMessage(Long id);
    boolean updateMessage(Message message);
    boolean updateReply(Message message);
    List<Message> findByUserName(String user_name);
    Message findByID(Long id);
    List<Message> findAllMessage();
    boolean upMessage(Long id);
    boolean downMessage(Long id);
}
