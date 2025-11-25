package com.sist.service;

import java.util.*;

import com.sist.vo.*;

public interface FoodService {
	public List<FoodVO> foodFindData(Map map);
	
	public int foodFindCount(Map map);
}
