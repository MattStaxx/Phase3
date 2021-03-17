package matt.usermanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;

	@Column(name = "name")
    private String name;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "password")
    private String password;
	
    	public Integer getId() { return id; }
        public String getName() { return this.name;}
        public String getEmail() { return this.email;}
        public String getPassword() { return this.password;}

    	public void setId(Integer id) { this.id = id; }
        public void setName(String name) { this.name = name;}
        public void setEmail(String email) { this.email = email;}
        public void setPassword(String password) { this.password = password;}
        
        @Override
        public String toString() {
        	return (id.toString() + " " + name + " " + email + " " + password);  // 
        }
}