package matt.userfeedback.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name="feedback")
public class Feedback {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;	
	private String comments;
	private int rating;
	private String user;
	
//	public Feedback() {
//		
//	}
//
//	public Integer getId() {return id;}
//	public String getComments() {return comments;}
//	public int getRating() {return rating;}
//	public String getUser() {return user;}
//
//	public void setId(Integer id) {this.id = id;}
//	public void setComments(String comments) {this.comments = comments;}
//	public void setRating(int rating) {this.rating = rating;}
//	public void setUser(String user) {this.user = user;}
//	
//	@Override 
//	public String toString() {
//		return (id.toString() + " " + comments + " " + rating + " " + user);
//	}
}