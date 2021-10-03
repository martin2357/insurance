package sk.martin.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@NoArgsConstructor
public abstract class Zmluva {
	protected String cisloZmluvy;
	  protected LocalDate datumVznikuPoistenia;
	  @ManyToOne protected Poistenec poistenec;
	  @Id @GeneratedValue private Long id;

	  public Zmluva(Poistenec poistenec, LocalDate datumVznikuPoistenia) {
	    this.poistenec = poistenec;
	    this.datumVznikuPoistenia = datumVznikuPoistenia;
	    this.cisloZmluvy = getKod() + RandomStringUtils.randomNumeric(6);
	    poistenec.pridajZmluvu(this);
	  }

	  protected abstract String getKod();
	}