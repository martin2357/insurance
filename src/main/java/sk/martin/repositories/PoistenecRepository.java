package sk.martin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sk.martin.model.Poistenec;

public interface PoistenecRepository extends CrudRepository<Poistenec, Long> {

	  List<Poistenec> findByOrderByPriezviskoAsc();
}
