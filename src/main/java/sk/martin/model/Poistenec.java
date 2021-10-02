package sk.martin.model;

import java.util.List;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.RandomStringUtils;



@Entity
@Data
public class Poistenec {
	
	  @Id @GeneratedValue  private String meno;
	  private String priezvisko;
	  private String rodneCislo;
	  private String email;
	  private String indentifikator;

	  
	  
	  
	  
	  public Poistenec() {}

	  public Poistenec(String meno, String priezvisko, String rodneCislo, String email) {
	    this.meno = meno;
	    this.priezvisko = priezvisko;
	    this.rodneCislo = rodneCislo;
	    this.email = email;
	    indentifikator = RandomStringUtils.randomNumeric(9);
	  }
}