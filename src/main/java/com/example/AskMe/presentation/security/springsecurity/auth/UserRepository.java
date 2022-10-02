package com.example.AskMe.presentation.security.springsecurity.auth;


import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.postgresql.util.PGTimestamp;

import com.example.AskMe.domain.model.customer.User;

@Mapper
public interface UserRepository {
	
	@Select("select id, username, email, password, enabled, authority from users where id = #{id}")
	User findByUserId(int id);
	
	@Select("select id, username, email, password, enabled, authority from users where email = #{email}")
	Optional<User> findByUserEmail(String email);
	
	@Select("select id, username, email, password, enabled, authority from users")
	List<User> findAll();
	
	@Insert("insert into users(username, email, password, enabled, authority, createtime, update) values(#{username}, #{email}, #{password}, 1, #{authority}::authority, #{createtime}, #{update})" )
	void insert(@Param("username") String username, @Param("email") String email, @Param("password") String password, @Param("authority") String authority, @Param("createtime") PGTimestamp createtime, @Param("update") PGTimestamp update);

}
