package sk.martin.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class PoistenecViewDTO {

  Long id;
  String meno;
  String priezvisko;
  String rodneCislo;
}