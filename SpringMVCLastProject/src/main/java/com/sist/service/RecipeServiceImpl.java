package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeDAO rDao;

	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(start, end);
	}
	
	@Override
	public int recipeCount() {
		// TODO Auto-generated method stub
		return rDao.recipeCount();
	}
}