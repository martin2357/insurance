package sk.martin.dto;

import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class PoistenecListDTO {

  int stranka;
  int celkovyPocetStranok;
  List<PoistenecViewDTO> poistenci;
}
