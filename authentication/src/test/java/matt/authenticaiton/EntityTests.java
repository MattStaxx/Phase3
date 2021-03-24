package matt.authenticaiton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import matt.authenticaiton.entities.Users;

public class EntityTests {

	@Test
	public void WhenSetName_CheckName() {
		
		Users testUser = new Users();
		testUser.setName("bob");
		
		String test = testUser.getName();
		
		assertEquals(test, "bob");
	}
	
	@Test
	public void WhenSetEmail_CheckEmail() {
		Users testUser = new Users();
		testUser.setEmail("test@test.com");

		String test = testUser.getEmail();
		
		assertEquals(test, "test@test.com");
	}

	@Test
	public void WhenSetPassword_CheckPassword() {
		Users testUser = new Users();
		testUser.setPassword("password");

		String test = testUser.getPassword();
		
		assertEquals(test, "password");
	}
}
