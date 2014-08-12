package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;
@Entity
public class Zika {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
protected Integer id;



@Transient

@Min(2)
@Max(5)
@Column(unique = true, nullable = false)
protected String  ime;	
	





@Column(unique = true)
protected String  prezime;	
	



public String getIme() {
	return ime;
}
		
public void setIme(String ime) {
	this.ime = ime;
}		


public String getPrezime() {
	return prezime;
}
		
public void setPrezime(String prezime) {
	this.prezime = prezime;
}		




}