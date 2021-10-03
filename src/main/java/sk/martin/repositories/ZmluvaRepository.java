package sk.martin.repositories;

import org.springframework.data.repository.CrudRepository;

import sk.martin.model.Zmluva;

public interface ZmluvaRepository extends CrudRepository<Zmluva, Long> {}
