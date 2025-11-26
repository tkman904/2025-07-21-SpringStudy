package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class RecipeController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping("recipe/list.do")
	public String recipe_list(String page, Model model) {
		if(page == null) {
			page = "1";
		}
		
		// 요청 처리
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;
		List<RecipeVO> list = dao.recipeListData(start, end);
		int totalpage = dao.recipeTotalPage();
		
		// 결과값 전송
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		return "recipe/list";
	}
}
