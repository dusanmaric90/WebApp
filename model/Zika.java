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




<dt>type</dt>
<dd>String</dd>


<dt>name</dt>
<dd>ime</dd>




<dt>type</dt>
<dd>String</dd>


<dt>name</dt>
<dd>prezime</dd>






 protected String  ime;




 protected String  prezime;





}