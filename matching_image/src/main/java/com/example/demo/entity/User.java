package com.example.demo.entity;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
public class User {
  /*ID*/
  private Long id;
  /*名前*/
  private String name;
  /*性別*/
  private String gender;
  /*年齢*/
  private int age;
  /*画像*/
  private String image;
  /*事業本部*/
  private String department_name;
  /*入社年度*/
  private int nyuusya;
  /*好きなタイプ*/
  private String like;
  /*趣味*/
  private String hobby;
  /*一言コメント*/
  private String comment;
}