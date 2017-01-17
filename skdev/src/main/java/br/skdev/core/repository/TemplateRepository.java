package br.skdev.core.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.skdev.core.domain.Template;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Integer> {

	public Optional<Template> findById(Integer id);
}
