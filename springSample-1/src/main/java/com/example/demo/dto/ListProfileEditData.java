package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
/**
 * ユーザー情報
 */
@Data
public class ListProfileEditData implements Serializable {
  /**
   * ID
   */
  private Long id;
  /**
   * 名前
   */
  @NotEmpty(message = "名前を入力してください")
  @Size(max = 100, message = "名前は100文字以内で入力してください")
  private String name;
  /**
   * 性別
   */
  @NotEmpty(message = "性別を入力してください")
  @Size(max = 50, message = "性別は50文字以内で入力してください")
  private String gender;
  /**
   * 年齢
   */
  @NotEmpty(message = "年齢を入力してください")
  @Range(min=22, max=65, message = "年齢は22歳以上で入力してください")//数値範囲の指定の仕方あってる？
  //@Max(65, message = "年齢は65歳以下で入力してください")
  private int age;
  /**
   * 部署ID
   */
  @NotEmpty(message = "部署を入力してください")
  private int department_ID;
  /**
   * 入社年度
   */
  @NotEmpty(message = "入社年度を入力してください")
  private int nyuusya;
  /**
   * 好きなタイプ
   */
  @NotEmpty(message = "好きなタイプを入力してください")
  @Size(max = 100, message = "好きなタイプは100文字以内で入力してください")
  private String suki;
  /**
   * 趣味
   */
  @NotEmpty(message = "趣味を入力してください")
  @Size(max = 100, message = "趣味は100文字以内で入力してください")
  private String hobby;
  /**
   * 一言
   */
  @NotEmpty(message = "一言を入力してください")
  @Size(max = 300, message = "一言は300文字以内で入力してください")
  private String comment;
  /**
   * 写真
   */
  private String image;
}