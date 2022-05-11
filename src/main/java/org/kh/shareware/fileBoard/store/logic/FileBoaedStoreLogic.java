package org.kh.shareware.fileBoard.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.fileBoard.domain.FileBoard;
import org.kh.shareware.fileBoard.store.FileBoardStore;
import org.springframework.stereotype.Repository;

@Repository
public class FileBoaedStoreLogic implements FileBoardStore{

	@Override
	public int insertCommunity(SqlSession sqlsession, FileBoard fileBoard) {
		int result = sqlsession.insert("FileBoardMapper.insertFile", fileBoard);
		return result;
	}
}
