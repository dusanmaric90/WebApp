package model;
		
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.*;
import enumeration.*;
@Entity
public class Pera extends Zika {




@Enumerated(EnumType.STRING)



protected Boja  adresa;	
	





protected Zika  zika;	
	




public Boja getAdresa() {
	return adresa;
}
		
public void setAdresa(Boja adresa) {
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