package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	/*
	   	@Select("SELECT no, goods_poster, goods_name, goods_price, num "
				+ "FROM (SELECT no, goods_poster, goods_name, goods_price, ROWNUM AS num "
				+ "FROM (SELECT no, goods_poster, goods_name, goods_price "
				+ "FROM goods_all ORDER BY no ASC)) "
				+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<GoodsVO> goodsListData(@Param("start") int start, @Param("end") int end);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
		public int goodsTotalPage();
		
		@Select("SELECT * FROM goods_all "
				+ "WHERE no = #{no}")
		public GoodsVO goodsDetailData(int no);
	 */
	public List<GoodsVO> goodsListData(int start, int end) {
		return mapper.goodsListData(start, end);
	}
	
	public int goodsTotalPage() {
		return mapper.goodsTotalPage();
	}
	
	public GoodsVO goodsDetailData(int no) {
		return mapper.goodsDetailData(no);
	}
}
