package com.varzac.dao;

import org.springframework.stereotype.Repository;

import com.varzac.vo.FileVo;

@Repository 
public interface FileDao {
	public FileVo selectFile(int fileIdx);
	public void insertFile(FileVo fileVo);
}