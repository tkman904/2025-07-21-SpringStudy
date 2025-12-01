package com.sist.service;

import java.util.*;

import com.sist.vo.*;

/*
 *	클라이언트 ===== Service ===== DAO ===== 오라클
 *                               |
 *                              수정 
 */

public interface FoodService {
	public List<FoodVO> FoodListData(int start, int end);
	public int foodTotalPage();
	public FoodVO foodDetailData(int fno);
	public FoodVO foodCookieData(int fno);
	public List<FoodVO> FoodFindData(Map map);
	public int foodFindTotalPage(String address);
}
