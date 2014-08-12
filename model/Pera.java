package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;
@Entity
public class Peraextends Zika {








protected String  adresa;	
	





protected Zika  zika;	
	



public String getAdresa() {
	return adresa;
}
		
public void setAdresa(String adresa) {
	this.adresa = adresa;
}		

@ManyToOne
public Zika getZika() {
	return zika;
}
		
public void setZika(Zika zika) {
	this.zika = zika;
}		




}