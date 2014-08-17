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






@Min(0)
@Max(30)
@Column(nullable = false)
protected String  subjectname;	



	







protected Integer  espb;	



	



@OneToMany(mappedBy="subject", fetch=FetchType.EAGER)
protected Set<Grade> grades = new HashSet<Grade>();



	


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}



public String getSubjectname() {
	return subjectname;
}
		
public void setSubjectname(String subjectname) {
	this.subjectname = subjectname;
}
		


public Integer getEspb() {
	return espb;
}
		
public void setEspb(Integer espb) {
	this.espb = espb;
}
		

		





}