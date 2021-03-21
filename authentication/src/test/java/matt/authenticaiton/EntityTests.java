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

//	@Test
//	public void WhenGetName_CheckName() {
//		
//		Users testUser = new Users();
//		testUser.getName();
//
//		String test = testUser.setName("bob");
//		
//		assertEquals(test, "bob");
//	}

	@Test
	public void WhenSetEmail_CheckEmail() {
		Users testUser = new Users();
		testUser.setEmail("test@test.com");

		String test = testUser.getName();
		
		assertEquals(testUser.getEmail(), "test@test.com");
	}

//	@Test
//	public void WhenGetEmail_CheckEmial() {
//		Users testUser = new Users();
//		testUser.getEmail();
//
//		String test = testUser.getName();
//		
//		assertEquals(testUser.setEmail("accct@gmail.com"), "accct@gmail.com");
//	}

	@Test
	public void WhenSetPassword_CheckPassword() {
		Users testUser = new Users();
		testUser.setPassword("password");

		String test = testUser.getName();
		
		assertEquals(testUser.getPassword(), "password");
	}

//	@Test
//	public void WhenGetPassword_CheckPassword() {
//		Users testUser = new Users();
//		testUser.getPassword();
//
//		String test = testUser.getName();
//		
//		assertEquals(testUser.setPassword("mypassword"), "mypassword");
//	}
}
