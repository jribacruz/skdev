package br.skdev.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.model.EFragment;
import br.skdev.core.repository.FragmentRepository;

@Service
public class FragmentService {

	private Logger log = LoggerFactory.getLogger(FragmentService.class);

	@Autowired
	private FragmentRepository fragmentRepository;

	public List<EFragment> findAll() {
		return fragmentRepository.findAll();
	}

}
