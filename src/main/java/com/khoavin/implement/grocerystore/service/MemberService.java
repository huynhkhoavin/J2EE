package com.khoavin.implement.grocerystore.service;

import com.khoavin.implement.grocerystore.domain.Member;
import com.khoavin.implement.grocerystore.repository.MemberDao;
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
