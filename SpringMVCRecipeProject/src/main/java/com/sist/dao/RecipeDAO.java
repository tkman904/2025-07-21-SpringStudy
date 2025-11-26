package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	/*
	   	@Select("SELECT no, title, chef, poster, num "
				+ "FROM (SELECT no, title, chef, poster, ROWNUM AS num "
				+ "FROM (SELECT no, title, chef, poster "
				+ "FROM recipe ORDER BY no ASC)) "
				+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
		public int recipeTotalPage();
	 */
	
	public List<RecipeVO> recipeListData(int start, int end) {
		return mapper.recipeListData(start, end);
	}
	
	public int recipeTotalPage() {
		return mapper.recipeTotalPage();
	}
}
