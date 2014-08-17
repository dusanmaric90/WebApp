package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;



@Entity
public class Student extends Person implements Serializable{









@Min(0)
@Max(30)
@Column(nullable = false)
protected String  indexnumber;	



	







protected Integer  countexampassed;	



	



@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
protected Set<Grade> grades = new HashSet<Grade>();



	




public String getIndexnumber() {
	return indexnumber;
}
		
public void setIndexnumber(String indexnumber) {
	this.indexnumber = indexnumber;
}
		


public Integer getCountexampassed() {
	return countexampassed;
}
		
public void setCountexampassed(Integer countexampassed) {
	this.countexampassed = countexampassed;
}
		

		





}