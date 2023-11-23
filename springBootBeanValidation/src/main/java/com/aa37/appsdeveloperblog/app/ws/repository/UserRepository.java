package com.aa37.appsdeveloperblog.app.ws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aa37.appsdeveloperblog.app.ws.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {

}
