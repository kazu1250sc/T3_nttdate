package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Form.MessageForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class RoomController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomUserService roomUserService;

    @GetMapping("/rooms/{roomId}")
    public String getRoom(Model model, @AuthenticationPrincipal UserDetailServiceImpll loginUser, @PathVariable("roomId") int id, @ModelAttribute("form") MessageForm form) {

        //ログインユーザーの情報を取得
        String username = loginUser.getUser().getName();
        int loginUserId = loginUser.getUser().getId();

        model.addAttribute("username", username);

        //ログインユーザーと選択されたユーザーが保有するチャットルームを取得
        List<MRoom> rooms = roomService.getLoginUserRooms(loginUser);
        model.addAttribute("rooms", rooms);

        //room_usersテーブルのレコード(1件)取得
        TRoomUser roomUser = roomUserService.getRoomUserOne(id);

        //room_usersに登録されているログインユーザーのIDを取得
        int currentUserId = roomUser.getCurrentUserId();
        //room_usersに登録されているチャットするユーザーのIDを取得
        int userId = roomUser.getUserId();

        //ログインユーザーとroom_usersのログインユーザーID、またはログインユーザーとチャット選択されたユーザーのIDが等しい時メッセー送信画面に遷移する
        if(loginUserId == currentUserId || loginUserId == userId) {
            return "redirect:/rooms/{roomId}";
        }

        return "redirect:/";
    }
}