package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;
import enumeration.*;
@Entity
public class Mika {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
protected Integer id;







protected String  ime;	
	


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}



public String getIme() {
	return ime;
}
		
public void setIme(String ime) {
	this.ime = ime;
}		





}