package com.example.demo.contrloller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRequest;
import com.example.demo.service.UserService;


/**
 * ユーザー情報 Controller
 */
@Controller
public class NttDateController {
	
	/**
	 * ユーザーじょうほう
	 */
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/NTTDate_html")
	public String common(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "NTTDate_html";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {

	    if (result.hasErrors()) {
	      // 入力チェックエラーの場合
	      List<String> errorList = new ArrayList<String>();
	      for (ObjectError error : result.getAllErrors()) {
	        errorList.add(error.getDefaultMessage());
	      }
	      model.addAttribute("validationError", errorList);
	      return "NTTDate_html";
	    }
	    // ユーザー情報の登録
	    userService.create(userRequest);
	    return "redirect:/mode_select";
	  }
  
	@GetMapping("/mode_select")
	public String mode_select(String mode_select) {
		return mode_select;
	}
}