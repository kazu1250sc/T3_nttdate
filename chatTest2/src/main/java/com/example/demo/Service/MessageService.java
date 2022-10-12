package com.example.demo.Service;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.Entity.TMessage;
import com.example.demo.Form.MessageForm;



public interface MessageService {

    /**メッセージ登録*/
    public void insertMessage(TMessage message, MessageForm form, @AuthenticationPrincipal UserDetailsService loginUser, int roomId);

}