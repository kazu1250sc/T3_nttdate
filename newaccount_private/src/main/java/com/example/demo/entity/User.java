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
@Table(name = "user")
public class User implements Serializable {
  /**
   * ID
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * 好きなタイプ
   */
  @Column(name = "suki")
  private String suki;
  /**
   * 趣味
   */
  @Column(name = "hoby")
  private String hoby;
  /**
   * 一言
   */
  @Column(name = "comment")
  private String comment;
  /**
   * プライベート画像設定
   */
  @Column(name = "image")
  private String image;
}