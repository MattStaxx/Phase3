package matt.authenticaiton.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import matt.authenticaiton.entities.Users;


public interface UserRepository extends CrudRepository<Users, Integer> {

    public Optional<Users> findByName(String name);
}