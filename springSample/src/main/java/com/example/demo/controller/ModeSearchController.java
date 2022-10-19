package com.example.demo.controller;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;

//import com.example.demo.entity.User;
//import com.example.demo.service.ModeSerchService;

@Controller
public class ModeSearchController{
	
	//@Autowired
	//private ModeSearchService modeSearchService;
	
	//モード選択画面を表示
	@GetMapping(value = "/user/mode_select")
	public String modeSelect(Model model){
		//List<String>modeselect = new modeSearchService<String>();
		//model.addAttribute("modeselect", modeselect);
		return "user/mode_select"; //mode/select?
	}


//条件検索画面を表示
@GetMapping(value = "/user/search")
public String search(Model model){
	return "user/search";
}


}
