package sk.martin.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sk.martin.model.ZmluvaPoistenieMajetku.TypNehnutelnosti;


@Entity
@Getter
@DiscriminatorValue("PM")
@NoArgsConstructor
public class ZmluvaPoistenieMajetku extends Zmluva {
	private TypNehnutelnosti typNehnutelnosti;

	  @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "adresa_nehnutelnosti_id")
	  private Adresa adresaNehnutelnosti;

	  private BigDecimal hodnotaNehnutelnosti;

	  public ZmluvaPoistenieMajetku(
	      Poistenec poistenec,
	      LocalDate datumVznikuPoistenia,
	      TypNehnutelnosti typNehnutelnosti,
	      BigDecimal hodnotaNehnutelnosti,
	      Adresa adresaNehnutelnosti) {
	    super(poistenec, datumVznikuPoistenia);
	    this.typNehnutelnosti = typNehnutelnosti;
	    this.hodnotaNehnutelnosti = hodnotaNehnutelnosti;
	    this.adresaNehnutelnosti = adresaNehnutelnosti;
	  }

	  @Override
	  protected String getKod() {
	    return "PM";
	  }

	  public enum TypNehnutelnosti {
	    BYT,
	    RODINY_DOM_MUROVANY,
	    RODINY_DOM_DREVENY
	  }
	}