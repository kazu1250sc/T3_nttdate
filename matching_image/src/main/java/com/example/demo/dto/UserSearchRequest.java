package com.example.demo.dto;
import java.io.Serializable;

import lombok.Data;
/**
 * ユーザー情報 検索用リクエストデータ
 */
@Data
public class UserSearchRequest implements Serializable {
  /**
   * 性別
   */
  private String gender;
  
  /**
   * 性別
   */
  private int agestart;
  
  /**
   * 性別
   */
  private int ageend;
  
  
}