package sk.martin.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.RandomStringUtils;



@Entity
@Data
public class Poistenec {
	
	 @Id @GeneratedValue private Long id;
	  private String meno;
	  private String priezvisko;
	  private String rodneCislo;
	  private String email;
	  private String indentifikator;

	// pridal som c
	  @OneToOne(cascade = CascadeType.ALL)
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "trvala_adresa_id")
	  private Adresa trvalaAdresa;

	  //pridal som @OneToMany
	  @OneToMany(cascade = CascadeType.ALL)
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "korespondencna_adresa_id")
	  private Adresa korespondencnaAdresa;

	  @OneToMany
	  @JoinColumn(name = "poistenec_id")
	  private List<Zmluva> zmluvy = new ArrayList<>();

	  public Poistenec() {}
	  
	  
	

	  public Poistenec(String meno, String priezvisko, String rodneCislo, String email) {
	    this.meno = meno;
	    this.priezvisko = priezvisko;
	    this.rodneCislo = rodneCislo;
	    this.email = email;
	    indentifikator = RandomStringUtils.randomNumeric(9);
	  }
	  
	  public void pridajZmluvu(Zmluva zmluva) {
		    zmluvy.add(zmluva);
		  }
}
