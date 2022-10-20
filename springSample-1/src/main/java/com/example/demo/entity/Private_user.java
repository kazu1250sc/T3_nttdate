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
@Table(name = "private_user")
public class Private_user implements Serializable {
  /**
   * ID
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * 名前
   */
  @Column(name = "name")
  private String name;
  /**
   * 性別
   */
  @Column(name = "gender")
  private String gender;
  /**
   * 年齢
   */
  @Column(name = "age")
  private int age;
  /**
   * 部署ID
   */
  @Column(name = "department_ID")
  private int department_ID;
  /**
   * 入社年度
   */
  @Column(name = "nyuusya")
  private int nyuusya;
  /**
   *　好きなタイプ
   */
  @Column(name = "suki")
  private String suki;
  /**
   * 趣味
   */
  @Column(name = "hobby")
  private String hobby;
  /**
 　* 一言
   */
  @Column(name = "comment")
  private String comment;
  /**
 　* 写真
   */
  @Column(name = "image")
  private String image;
  /**
   * 登録日時
   */
  /*@Column(name = "image")
  private Date image;*/
  /**
   * 削除日時
   */
}