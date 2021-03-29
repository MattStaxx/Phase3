package matt.TaskManagerApp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import matt.TaskManagerApp.entities.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

	public Optional<Users> findByName(String name);
	public Users save(String sql);
}

