package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import lombok.Data;
/**
 * プロフィール画面用データクラス（ユーザー情報一覧画面用 データクラス）
 */
@Data
public class ListProfileEditParam implements Serializable {
  /**
   * ユーザー情報リスト
   */
  @Valid
  private List<ListProfileEditData> listProfileEditDataList;
 
}