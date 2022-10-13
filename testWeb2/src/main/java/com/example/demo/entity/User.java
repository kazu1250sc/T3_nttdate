package com.example.demo.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user_data")
public class User implements Serializable {
  /**
   * ID
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * 姓
   */
  @Column(name = "last_name")
  private String last_name;
  /**
   * 名
   */
  @Column(name = "first_name")
  private String first_name;
  /**
   * 性別
   */
  @Column(name = "sex")
  private String sex;
  /**
   * メールアドレス
   */
  @Column(name = "email")
  private String email;
  /**
   * 更新日時
   */
  @Column(name = "password")
  private String password;

}