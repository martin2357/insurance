package sk.martin.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sk.martin.model.Poistenec;
import sk.martin.repositories.PoistenecRepository;

import sk.martin.services.PoistenecService;

@Service
@RequiredArgsConstructor
public class PoistenecServiceImpl  implements PoistenecService{
	
	@Autowired
	private  PoistenecRepository poistenecRepository;
	 
	@Override
	public Poistenec pridajPoistencaDoDB(Poistenec poistenec) {
		  return poistenecRepository.save(poistenec);
	}

	@Override
	public Optional<Poistenec> findById(Long id) {
		  return poistenecRepository.findById(id);
	  }

	@Override
	public List<Poistenec> findByOrderByPriezviskoAsc() {
		 return poistenecRepository.findByOrderByPriezviskoAsc();
	}

	
}
