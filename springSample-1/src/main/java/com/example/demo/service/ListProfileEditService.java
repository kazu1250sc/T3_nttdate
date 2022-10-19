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
import com.example.demo.entity.Profile;
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
    List<Profile> profileList = listProfileEditRepository.findAll();
    ListProfileEditParam listProfileEditParam = new ListProfileEditParam();
    List<ListProfileEditData> list = new ArrayList<ListProfileEditData>();
    
    // エンティティを画面データに詰め替える
    for(Profile profile : profileList) {
      ListProfileEditData data = new ListProfileEditData();
      data.setId(profile.getId());
      data.setName(profile.getName());
      data.setDepartment(profile.getDepartment());
      data.setGender(profile.getGender());
      data.setAge(profile.getAge());
      data.setNyuusya(profile.getNyuusya());
      data.setSuki(profile.getSuki());
      data.setHobby(profile.getHobby());
      data.setComment(profile.getComment());
      list.add(data);
    }
    
    listProfileEditParam.setListProfileEditDataList(list);
    return listProfileEditParam;
  }
  /**
   * ユーザー情報更新
   * @param param 画面パラメータ
   */
  public void updateAll(ListProfileEditParam param) {
    List<Profile> profileList = new ArrayList<Profile>();
    // 画面パラメータをエンティティに詰め替える
    for (ListProfileEditData data : param.getListProfileEditDataList()) {
      Profile profile = listProfileEditRepository.findById(data.getId()).get();
      //System.out.println(profile);
      profile.setName(data.getName());
      profile.setDepartment(data.getDepartment());
      profile.setGender(data.getGender());
      profile.setAge(data.getAge());
      profile.setNyuusya(data.getNyuusya());
      profile.setSuki(data.getSuki());
      profile.setHobby(data.getHobby());
      profile.setComment(data.getComment());
      profileList.add(profile);
      //System.out.println("DB更新してまあああああああああああああああああああああああああす");
    }
    listProfileEditRepository.saveAll(profileList);
  }
}