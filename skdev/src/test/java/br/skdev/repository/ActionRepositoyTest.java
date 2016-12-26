package br.skdev.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.skdev.core.repository.ActionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class ActionRepositoyTest {

	@Autowired
	private ActionRepository actionRepository;

	@Test
	public void testFindByName() {
	}

}
