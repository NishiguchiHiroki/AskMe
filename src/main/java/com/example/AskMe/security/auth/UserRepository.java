package com.example.AskMe.security.auth;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {
	
	@Select("select id, username, email, password, enabled, authority from users where id = #{id}")
	User findByUserId(int id);
	
	@Select("select id, username, email, password, enabled, authority from users where email = #{email}")
	Optional<User> findByUserEmail(String email);
	
	@Select("select id, username, email, password, enabled, authority from users")
	List<User> findAll();
	
	@Insert("insert into users(username, email, password, enabled, authority, tempkey) values(#{username}, #{username}, #{password}, 1, #{authority}::authority, '1')")
	void insert(@Param("username") String username, @Param("email") String email, @Param("password") String password, @Param("authority") String authority);

}
