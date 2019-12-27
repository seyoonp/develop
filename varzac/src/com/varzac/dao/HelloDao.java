package com.varzac.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.varzac.vo.HelloVo;

@Repository 
public interface HelloDao {
	
//	public List<HelloVO> searchBoard() {
//		// TODO Auto-generated method stub
//		return this.sqlSession.selectList("tbBoard.list");
//	}
//
//	public void insertBoard(HelloVO helloVO) {
//		// TODO Auto-generated method stub
//		this.sqlSession.insert("tbBoard.list", helloVO);
//	}
	@Cacheable("board")
	public List<HelloVo> searchBoard();
	public void insertBoard(HelloVo helloVO);
}