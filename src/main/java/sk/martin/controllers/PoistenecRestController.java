package sk.martin.controllers;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.martin.dto.AdresaDTO;
import sk.martin.dto.PoistenecDTO;
import sk.martin.dto.PoistenecListDTO;
import sk.martin.dto.PoistenecViewDTO;
import sk.martin.dto.ZmluvaViewDTO;
import sk.martin.dto.ZmluvaViewDTO.TypZmluvy;
import sk.martin.model.Adresa;
import sk.martin.model.Poistenec;
import sk.martin.model.Zmluva;
import sk.martin.model.ZmluvaCestovnePoistenie;
import sk.martin.services.PoistenecService;


/* PoistenecRestController obsahuje mapovanie na GET, POST,
 *  obsahuje tiež funkcie na DTO a pomocou Service volá ďališe 
 *  funkcie na spracoanie objektov.
 *  V modeli MVC tato trieda predstavuje Controller  */


@RestController
@RequestMapping("/insured")
@RequiredArgsConstructor
public class PoistenecRestController {

  

  private final PoistenecService poistenecService;

  @GetMapping
  public ResponseEntity<PoistenecListDTO> zobrazVsetkychPoistencov() {
   
    final List<PoistenecViewDTO> poistenecViewDTOS =
        poistenecService.findByOrderByPriezviskoAsc().stream()
            .map(this::mapPoistenecToPoistenecViewDTO)
            .collect(Collectors.toList());

    PoistenecListDTO result =
        PoistenecListDTO.builder()
            .stranka(1)
            .celkovyPocetStranok(3)
            .poistenci(poistenecViewDTOS)
            .build();
    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PoistenecDTO> detailPoistenca(@PathVariable("id") Long id) {
    Optional<Poistenec> poistenec = poistenecService.findById(id);
    PoistenecDTO p = poistenec.map(this::mapPoistenecToPoistenecDTO).orElse(null);
    if (p == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(p);
  }

  @PostMapping
  public Poistenec pridajPoistenca(@RequestBody @Valid PoistenecDTO p) {
    Poistenec poistenec = new Poistenec(p.getMeno(), p.getPriezvisko(), null, null);

    if (p.getTrvalaAdresa() != null) {
      poistenec.setTrvalaAdresa(mapAdresaDtoToAdresa(p.getTrvalaAdresa()));
    }

       if (p.getKorespondencnaAdresa() == null) {
      poistenec.setKorespondencnaAdresa(mapAdresaDtoToAdresa(p.getTrvalaAdresa()));
    } else {
      poistenec.setKorespondencnaAdresa(mapAdresaDtoToAdresa(p.getKorespondencnaAdresa()));
    }
    return poistenecService.pridajPoistencaDoDB(poistenec);
  }

  private Adresa mapAdresaDtoToAdresa(AdresaDTO adresa) {
    return Adresa.builder()
        .ulica(adresa.getUlica())
        .cislo(adresa.getCislo())
        .mesto(adresa.getMesto())
        .psc(adresa.getPsc())
        .build();
  }

  private AdresaDTO mapAdresaToAdresaDto(Adresa adresa) {
    return AdresaDTO.builder()
        .ulica(adresa.getUlica())
        .cislo(adresa.getCislo())
        .mesto(adresa.getMesto())
        .psc(adresa.getPsc())
        .build();
  }

  private PoistenecDTO mapPoistenecToPoistenecDTO(Poistenec poistenec) {
    List<ZmluvaViewDTO> zmluvy =
        poistenec.getZmluvy().stream().map(this::mapZmluva).collect(Collectors.toList());
    return PoistenecDTO.builder()
        .id(poistenec.getId())
        .meno(poistenec.getMeno())
        .priezvisko(poistenec.getPriezvisko())
        .trvalaAdresa(
            Optional.ofNullable(poistenec.getTrvalaAdresa())
                .map(this::mapAdresaToAdresaDto)
                .orElse(null))
        .korespondencnaAdresa(
            Optional.ofNullable(poistenec.getKorespondencnaAdresa())
                .map(this::mapAdresaToAdresaDto)
                .orElse(null))
        .zmluvy(zmluvy)
        .build();
  }

  private PoistenecViewDTO mapPoistenecToPoistenecViewDTO(Poistenec poistenec) {
    return PoistenecViewDTO.builder()
        .id(poistenec.getId())
        .meno(poistenec.getMeno())
        .priezvisko(poistenec.getPriezvisko())
        .build();
  }

  private ZmluvaViewDTO mapZmluva(Zmluva zmluva) {
    return ZmluvaViewDTO.builder()
        .cisloZmluvy(zmluva.getCisloZmluvy())
        .typZmluvy(
            zmluva instanceof ZmluvaCestovnePoistenie ? TypZmluvy.CESTOVNE : TypZmluvy.MAJETOK)
        .datumVznikuPoistenia(zmluva.getDatumVznikuPoistenia())
        .build();
  }
}