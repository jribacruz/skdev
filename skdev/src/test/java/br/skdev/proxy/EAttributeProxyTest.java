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
public class EAttributeProxyTest {

	private Logger log = LoggerFactory.getLogger(EAttributeProxyTest.class);

	private JavaClass javaClass;

	@Before
	public void init() throws FileNotFoundException, IOException {
		JavaDocBuilder doc = new JavaDocBuilder();
		JavaSource source = doc.addSource(new File("src/test/java/br/skdev/model/Foo.java"));
		this.javaClass = source.getClasses()[0];
	}

	@Test
	public void test_hasNameBars() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getAttributes().stream().anyMatch(eAttribute -> eAttribute.getName().equals("bars")));
	}

	@Test
	public void test_hasTypeList() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		//// @formatter:off
		eClass.getAttributes()
				.stream()
				.forEach(eAttribute -> log.info("[test_hasTypeList] Name: {}  GenericTypes {}", eAttribute.getName(), eAttribute.getGenericTypes()));
		Assert.assertTrue(eClass.getAttributes()
					.stream()
					.filter(eJavaAttribue -> eJavaAttribue.getName().equals("bars"))
					.allMatch(eJavaAttribue -> eJavaAttribue.getType().equals("java.util.Set")));
		// @formatter:on
	}

	@Test
	public void test_hasModifierPublic() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		//// @formatter:off
		Assert.assertTrue(eClass.getAttributes()
					.stream()
					.filter(eJavaAttribue -> eJavaAttribue.getName().equals("bars"))
					.allMatch(eJavaAttribue -> eJavaAttribue.getModifiers().contains("private")));
		// @formatter:on
	}

	@Test
	public void test_hasStringGenericType() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		eClass.getAttributes().stream()
				.forEach(eAttribute -> log.info("[test_hasStringGenericType] Name: {}  GenericTypes {}",
						eAttribute.getName(), eAttribute.getGenericTypes()));
		//// @formatter:off
		Assert.assertTrue(eClass.getAttributes()
					.stream()
					.filter(eJavaAttribue -> eJavaAttribue.getName().equals("bars"))
					.allMatch(eJavaAttribue -> eJavaAttribue.getGenericTypes().get(0).equals("br.skdev.model.Bar")));
		// @formatter:on
	}

}
