package sk.martin.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@DiscriminatorValue("CP")
@NoArgsConstructor
public class ZmluvaCestovnePoistenie extends Zmluva {
	 private LocalDate datumKoncaPoistenia;
	  private TypCestovnePoistenia typPostenia;

	  public ZmluvaCestovnePoistenie(
	      Poistenec poistenec,
	      LocalDate datumVznikuPoistenia,
	      LocalDate datumKoncaPoistenia,
	      TypCestovnePoistenia typPostenia) {
	    super(poistenec, datumVznikuPoistenia);
	    this.datumKoncaPoistenia = datumKoncaPoistenia;
	    this.typPostenia = typPostenia;
	  }

	  @Override
	  protected String getKod() {
	    return "CP";
	  }

	  public enum TypCestovnePoistenia {
	    URAZ,
	    SKODA
	  }
	}