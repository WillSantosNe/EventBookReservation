package project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Finds a user by their email address.
	 *
	 * @param email the email address to search for.
	 * @return an Optional containing the found user, or an empty Optional if no
	 *         user found.
	 */
	Optional<User> findByEmail(String email);
	
	Optional<User> findByUsername(String username);
}