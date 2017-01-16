package br.skdev.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.skdev.core.domain.Action;

@Repository
public interface ActionRepository extends CrudRepository<Action, Integer> {

}
