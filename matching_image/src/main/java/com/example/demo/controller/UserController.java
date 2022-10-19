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
  public String image(@ModelAttribute UserSearchRequest userSearchRequest,Model model) {//メソッド2

    //User user = userService.search(userSearchRequest);//サービスクラスに依頼
    List<User> user = userService.search(userSearchRequest);//NOT NULLのユーザー情報
    List<String> path =userService.image(userSearchRequest);//画像
    List<String> year =userService.nyuusya(userSearchRequest);//入社年度
    /*
    List<String> favorite =userService.like(userSearchRequest);//好きなタイプ
    List<String> hobby_info =userService.hobby(userSearchRequest);//趣味
    List<String> comment_info =userService.comment(userSearchRequest);//一言コメント
    */
    try {
		//画像をbyteに変換	        
        for(int i=0;i< path.size();i++){
        	String value = path.get(i);//ここから文字列の名前を取り出したい
        	if(value==null) {
        		File fileImg = new File("C:\\ProgramData\\images/"+"damy.jpg");
        		byte[] byteImg = Files.readAllBytes(fileImg.toPath());
    			String base64Data = Base64.getEncoder().encodeToString(byteImg);
    			path.set(i,"data:image/png;base64,"+base64Data);
        	}
        	else {
        		File fileImg = new File("C:\\ProgramData\\images/"+value);
        		byte[] byteImg = Files.readAllBytes(fileImg.toPath());
    			String base64Data = Base64.getEncoder().encodeToString(byteImg);
    			path.set(i,"data:image/png;base64,"+base64Data);
        	}
        }
        //入社年度のnull値を置き換え	        
        for(int i=0;i< year.size();i++){
        	String value2 = year.get(i);//ここから文字列の名前を取り出したい
        	if(value2==null) {
        		year.set(i,"未入力です");
        	}
        }
        /*
        //好きなタイプのnull値を置き換え	        
        for(int i=0;i< favorite.size();i++){
        	String value3 = favorite.get(i);//ここから文字列の名前を取り出したい
        	if(value3==null) {
        		favorite.set(i,"未入力です");
        	}
        }
      //趣味のnull値を置き換え	        
        for(int i=0;i< hobby_info.size();i++){
        	String value4 = hobby_info.get(i);//ここから文字列の名前を取り出したい
        	if(value4==null) {
        		hobby_info.set(i,"未入力です");
        	}
        }
      //一言コメントのnull値を置き換え	        
        for(int i=0;i< comment_info.size();i++){
        	String value5 = comment_info.get(i);//ここから文字列の名前を取り出したい
        	if(value5==null) {
        		comment_info.set(i,"未入力です");
        	}
        }
        */
        model.addAttribute("userinfo", user);//結果を設定
        model.addAttribute("base64Data",path);
        model.addAttribute("nyuusya_year",year);
        /*
        model.addAttribute("favorite_type",favorite);
        model.addAttribute("hobby",hobby_info);
        model.addAttribute("comment",comment_info);
        */
     }catch(IOException e) {
    	return null;
    }
    return "user/result";//htmlの読み出し
  }
  
  
}
  