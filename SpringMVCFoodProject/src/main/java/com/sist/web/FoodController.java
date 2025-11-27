package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/list.do")
	public String food_list(String page, Model model) {
		if(page == null) {
			page = "1";
		}
		
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curpage * rowSize) - (rowSize - 1);
		int end = curpage * rowSize;
		List<FoodVO> list = dao.foodListData(start, end);
		int totalpage = dao.foodTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		return "food/list";
	}
	
	@RequestMapping("food/find.do")
	public String food_find(String page, String fd, Model model) {
		if(page == null) {
			page = "1";
		}
		if(fd == null) {
			fd = "서교";
		}
		
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curpage * rowSize) - (rowSize - 1);
		int end = curpage * rowSize;
		
		Map map = new HashMap();
		map.put("fd", fd);
		map.put("start", start);
		map.put("end", end);
		
		List<FoodVO> list = dao.foodFindListData(map);
		int totalpage = dao.foodFindTotalPage(fd);
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("fd", fd);
		
		return "food/find";
	}
}
