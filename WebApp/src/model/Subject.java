package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;



@Entity
public class Subject implements Serializable{




@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
protected Integer id;







@Size(min = 0, max = 30)
@Column(nullable = false)
protected String  subject_name;	



	







protected Integer  espb;	



	



@OneToMany(mappedBy="subject", fetch=FetchType.EAGER)
protected Set<Grade> grades = new HashSet<Grade>();



	


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}



public String getSubject_name() {
	return subject_name;
}
		
public void setSubject_name(String subject_name) {
	this.subject_name = subject_name;
}
		


public Integer getEspb() {
	return espb;
}
		
public void setEspb(Integer espb) {
	this.espb = espb;
}
		

		


@Override
public String toString() {
	return "" + 

subject_name+ " " +





	" ";}




}