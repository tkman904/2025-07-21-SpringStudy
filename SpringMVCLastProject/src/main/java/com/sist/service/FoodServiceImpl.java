package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> FoodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.FoodListData(start, end);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return fDao.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

	@Override
	public FoodVO foodCookieData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodCookieData(fno);
	}

	@Override
	public List<FoodVO> FoodFindData(Map map) {
		// TODO Auto-generated method stub
		return fDao.FoodFindData(map);
	}

	@Override
	public int foodFindTotalPage(String address) {
		// TODO Auto-generated method stub
		return fDao.foodFindTotalPage(address);
	}

}
