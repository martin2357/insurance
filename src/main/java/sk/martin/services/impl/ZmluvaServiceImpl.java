package sk.martin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.martin.model.Zmluva;
import sk.martin.repositories.ZmluvaRepository;
import sk.martin.services.ZmluvaService;

@Service
@RequiredArgsConstructor
public class ZmluvaServiceImpl implements ZmluvaService {

  private final ZmluvaRepository zmluvaRepository;

  public Zmluva pridajZmluvuDoDB(Zmluva zmluva) {
    return zmluvaRepository.save(zmluva);
  }
}
