package matt.AuthenticationWithSpringSecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import matt.AuthenticationWithSpringSecurity.entities.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

	Roles findByRole(String role);
}
