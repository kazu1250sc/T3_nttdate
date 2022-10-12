package com.example.demo.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper mapper;

    /**
     *チャットルーム登録
     */
    @Transactional
    @Override
    public void insertRoom(MRoom room, RoomForm form) {
        //チャットルーム名取得
        room.setRoomName(form.getRoomName());

        //現在時刻の取得
        LocalDateTime now = LocalDateTime.now();
        room.setCreatedAt(now);

        //チャットルーム登録
        mapper.insertOneRoom(room);
    }

}