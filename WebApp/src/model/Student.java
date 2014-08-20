package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;



@Entity
public class Student extends Person implements Serializable{










@Size(min = 0, max = 30)
@Column(nullable = false)
protected String  index_number;	



	







protected Integer  count_exam_passed;	



	



@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
protected Set<Grade> grades = new HashSet<Grade>();



	




public String getIndex_number() {
	return index_number;
}
		
public void setIndex_number(String index_number) {
	this.index_number = index_number;
}
		


public Integer getCount_exam_passed() {
	return count_exam_passed;
}
		
public void setCount_exam_passed(Integer count_exam_passed) {
	this.count_exam_passed = count_exam_passed;
}
		

		


@Override
public String toString() {
	return super.toString();
} 




}