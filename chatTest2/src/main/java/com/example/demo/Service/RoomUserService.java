package com.example.demo.Service;

public interface RoomUserService {

    /**room_user登録*/
    public void registRoomUser(RoomForm form, TRoomUser roomUser, @AuthenticationPrincipal UserDetailServiceImpll loginUser);
}