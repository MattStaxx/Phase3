package matt.usermanager.repositories;

import org.springframework.data.repository.CrudRepository;

import matt.usermanager.entities.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {

	public Users findByName(String name);
	public Users save(String sql);
}
