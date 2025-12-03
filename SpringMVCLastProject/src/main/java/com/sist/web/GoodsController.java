package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//화면 이동
@Controller
public class GoodsController {
	@GetMapping("goods/list.do")
	public String goods_list(Model model) { // route
		model.addAttribute("main_jsp", "../goods/list.jsp");
		return "main/main";
	}
}
