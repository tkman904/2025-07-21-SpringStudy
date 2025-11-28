package com.sist.dao;
// Mapper구현

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	/*
		@Select("SELECT no, name, subject, TO_CHAR(regdate, 'yyyy-mm-dd') AS dbday, hit "
				+ "FROM springDataBoard ORDER BY no DESC "
				+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
		public List<DataBoardVO> databoardListData(int start);
	 */	
	public List<DataBoardVO> databoardListData(int start) {
		return mapper.databoardListData(start);
	}
	
	/*
	  	@Select("SELECT COUNT(*) FROM springDataBoard")
		public int databoardRowCount();
	 */
	public int databoardRowCount() {
		return mapper.databoardRowCount();
	}
	
	/*
		@Insert("INSERT INTO springDataBoard "
				+ "VALUES(sdb_no_seq.nextval, #{name}, #{subject}, #{content}, "
				+ "#{pwd}, SYSDATE, 0, #{filename}, #{filesize}, #{filecount})")
		public void databoardInsert(DataBoardVO vo); // => 업로드
	 */
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	
	/*
	   	@Update("UPDATE springDataBoard SET "
				+ "hit = hit+1 "
				+ "WHERE no = #{no}")
		public void hitIncrement(int no);
		
		@Select("SELECT no, name, subject, content, hit, filename, filesize, filecount, "
				+ "TO_CHAR(regdate, 'yyyy-mm-dd hh24:mi:ss') AS dbday "
				+ "FROM springDataBoard "
				+ "WHERE no = #{no}")
		public DataBoardVO databoardDetailData(int no);
	 */
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	
	/*
	   	@Select("SELECT filename, filesize, filecount "
				+ "FROM springDataBoard "
				+ "WHERE no = #{no}")
		public DataBoardVO databoardFileInfoData(int no);
		
		@Select("SELECT pwd FROM springDataBoard WHERE no = #{no}")
		public String databoardGetPassword(int no);
		
		@Delete("DELETE FROM springDataBoard WHERE no = #{no}")
		public void databoardDelete(int no);
	 */
	public DataBoardVO databoardFileInfoData(int no) {
		return mapper.databoardFileInfoData(no);
	}
	
	public String databoardGetPassword(int no) {
		return mapper.databoardGetPassword(no);
	}
	
	public void databoardDelete(int no) {
		mapper.databoardDelete(no);
	}
	
	public DataBoardVO databoardUpdateData(int no) {
		return mapper.databoardDetailData(no);
	}
	
	/*
	   	@Update("UPDATE springDataBoard SET "
				+ "name = #{name}, subject = #{subject}, content = #{content} "
				+ "WHERE no = #{no}")
		public void databoardUpdate(DataBoardVO vo);
	 */
	public void databoardUpdate(DataBoardVO vo) {
		mapper.databoardUpdate(vo);
	}
}
