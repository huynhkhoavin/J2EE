package com.grocerystore.service;

import com.grocerystore.domain.Member;
import com.grocerystore.repository.MemberDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MemberService {
	
	@Resource
	private MemberDao memberDao;
	
	public List<Member> getAll() {
		return memberDao.findAll();
	}

}
