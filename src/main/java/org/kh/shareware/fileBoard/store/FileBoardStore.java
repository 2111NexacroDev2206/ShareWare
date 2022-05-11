package org.kh.shareware.fileBoard.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.fileBoard.domain.FileBoard;

public interface FileBoardStore  {
	//글 등록
	int insertCommunity(SqlSession sqlsession, FileBoard fileBoard);

}
