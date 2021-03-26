package matt.AuthenticationWithSpringSecurity.entities;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	@NotEmpty(message="Enter your name")
	private String name;

	@Column(name="email")
	@Email(message="Enter a valid email")
	@NotEmpty(message="Be sure to enter an email")
	private String email;

    @Column(name="user_name")
    @Length(min=5, message="*Your user name must have at least 5 characters")
    @NotEmpty(message="*Please provide a user name")
    private String userName;
    
	@Column(name="password")
	@Length(min=5, message="Password must contain at least 5 characters")
	@NotEmpty(message="Be sure to enter a password")
	private String password;
	
	@Column(name="active")
	private boolean active;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="name"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Roles> role;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Roles> getRoles() {
		return role;
	}

	public void setRoles(Set<Roles> role) {
		this.role = role;
	}
}
