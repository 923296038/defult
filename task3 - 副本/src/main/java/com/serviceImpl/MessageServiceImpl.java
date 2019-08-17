package com.serviceImpl;

import com.mapper.MessageMapper;
import com.pojo.Message;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public int insertMessage(Message message) {
        return messageMapper.insertMessage(message);
    }

    @Override
    public boolean deleteMessage(Long id) {
        return messageMapper.deleteMessage(id);
    }

    @Override
    public boolean updateMessage(Message message) {
        return messageMapper.updateMessage(message);
    }

    @Override
    public boolean updateReply(Message message) {
        return messageMapper.updateReply(message);
    }

    @Override
    public List<Message> findByWorkTitle(String work_title) {
        return messageMapper.findByWorkTitle(work_title);
    }

    @Override
    public List<Message> findAllMessage() {
        return messageMapper.findAllMessage();
    }

    @Override
    public Message findByID(Long id) {
        return messageMapper.findByID(id);
    }

    @Override
    public boolean upMessage(Long id) {
        return messageMapper.upMessage(id);
    }

    @Override
    public boolean downMessage(Long id) {
        return messageMapper.downMessage(id);
    }
}
