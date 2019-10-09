package com.varzac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varzac.dao.HelloDao;
import com.varzac.dto.HelloDto;

@Service
public class HelloService {

	@Autowired
	private HelloDao helloDao;
	
	public List<HelloDto> searchBoard() {
		// TODO Auto-generated method stub
		return helloDao.searchBoard();
	}

	public void insertBoard(HelloDto helloDto) {
		// TODO Auto-generated method stub
		helloDao.insertBoard(helloDto);
	}
}
