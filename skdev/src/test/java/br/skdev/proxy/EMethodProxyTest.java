package br.skdev.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;

import br.skdev.core.model.EClass;
import br.skdev.core.proxy.EClassProxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EMethodProxyTest {

	private Logger log = LoggerFactory.getLogger(EMethodProxyTest.class);

	private JavaClass javaClass;

	@Before
	public void init() throws FileNotFoundException, IOException {
		JavaDocBuilder doc = new JavaDocBuilder();
		JavaSource source = doc.addSource(new File("src/test/java/br/skdev/model/Foo.java"));
		this.javaClass = source.getClasses()[0];
	}

	@Test
	public void test_hasGetName() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getMethods().stream().anyMatch(eMethod -> eMethod.getName().equals("getName")));
	}

	@Test
	public void test_hasSetName() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getMethods().stream().anyMatch(eMethod -> eMethod.getName().equals("setName")));
	}

	@Test
	public void test_hasStringTypeParamenter() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		//// @formatter:off
		eClass.getMethods()
				.stream()
				.forEach(eMethod -> log.info("[test_hasStringGenericType] Name: {}  Parameters {}", eMethod.getName(), eMethod.getParameters()));
		Assert.assertTrue(eClass.getMethods()
					.stream()
					.filter(eMethod -> eMethod.getName().equals("setName"))
					.allMatch(eMethod -> eMethod.getParameters().get(0).getType().equals("java.lang.String")));
		// @formatter:on
	}

	@Test
	public void test_hasAnnotationJsonIgnore() {
		EClass eClass = new EClassProxy(this.javaClass);
		//// @formatter:off
		Assert.assertTrue(eClass.getMethods()
				.stream()
				.filter(eMethod -> eMethod.getName().equals("getBars"))
				.anyMatch(eMethod -> eMethod.getAnnotations().stream().anyMatch(eAnnotation -> eAnnotation.getName().equals("com.fasterxml.jackson.annotation.JsonIgnore"))));
		// @formatter:on
	}

}
