package com.varzac.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varzac.dto.HelloDto;

@Repository 
public interface HelloDao {
	
//	public List<HelloDto> searchBoard() {
//		// TODO Auto-generated method stub
//		return this.sqlSession.selectList("tbBoard.list");
//	}
//
//	public void insertBoard(HelloDto helloDto) {
//		// TODO Auto-generated method stub
//		this.sqlSession.insert("tbBoard.list", helloDto);
//	}
	
	public List<HelloDto> searchBoard();
	public void insertBoard(HelloDto helloDto);
}