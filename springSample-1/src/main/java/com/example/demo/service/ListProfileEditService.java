package com.example.demo.service;

import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ListProfileEditData;
import com.example.demo.dto.ListProfileEditParam;
import com.example.demo.entity.Private_user;
import com.example.demo.repository.ListProfileEditRepository;
/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ListProfileEditService {
  /**
   */
  @Autowired
  private ListProfileEditRepository listProfileEditRepository;
  /**
   * プロフィール情報全検索（ユーザー情報 全検索）
   * @return 検索結果
   */
  public ListProfileEditParam searchAll() {
    // プロフィール情報の取得（ユーザー情報の取得）
    List<Private_user> private_userList = listProfileEditRepository.findAll();//findAllしたものをprivate_userListに入れる
    ListProfileEditParam listProfileEditParam = new ListProfileEditParam();
    List<ListProfileEditData> list = new ArrayList<ListProfileEditData>();
    System.out.println(private_userList);//検索してprivate_userListに入れたはずのデータが空
    
    // エンティティを画面データに詰め替える
    for(Private_user private_user : private_userList) {
      ListProfileEditData data = new ListProfileEditData();
      data.setId(private_user.getId());
      data.setName(private_user.getName());
      data.setGender(private_user.getGender());
      data.setAge(private_user.getAge());
      data.setDepartment_ID(private_user.getDepartment_ID());
      data.setNyuusya(private_user.getNyuusya());
      data.setSuki(private_user.getSuki());
      data.setHobby(private_user.getHobby());
      data.setComment(private_user.getComment());
      data.setImage(private_user.getImage());
      list.add(data);
      //System.out.println("ここもできてる！！！！！！！");
    }
    
    listProfileEditParam.setListProfileEditDataList(list);
    return listProfileEditParam;
  }
  /**
   * ユーザー情報更新
   * @param param 画面パラメータ
   */
  public void updateAll(ListProfileEditParam param) {
    List<Private_user> private_userList = new ArrayList<Private_user>();
    // 画面パラメータをエンティティに詰め替える
    for (ListProfileEditData data : param.getListProfileEditDataList()) {
      Private_user private_user = listProfileEditRepository.findById(data.getId()).get();
      //System.out.println(private_user);
      private_user.setName(data.getName());
      private_user.setGender(data.getGender());
      private_user.setAge(data.getAge());
      private_user.setDepartment_ID(data.getDepartment_ID());
      private_user.setNyuusya(data.getNyuusya());
      private_user.setSuki(data.getSuki());
      private_user.setHobby(data.getHobby());
      private_user.setComment(data.getComment());
      private_user.setImage(data.getImage());
      private_userList.add(private_user);
     //System.out.println("DB更新してまあああああああああああああああああああああああああす");
    }
    listProfileEditRepository.saveAll(private_userList);
  }
}