package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;
import enumeration.*;
@Entity
public class Zika {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
protected Integer id;




@Min(2)
@Max(5)
@Column(unique = true, nullable = false)
protected String  ime;	
	




@Column(unique = true)
protected String  prezime;	
	





protected Mika  mika;	
	


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


public String getPrezime() {
	return prezime;
}
		
public void setPrezime(String prezime) {
	this.prezime = prezime;
}		

@ManyToOne
public Mika getMika() {
	return mika;
}
		
public void setMika(Mika mika) {
	this.mika = mika;
}		





}