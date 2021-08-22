package org.itbl.repository;

import org.itbl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	
	public User findByName(String name);
}
