package matt.authenticaiton;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import matt.authenticaiton.entities.Users;
import matt.authenticaiton.repositories.UserRepository;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AuthenticationWebTests {

    @LocalServerPort
    private int port;
	
    @Autowired
	UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnWelcome() throws Exception {

        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnIndex() throws Exception {

        this.mockMvc.perform(get("/index")).andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    public void testDatabaseConnect() {

    	Iterable<Users> users = userRepository.findAll();
    	int count = 0;
    	for(Users u : users) {
    		count++;
    	}
    	assertNotEquals(count, 0);
    }
}