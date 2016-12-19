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
public class EClassProxyTest {

	private Logger log = LoggerFactory.getLogger(EClassProxyTest.class);

	private JavaClass javaClass;

	@Before
	public void init() throws FileNotFoundException, IOException {
		JavaDocBuilder doc = new JavaDocBuilder();
		JavaSource source = doc.addSource(new File("src/test/java/br/skdev/model/Foo.java"));
		this.javaClass = source.getClasses()[0];
	}

	@Test
	public void test_getName_EClass() {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getName().equals("Foo"));
	}

	@Test
	public void test_getFullyQualifiedName_EClass() {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getFullyQualifiedName().equals("br.skdev.model.Foo"));
	}

	@Test
	public void test_getPackageName_EClass() {
		EClass eClass = new EClassProxy(this.javaClass);
		System.out.println(eClass.getClassPackage().getDirectory());
		Assert.assertTrue(eClass.getClassPackage().getName().equals("br.skdev.model"));
	}

	@Test
	public void test_getAttributes_EClass() {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getAttributes().size() == 3);
	}

	@Test
	public void test_hasAnnotationJsonIgnoreProperties() {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getAnnotations().stream().anyMatch(
				eAnnotation -> eAnnotation.getName().equals("com.fasterxml.jackson.annotation.JsonIgnoreProperties")));
	}

	@Test
	public void test_hasParameterIgnoreUnknown_AnnotationJsonIgnoreProperties() {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getAnnotations().stream().filter(
				eAnnotation -> eAnnotation.getName().equals("com.fasterxml.jackson.annotation.JsonIgnoreProperties"))
				.anyMatch(eAnnotation -> eAnnotation.getParameters().keySet().contains("ignoreUnknown")));
	}

	@Test
	public void test_hasParameterIgnoreUnknownTrue_AnnotationJsonIgnoreProperties() {
		EClass eClass = new EClassProxy(this.javaClass);

		eClass.getAnnotations().stream()
				.forEach(eAnnotation -> log.info(
						"[test_hasParameterIgnoreUnknownTrue_AnnotationJsonIgnoreProperties] Name {} Paramers: {}",
						eAnnotation.getName(), eAnnotation.getParameters().get("ignoreUnknown").getClass()));

		Assert.assertTrue(eClass.getAnnotations().stream().filter(
				eAnnotation -> eAnnotation.getName().equals("com.fasterxml.jackson.annotation.JsonIgnoreProperties"))
				.anyMatch(eAnnotation -> Boolean.valueOf(eAnnotation.getParameters().get("ignoreUnknown"))));
	}

}
