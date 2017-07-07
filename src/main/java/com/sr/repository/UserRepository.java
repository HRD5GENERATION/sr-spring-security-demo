package com.sr.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sr.model.Role;
import com.sr.model.User;

@Repository
public interface UserRepository {

	@Select("Select id, username, password, status From tbuser Where username=#{username}")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="roles", column="id", many=@Many(select="findRoleByUserId"))
	})
	User loadUserByUsername(String username);

	@Select("Select r.id, r.role From tbrole r Inner Join tbuser_role ur on r.id=ur.role_id Where ur.user_id=#{id}")
	List<Role> findRoleByUserId(int id);

}
