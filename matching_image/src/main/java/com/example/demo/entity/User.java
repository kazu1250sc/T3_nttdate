package com.example.demo.entity;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
public class User {
	  /**
     * ID
     */
    private Long id;
  /**
   * 名前
   */
  private String name;
  /**
   * 部署
   */
  private String department;
  /**
   * 性別
   */
  private String gender;
  
  /**
   * 年齢
   */
  private int age;
  
  /**
   * ファイルパス
   */
  private String path;

}