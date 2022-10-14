package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/user/list")
  public String displayList(Model model) {
    return "user/list";
  }
  /**
   * ログイン画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/user/view")
  public String displayView(Model model) {
    return "user/view";
  }
  /**
   * アカウント作成画面を表示
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/user/add")
  public String displayAdd(Model model) {
    return "user/add";
  }
}