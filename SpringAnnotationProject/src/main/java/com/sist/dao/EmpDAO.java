package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	/*
	  	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') AS dbday "
				+ "FROM emp ORDER BY empno")
		public List<EmpVO> empListData();

		@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') AS dbday, dname, loc "
				+ "FROM emp, dept "
				+ "WHERE emp.deptno = dept.deptno "
				+ "AND empno = #{empno}")
		public EmpVO empDetailData(int empno);
	 */
	public List<EmpVO> empListData() {
		return mapper.empListData();
	}
	
	public EmpVO empDetailData(int empno) {
		return mapper.empDetailData(empno);
	}
}
