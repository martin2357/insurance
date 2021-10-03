package sk.martin.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class AdresaDTO {

  @NotEmpty
  private String ulica;
  @NotEmpty
  private String cislo;
  @NotEmpty
  private String mesto;
  @NotEmpty
  private String psc;

}

