package com.grocerystore.repository;

import com.grocerystore.domain.Member;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MemberDao extends Repository<Member, Integer> {
	
	List<Member> findAll();
	
	List<Member> findByUsername(String username);
        
        Member findOne(Integer id);
	
}
