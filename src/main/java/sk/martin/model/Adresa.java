package sk.martin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adresa {

	@Id
	  @GeneratedValue
	  private Long id;
	  private String ulica;
	  private String cislo;
	  private String mesto;
	  private String psc;
}
