package com.example.demo.dto;
import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
  /**
   * 好きなタイプ
   */
  @Size(max = 100, message = "好きなタイプは100字以内で入力してください")
  private String suki;
  /**
   * 趣味
   */
  @Size(max = 100, message = "趣味は100字以内で入力してください")
  private String hoby;
  /**
   * 一言
   */
  @Size(max = 300, message = "一言は300字以内で入力してください")
  private String comment;
  /**
   * プライベート画像設定
   */
  @Size(max = 300, message = "プライベート画像設定は100字以内で入力してください")
  private String image;
}