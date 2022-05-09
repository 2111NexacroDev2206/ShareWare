package org.kh.shareware.chat.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.shareware.chat.service.ChatService;
import org.kh.shareware.chat.store.ChatStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatStore cStore;
	
	@Autowired
	private SqlSession sqlSession;
	
}
