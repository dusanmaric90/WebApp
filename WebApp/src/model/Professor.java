package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;



@Entity
public class Professor extends Person implements Serializable{












protected Integer  countsubjests;	



	



@OneToMany(mappedBy="professor", fetch=FetchType.EAGER)
protected Set<Grade> grades = new HashSet<Grade>();



	




public Integer getCountsubjests() {
	return countsubjests;
}
		
public void setCountsubjests(Integer countsubjests) {
	this.countsubjests = countsubjests;
}
		

		





}