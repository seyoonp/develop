package com.varzac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varzac.dao.HelloDao;
import com.varzac.vo.HelloVo;

@Service
public class BoardService {

	@Autowired
	private HelloDao helloDao;
	
	public List<HelloVo> searchBoard() {
		// TODO Auto-generated method stub
		return helloDao.searchBoard();
	}

	public void insertBoard(HelloVo helloVO) {
		// TODO Auto-generated method stub
		helloDao.insertBoard(helloVO);
	}
}
