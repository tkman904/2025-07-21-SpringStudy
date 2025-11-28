package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class DataBoardServiceImpl implements DataBoardService {
	@Autowired
	private DataBoardDAO dao;
	
	@Override
	public List<DataBoardVO> databoardListData(int start) {
		// TODO Auto-generated method stub
		return dao.databoardListData(start);
	}

	@Override
	public int databoardRowCount() {
		// TODO Auto-generated method stub
		return dao.databoardRowCount();
	}
	
	@Override
	public void databoardInsert(DataBoardVO vo) {
		// TODO Auto-generated method stub
		dao.databoardInsert(vo);
	}

	@Override
	public DataBoardVO databoardDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.databoardDetailData(no);
	}

	@Override
	public boolean databoardDelete(int no, String pwd) {
		// TODO Auto-generated method stub
		boolean bCheck = false;
		String db_pwd = dao.databoardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			bCheck = true;
			dao.databoardDelete(no);
		}
		return bCheck;
	}

	@Override
	public DataBoardVO databoardFileInfoData(int no) {
		// TODO Auto-generated method stub
		return dao.databoardFileInfoData(no);
	}

	@Override
	public DataBoardVO databoardUpdateData(int no) {
		// TODO Auto-generated method stub
		return dao.databoardUpdateData(no);
	}

	@Override
	public boolean databoardUpdate(DataBoardVO vo) {
		// TODO Auto-generated method stub
		boolean bCheck = false;
		String db_pwd = dao.databoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			bCheck = true;
			dao.databoardUpdate(vo);
		}
		return bCheck;
	}
}
