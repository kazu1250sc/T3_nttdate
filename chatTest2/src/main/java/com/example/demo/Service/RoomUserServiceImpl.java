import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomUserServiceImpl implements RoomUserService {

    @Autowired
    private RoomUserMapper mapper;

    @Autowired
    private RoomService service;

    @Transactional
    @Override
    public void registRoomUser(RoomForm form, TRoomUser roomUser, @AuthenticationPrincipal UserDetailServiceImpll loginUser) {

        //formをMRoomクラスに変換
        MRoom room = new MRoom();

        //チャットルーム登録
        service.insertRoom(room, form);

        //ログインユーザーのユーザーID取得
        int currentUserId = loginUser.getUser().getId();

        //roomsテーブルのIDを設定(FK)
        roomUser.setRoomId(room.getId());
        //ログインユーザーのIDを設定
        roomUser.setCurrentUserId(currentUserId);
        //プルダウン選択されたユーザーIDを設定
        roomUser.setUserId(form.getUserId());

        //現在時刻の取得
        LocalDateTime now = LocalDateTime.now();
        roomUser.setCreatedAt(now);

        //roomUserTBL登録
        mapper.insertRoomUser(roomUser);
    }
}