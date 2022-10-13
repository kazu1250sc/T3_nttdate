package com.example.demo.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;


/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
	
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private UserService userService;
  
  /**
   * ユーザー情報検索画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/user/search")
  public String displaySearch(Model model) {//メソッド1
    model.addAttribute("userSearchRequest", new UserSearchRequest());
    return "user/search";
  }
  /**
   * ユーザー情報検索
   * @param userSearchRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping(value = "/user/result", method = RequestMethod.POST)
  public String path(@ModelAttribute UserSearchRequest userSearchRequest,Model model) {//メソッド2

    //User user = userService.search(userSearchRequest);//サービスクラスに依頼
    List<User> user = userService.search(userSearchRequest);//サービスクラスに依頼
    List<String> path =userService.path(userSearchRequest);
    
    try {
		//最大値IDを取得	        
        for(int i=0;i< path.size();i++){
        	String value = path.get(i);//ここから文字列の名前を取り出したい
        	File fileImg = new File("C:\\ProgramData\\images/"+value);
        	byte[] byteImg = Files.readAllBytes(fileImg.toPath());
			String base64Data = Base64.getEncoder().encodeToString(byteImg);
			path.set(i,"data:image/png;base64,"+base64Data);
        }
        model.addAttribute("userinfo", user);//結果を設定
        model.addAttribute("base64Data",path);
     }catch(IOException e) {
    	return null;
    }
    return "user/result";//htmlの読み出し
  }
  
  
}
  