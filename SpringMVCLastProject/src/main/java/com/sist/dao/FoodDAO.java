package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class FoodDAO {
	// 구현된 Mapper클래스 읽기기
	@Autowired
	private FoodMapper mapper;
	
	/*
	   	@Select("SELECT fno, name, poster, num "
				+ "FROM (SELECT fno, name, poster, ROWNUM AS num "
				+ "FROM (SELECT fno, name, poster "
				+ "FROM menupan_food ORDER BY fno ASC)) "
				+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
		public int foodTotalPage();
	 */
	public List<FoodVO> foodListData(int start, int end) {
		return mapper.foodListData(start, end);
	}
	
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	
	/*
	   	@Update("UPDATE menupan_food SET "
				+ "hit = hit+1 "
				+ "WHERE fno = #{fno}")
		public void foodHitIncrement(int fno);
		
		@Select("SELECT fno, name, poster, images, address, phone, parking, time, type, score, theme, content, price "
				+ "FROM menupan_food "
				+ "WHERE fno = #{fno}")
		public FoodVO foodDetailData(int fno);
	 */
	public FoodVO foodDetailData(int fno) {
		mapper.foodHitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	
	public FoodVO foodCookieData(int fno) {
		return mapper.foodDetailData(fno);
	}
	
	/*
	   	@Select("SELECT fno, name, poster, num "
				+ "FROM (SELECT fno, name, poster, ROWNUM AS num "
				+ "FROM (SELECT fno, name, poster "
				+ "FROM menupan_food "
				+ "WHERE REGEXP_LIKE(address, #{address}) "
				+ "ORDER BY fno ASC)) "
				+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> FoodFindData(Map map);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food "
				+ "WHERE REGEXP_LIKE(address, #{address})")
		public int foodFindTotalPage(String address);
	 */
	public List<FoodVO> foodFindData(Map map) {
		return mapper.foodFindData(map);
	}
	
	public int foodFindTotalPage(String address) {
		return mapper.foodFindTotalPage(address);
	}
	
	/*
		@Select("SELECT fno, name, poster, num "
				+ "FROM (SELECT fno, name, poster, ROWNUM AS num "
				+ "FROM (SELECT fno, name, poster "
				+ "FROM menupan_food "
				+ "WHERE REGEXP_LIKE(type, #{type}) "
				+ "ORDER BY fno ASC)) "
				+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodTypeData(Map map);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food "
				+ "WHERE REGEXP_LIKE(type, #{type})")
		public int foodTypeTotalPage(String type);
	 */
	public List<FoodVO> foodTypeData(Map map) {
		return mapper.foodTypeData(map);
	}
	
	public int foodTypeTotalPage(String type) {
		return mapper.foodTypeTotalPage(type);
	}
}
