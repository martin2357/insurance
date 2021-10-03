package sk.martin.init;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sk.martin.model.Adresa;
import sk.martin.model.Poistenec;
import sk.martin.model.ZmluvaCestovnePoistenie;
import sk.martin.model.ZmluvaCestovnePoistenie.TypCestovnePoistenia;
import sk.martin.model.ZmluvaPoistenieMajetku;
import sk.martin.model.ZmluvaPoistenieMajetku.TypNehnutelnosti;
import sk.martin.services.PoistenecService;
import sk.martin.services.ZmluvaService;

@Component
@RequiredArgsConstructor
public class DataInit implements ApplicationListener<ContextRefreshedEvent> {

  private final PoistenecService poistenecService;
  private final ZmluvaService zmluvaService;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    Poistenec poistenec =
        poistenecService.pridajPoistencaDoDB(new Poistenec("Martin", "Babiak", null, null));

    Adresa adresaNehnutelnosti = Adresa.builder().build();
    ZmluvaPoistenieMajetku poistenieMajetku =
        new ZmluvaPoistenieMajetku(
            poistenec,
            LocalDate.now(),
            TypNehnutelnosti.BYT,
            new BigDecimal("123000"),
            adresaNehnutelnosti);
    ZmluvaCestovnePoistenie cestovnePoistenie =
        new ZmluvaCestovnePoistenie(
            poistenec, LocalDate.now(), LocalDate.now().plusDays(100), TypCestovnePoistenia.SKODA);

    zmluvaService.pridajZmluvuDoDB(poistenieMajetku);
    zmluvaService.pridajZmluvuDoDB(cestovnePoistenie);
  }
}
