package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;



@Entity
public class Grade implements Serializable{




@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
protected Integer id;








@Column(nullable = false)
protected Integer  points;	



	






@Column(nullable = false)
protected Integer  grade;	



	



@ManyToOne
@JoinColumn
protected Subject  subject;	



	



@ManyToOne
@JoinColumn
protected Professor  professor;	



	



@ManyToOne
@JoinColumn
protected Student  student;	



	


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}



public Integer getPoints() {
	return points;
}
		
public void setPoints(Integer points) {
	this.points = points;
}
		


public Integer getGrade() {
	return grade;
}
		
public void setGrade(Integer grade) {
	this.grade = grade;
}
		


public Subject getSubject() {
	return subject;
}
		
public void setSubject(Subject subject) {
	this.subject = subject;
}
		


public Professor getProfessor() {
	return professor;
}
		
public void setProfessor(Professor professor) {
	this.professor = professor;
}
		


public Student getStudent() {
	return student;
}
		
public void setStudent(Student student) {
	this.student = student;
}
		


@Override
public String toString() {
	return "" + 











	" ";}




}