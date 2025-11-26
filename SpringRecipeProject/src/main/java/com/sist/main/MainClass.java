package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.service.RecipeService;
import com.sist.vo.RecipeVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("검색할 카테고리 선택: (1. 레시피명, 2. 쉐프명)");
		String column = "";
		int cate = scan.nextInt();
		String[] strColumn = {"", "title", "chef"};
		System.out.print("검색어 입력: ");
		String ss = scan.next();
		
		Map map = new HashMap();
		map.put("column", strColumn[cate]);
		map.put("ss", ss);
		
		RecipeService rs = (RecipeService)app.getBean("recipeServiceImpl");
		int count = rs.recipeFindCount(map);
		List<RecipeVO> list = rs.recipeFindData(map);
		System.out.println("검색결과: " + count + "건");
		for(RecipeVO vo : list) {
			System.out.println(vo.getTitle() + " " + vo.getChef());
		}
	}
}
