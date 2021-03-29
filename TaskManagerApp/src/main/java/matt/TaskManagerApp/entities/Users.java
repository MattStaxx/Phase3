package matt.TaskManagerApp.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
    private Integer id;

	@Column(name = "user_name")
    private String name;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "password")
    private String password;

//	@Column(name = "task")
	@OneToMany(mappedBy="task_id")
    private Set<Tasks> task;
	
		public Integer getId() { return id; }
        public String getName() { return this.name;}
        public String getEmail() { return this.email;}
        public String getPassword() { return this.password;}
    	//public Tasks getTask() { return this.task;}

    	public void setId(Integer id) { this.id = id; }
        public void setName(String name) { this.name = name;}
        public void setEmail(String email) { this.email = email;}
        public void setPassword(String password) { this.password = password;}
    	//public void setTask(Tasks task) { this.task = task;}
        
//        @Override
//        public String toString() {
//        	return (id.toString() + " " + name + " " + email + " " + password + " " + task);  // 
//        }
}