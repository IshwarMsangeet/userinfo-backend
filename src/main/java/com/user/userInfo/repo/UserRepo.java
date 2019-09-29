package com.user.userInfo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.userInfo.entity.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>{

	@Query("{$or : [{'userName': { $regex: ?0, $options:'i' }},{'address': { $regex: ?0, $options:'i' }}, {'phoneNumber': { $regex: ?0, $options:'i' }}]}")
	List<User> findUserByRegexString(String regexString);

}
