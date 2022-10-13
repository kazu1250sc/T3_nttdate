package com.example.demo.dto;
import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
  /**
   * 姓
   */
  @NotEmpty(message = "姓を入力してください")
  @Size(max = 30, message = "姓は30文字以内で入力してください")
  private String last_name;
  /**
   * 名
   */
  @NotEmpty(message = "名を入力してください")
  @Size(max = 30, message = "名は30文字以内で入力してください")
  private String first_name;
  /**
   * 性別
   */
  @NotEmpty(message = "性別を入力してください")
  @Size(max = 10, message = "住所は255桁以内で入力してください")
  private String sex;
  /**
   * e-mail
   */
  @NotEmpty(message = "メールアドレスを入力してください")
  @Size(max = 100, message = "メールアドレスは100文字以内で入力してください")
  @Pattern(regexp = "^([\\w])+([\\w\\._-])*\\@(nttdata\\.com)+$", message = "NTTデータのメールアドレスで登録してください")
  //@Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください")
  private String email;
  /**
   * パスワード
   */
  @NotEmpty(message = "パスワードを入力してください")
  @Size(max = 30, message = "パスワードは30文字以内で入力してください")
  private String password;
  private String confirmPassword;
  @AssertTrue(message = "パスワードが一致しません")
  public boolean isPassValid() {
	  if(password == null || password.isEmpty()) {
		  return true;
	  }
	  return password.equals(confirmPassword);
  }
}