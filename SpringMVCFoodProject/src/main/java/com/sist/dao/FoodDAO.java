package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	/*
	   	@Select("SELECT fno, name, type, poster, num "
				+ "FROM (SELECT fno, name, type, poster, ROWNUM AS num "
				+ "FROM (SELECT fno, name, type, poster "
				+ "FROM food ORDER BY fno ASC)) "
				+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM food")
		public int foodTotalPage();
	 */
	public List<FoodVO> foodListData(int start, int end) {
		return mapper.foodListData(start, end);
	}
	
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	
	/*
	   	@Select("SELECT fno, name, type, poster, address, num "
				+ "FROM (SELECT fno, name, type, poster, address, ROWNUM AS num "
				+ "FROM (SELECT fno, name, type, poster, address "
				+ "FROM menupan_food "
				+ "WHERE address LIKE '%'||#{fd}||'%' "
				+ "ORDER BY fno ASC)) "
				+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<FoodVO> foodFindListData(Map map);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food "
				+ "WHERE address LIKE '%'||#{fd}||'%'")
		public int foodFindTotalPage(String fd);
	 */
	public List<FoodVO> foodFindListData(Map map) {
		return mapper.foodFindListData(map);
	}
	
	public int foodFindTotalPage(String fd) {
		return mapper.foodFindTotalPage(fd);
	}
}
