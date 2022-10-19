package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.PathVariable;

//import com.example.demo.dto.ListProfileEditData;
import com.example.demo.dto.ListProfileEditParam;
import com.example.demo.service.ListProfileEditService;

@Controller
public class ListProfileEditController{
	
		@Autowired
		private ListProfileEditService listProfileEditService;
		
		//マッチ候補一覧画面を表示
		/*@GetMapping(value = "/user/list")
		public String list(Model model){
			List<Profile>matchlist = listProfileEditService.searchAll();
			model.addAttribute("matchlist", matchlist);
			return "user/list"; 
		}*/
	
	
		//プロフィール画面を表示（ユーザー情報一覧画面を表示）
		@GetMapping(value = "/profile/myprofile")
		public String myprofile(Model model){
			ListProfileEditParam listProfileEditParam = listProfileEditService.searchAll();
			model.addAttribute("listProfileEditParam", listProfileEditParam.getListProfileEditDataList());//画面に変数を与える
			return "profile/myprofile";
		}
	
		//プロフィール編集画面を表示
		@GetMapping(value = "/profile/edit")
		public String nandemo(Model model){
			ListProfileEditParam listProfileEditParam = listProfileEditService.searchAll();
			model.addAttribute("listProfileEditParam", listProfileEditParam);
			return "profile/edit";
		}
		
		//プロフィール編集（ユーザー情報一覧更新）
		@RequestMapping(value = "/profile/editUpdate",method = RequestMethod.POST)
		public String edit(@ModelAttribute ListProfileEditParam listProfileEditParam,/*BindingResult result,*/ Model model) {


		   /* if (result.hasErrors()) {
		      List<String> errorList = new ArrayList<String>();

		      for (ObjectError error : result.getAllErrors()) {
		        if (!errorList.contains(error.getDefaultMessage())) {
		          errorList.add(error.getDefaultMessage());
		        }
		      }
		      model.addAttribute("validationError", errorList);
		      return "profile/edit";
		    }*/
			
			//プロフィール更新（ユーザー情報の更新）
			listProfileEditService.updateAll(listProfileEditParam);
			//ListProfileEditParam listProfileEditParam2 = listProfileEditService.searchAll();
			model.addAttribute("listProfileEditParam", listProfileEditParam.getListProfileEditDataList());
			return "profile/myprofile";
		}

}

