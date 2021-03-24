package matt.authenticaiton;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import matt.authenticaiton.entities.Users;
import matt.authenticaiton.repositories.UserRepository;

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

        Users dummyUser = new Users();
        dummyUser.setName("Dummy");
        dummyUser.setEmail("test@test.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();
        
        Optional<Users> found = userRepository.findByName(dummyUser.getName());
        
        assertEquals(found.get(), dummyUser);
    }
    
    @Test
    public void whenNameNotExists_thenThrowException() throws Exception {
    	
    	String exception = "Exception thrown...";
    	Users dummyUser = new Users();
        dummyUser.setName("Dummy");
        dummyUser.setEmail("test@test.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();
        
        Optional<Users> searchingFor = userRepository.findByName("Mummy");
        Optional<Users> notFound = userRepository.findByName("");
        if(!searchingFor.isPresent()) {
        	System.out.println(exception);
        }

        assertEquals(searchingFor, notFound);
    }
    
    @Test
    public void whenGetPassword_thenReturnBoolean() {
    	
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
