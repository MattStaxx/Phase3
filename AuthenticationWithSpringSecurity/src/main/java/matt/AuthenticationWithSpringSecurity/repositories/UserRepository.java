package matt.AuthenticationWithSpringSecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import matt.AuthenticationWithSpringSecurity.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);
	Users findByUserName(String name);
}
