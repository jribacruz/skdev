package br.skdev.core.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.skdev.core.domain.Fragment;
import br.skdev.core.repository.FragmentRepository;

@Service
public class FragmentService {

	private Logger log = LoggerFactory.getLogger(FragmentService.class);

	@Autowired
	private FragmentRepository fragmentRepository;

	public List<Fragment> findAll() {
		return fragmentRepository.findAll();
	}
	
	Optional<Fragment> findByName(String name){
		return fragmentRepository.findByName(name);
	}

}
