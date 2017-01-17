package br.skdev.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.skdev.core.domain.Template;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Integer> {

}
