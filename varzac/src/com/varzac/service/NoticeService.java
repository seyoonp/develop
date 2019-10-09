package com.varzac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varzac.dao.HelloDao;
import com.varzac.dao.NoticeDao;
import com.varzac.dto.HelloDto;
import com.varzac.dto.NoticeDto;

@Service
public class NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private HelloDao helloDao;
	
	public List<NoticeDto> searchNotice() {
		// TODO Auto-generated method stub
		return noticeDao.searchNotice();
	}

	public void insertNotice(NoticeDto boardDto) {
		// TODO Auto-generated method stub
		noticeDao.insertNotice(boardDto);
	}
	
	public void insertHelloNotice(HelloDto helloDto, NoticeDto boardDto) {
		// TODO Auto-generated method stub
		helloDao.insertBoard(helloDto);
		noticeDao.insertNotice(boardDto);
	}
}
