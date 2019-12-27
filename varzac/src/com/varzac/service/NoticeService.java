package com.varzac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varzac.dao.HelloDao;
import com.varzac.dao.NoticeDao;
import com.varzac.vo.HelloVo;
import com.varzac.vo.NoticeVo;

@Service
public class NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private HelloDao helloDao;
	
	public List<NoticeVo> searchNotice() {
		// TODO Auto-generated method stub
		return noticeDao.searchNotice();
	}

	public void insertNotice(NoticeVo boardVO) {
		// TODO Auto-generated method stub
		noticeDao.insertNotice(boardVO);
	}
	
	public void insertHelloNotice(HelloVo helloVO, NoticeVo boardVO) {
		// TODO Auto-generated method stub
		helloDao.insertBoard(helloVO);
		noticeDao.insertNotice(boardVO);
	}
}
