package org.kh.shareware.fileBoard.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.fileBoard.domain.FileBoard;
import org.kh.shareware.fileBoard.service.FileBoardService;
import org.kh.shareware.fileBoard.store.FileBoardStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileBoardServiceImpl implements FileBoardService{
	@Autowired
	private FileBoardStore fStore;
	@Autowired
	private SqlSession sqlsession;
	
	
	@Override
	public int registerCommunity(FileBoard fileBoard) {
		int result = fStore.insertCommunity(sqlsession, fileBoard);
		return result;
	}

}
