package br.skdev.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.skdev.core.domain.Fragment;

public interface FragmentRepository extends JpaRepository<Fragment, Integer> {

}
