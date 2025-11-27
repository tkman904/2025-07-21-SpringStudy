package com.sist.mapper;
// 메소드 선언 => 자동 구현 (SQL) => JAP => @Query
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;

public interface RecipeMapper {
	@Select("SELECT no, poster, title, chef, num "
			+ "FROM (SELECT no, poster, title, chef, ROWNUM AS num "
			+ "FROM (SELECT no, poster, title, chef "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail) "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)")
	public int recipeTotalPage();
	
	@Select("SELECT no, poster, title, chef, num "
			+ "FROM (SELECT no, poster, title, chef, ROWNUM AS num "
			+ "FROM (SELECT no, poster, title, chef "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail) "
			+ "AND ${column} LIKE '%'||#{fd}||'%' "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail) "
			+ "AND ${column} LIKE '%'||#{fd}||'%'")
	public int recipeFindTotalPage(Map map);
}
