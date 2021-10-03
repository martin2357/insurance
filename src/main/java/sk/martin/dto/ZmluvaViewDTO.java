package sk.martin.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class ZmluvaViewDTO {

  private String cisloZmluvy;
  private LocalDate datumVznikuPoistenia;
  private Enum typZmluvy;

  public enum TypZmluvy {
    MAJETOK,
    CESTOVNE
  }

}
