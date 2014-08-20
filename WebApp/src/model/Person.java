package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;



@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable{




@Id
@GeneratedValue(strategy=GenerationType.TABLE)
protected Integer id;







@Size(min = 0, max = 30)
@Column(nullable = false)
protected String  firstname;	



	





@Size(min = 0, max = 30)
@Column(nullable = false)
protected String  lastname;	



	



@Temporal(TemporalType.DATE)


@Column(nullable = false)
protected Date  birthday;	



	




@Enumerated(EnumType.STRING)

@Column(nullable = false)
protected Gender  gender;	



	


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}



public String getFirstname() {
	return firstname;
}
		
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
		


public String getLastname() {
	return lastname;
}
		
public void setLastname(String lastname) {
	this.lastname = lastname;
}
		


public Date getBirthday() {
	return birthday;
}
		
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
		


public Gender getGender() {
	return gender;
}
		
public void setGender(Gender gender) {
	this.gender = gender;
}
		


@Override
public String toString() {
	return "" + 

firstname+ " " +

lastname+ " " +





	" ";}




}