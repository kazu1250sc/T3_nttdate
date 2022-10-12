package com.example.demo.Mapper;

import com.example.demo.Entity.TMessage;

//@Mapper
public interface MessageMapper {

    /**メッセージ登録*/
    public int insertOneMessage(TMessage message);
}