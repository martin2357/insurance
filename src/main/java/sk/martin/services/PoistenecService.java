package sk.martin.services;

import java.util.List;
import java.util.Optional;

import sk.martin.model.Poistenec;

public interface PoistenecService {

	Poistenec pridajPoistencaDoDB(Poistenec poistenec);

	Optional<Poistenec> findById(Long id);

	List<Poistenec> findByOrderByPriezviskoAsc();
}
