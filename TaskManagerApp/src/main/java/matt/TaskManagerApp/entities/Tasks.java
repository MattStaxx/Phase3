package matt.TaskManagerApp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tasks")
public class Tasks implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private Integer task_id;
	
	@Column(name="task_name")
	private String name;
	
	@Column(name="task_start")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@Column(name="task_end")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date end;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="severity")
	private String severity;
	
	@ManyToOne   // insert=false, update=false, optional=false
	@JoinColumn(name="user_id", nullable=false)
	private Users user;
	
	public Tasks() {}
	public Tasks(String name, Date start, Date end, String severity, String desc, Users user) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.desc = desc;
		this.severity = severity;
		this.user = user;
	}

	public Integer getId() { return task_id;}
	public String getName() { return name;}
	public Date getStart() { return start;}
	public Date getEnd() { return end;}
	public String getDesc() { return desc;}
	public String getSeverity() { return severity;}
	public Users getUser() { return user;}

	public void setId(Integer task_id) { this.task_id = task_id;}
	public void setName(String name) { this.name = name;	}
	public void setStart(Date start) { this.start = start;}
	public void setEnd(Date end) { this.end = end;}
	public void setDesc(String desc) {	this.desc = desc;}
	public void setSeverity(String severity) {	this.severity = severity;}
	public void setUser(Users user) { this.user = user;}

}
