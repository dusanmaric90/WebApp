package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;



@Entity
public class Professor extends Person implements Serializable{












protected Integer  count_subjests;	



	



@OneToMany(mappedBy="professor", fetch=FetchType.EAGER)
protected Set<Grade> grades = new HashSet<Grade>();



	




public Integer getCount_subjests() {
	return count_subjests;
}
		
public void setCount_subjests(Integer count_subjests) {
	this.count_subjests = count_subjests;
}
		

		


@Override
public String toString() {
	return super.toString();
} 




}