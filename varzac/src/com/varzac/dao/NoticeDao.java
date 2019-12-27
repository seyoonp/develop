package com.varzac.dao;

import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import com.varzac.vo.NoticeVo;

@Repository 
public interface NoticeDao {
	
//	public List<NoticeVO> searchNotice() {
//		// TODO Auto-generated method stub
//		return this.sqlSession.selectList("tbNotice.list");
//	}
//
//	public void insertNotice(NoticeVO noticeVO) {
//		// TODO Auto-generated method stub
//		this.sqlSession.insert("tbNotice.list", noticeVO);
//	}
	
	public List<NoticeVo> searchNotice();
	public void insertNotice(NoticeVo noticeVO);
}