package br.skdev.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.skdev.core.domain.Fragment;

public interface FragmentRepository extends CrudRepository<Fragment, Integer> {

}
