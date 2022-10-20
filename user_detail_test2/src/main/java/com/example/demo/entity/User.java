package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "private_user" )
public class User implements Serializable {
  /*
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
   * 入社年度
   */
  @Column(name = "nyuusya")
  private String nyuusya;
  /**
   * 年齢
   */
  @Column(name = "age")
  private String age;
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
   * 事業本部
   @Column(name = "department_ID")
  private int department_ID;
   * */
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "department_ID")
  private Department department;

}