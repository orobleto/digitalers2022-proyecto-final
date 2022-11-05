package com.educaciontit.digitalers.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.educaciontit.digitalers.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	

	// HQL
	// SQL
	@Modifying
	@Transactional
	@Query("UPDATE User u set u.failedAttemps = :failedAttemps where u.email = :email")
	// void incremetFailedAttemps(@Param("email") String email);
	// @Query(value = "update users set failedAttemps = 1 where email = ?1
	// ",nativeQuery = true)
	void updateFailedAttemps(@Param("failedAttemps") Byte failedAttemps, @Param("email") String email);

}
