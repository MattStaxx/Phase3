package matt.authenticaiton;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import matt.authenticaiton.entities.Users;
import matt.authenticaiton.repositories.UserRepository;
import matt.authenticaiton.services.UserService;

import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

@DataJpaTest
public class AuthenticationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        Users dummyUser = new Users();
        dummyUser.setName("Dummy");
        dummyUser.setEmail("test@test.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();
        // when
        Optional<Users> found = userRepository.findByName(dummyUser.getName());
        // then
        assertEquals(found.get(), dummyUser);
    }
    
    @Test
    public void whenGetPassword_thenReturnBoolean() {

    	UserService uServ = new UserService();
    	
        Users dummyUser = new Users();
        dummyUser.setName("Dummy");
        dummyUser.setEmail("test@test.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();
        
        String test = dummyUser.getPassword();
        
    	assertEquals(test, "password");
    }
}
