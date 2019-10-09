package com.varzac.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varzac.dto.NoticeDto;

@Repository 
public interface NoticeDao {
	
//	public List<NoticeDto> searchNotice() {
//		// TODO Auto-generated method stub
//		return this.sqlSession.selectList("tbNotice.list");
//	}
//
//	public void insertNotice(NoticeDto noticeDto) {
//		// TODO Auto-generated method stub
//		this.sqlSession.insert("tbNotice.list", noticeDto);
//	}
	
	public List<NoticeDto> searchNotice();
	public void insertNotice(NoticeDto noticeDto);
}