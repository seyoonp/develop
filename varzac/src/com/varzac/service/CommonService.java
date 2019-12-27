package com.varzac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varzac.dao.FileDao;
import com.varzac.vo.FileVo;

@Service
public class CommonService {

	@Autowired
	private FileDao fileDao;
	
	public FileVo selectFile(int fileIdx) {
		// TODO Auto-generated method stub
		return fileDao.selectFile(fileIdx);
	}

	public void insertFile(FileVo FileVO) {
		// TODO Auto-generated method stub
		fileDao.insertFile(FileVO);
	}
}