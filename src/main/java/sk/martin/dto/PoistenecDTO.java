package sk.martin.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class PoistenecDTO {

  Long id;

  @NotNull
  @Size(min = 1, max = 50)
  String meno;

  @NotEmpty
  @Size(min = 1, max = 50)
  String priezvisko;

  @NotNull @Valid AdresaDTO trvalaAdresa;

  AdresaDTO korespondencnaAdresa;

  List<ZmluvaViewDTO> zmluvy;
}
