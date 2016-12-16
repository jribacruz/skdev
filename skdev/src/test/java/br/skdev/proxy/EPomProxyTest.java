package br.skdev.proxy;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import br.skdev.core.model.EPom;
import br.skdev.core.proxy.EPomProxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EPomProxyTest {

	private Logger log = LoggerFactory.getLogger(EAttributeProxyTest.class);

	private EPom pom;

	@Before
	public void init() throws SAXException, IOException, ParserConfigurationException {
		this.pom = new EPomProxy(new File("pom.xml"));

	}

	@Test
	public void testPomDependencies() {
		pom.getDependecies().forEach(dependency -> log.info("groupId: {}, artifiactId: {}, version: {}",
				new Object[] { dependency.getGroupId(), dependency.getArtifactId(), dependency.getVersion() }));
		System.out.println("Total Dependencies: " + pom.getDependecies().size());
		Assert.assertFalse(pom.getDependecies().isEmpty());
	}

	@Test
	public void testPomParent() {
		System.out.println(pom.getParent());
		Assert.assertTrue(pom.getParent().getArtifactId().equals("spring-boot-starter-parent"));
	}
}
