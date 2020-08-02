package com.api.restfull.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.restfull.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
	
	@Transactional(readOnly = true)
	Optional<Users> findByUsername(String username);
	

}
