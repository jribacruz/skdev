package br.skdev.proxy;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import br.skdev.model.EPersistence;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EPersistenceProxyTest {

	private Logger log = LoggerFactory.getLogger(EAttributeProxyTest.class);

	private EPersistence persistence;

	@Before
	public void init() throws SAXException, IOException, ParserConfigurationException {
		this.persistence = new EPersistenceProxy(new File("src/test/java/persistence.xml"));

	}

	@Test
	public void testPersistenceClasses() {
		persistence.getClasses().forEach(klass -> log.info("Class: {}", klass));
		System.out.println("Total Dependencies: " + persistence.getClasses().size());
	}

}
