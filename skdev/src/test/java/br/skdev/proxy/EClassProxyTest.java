package br.skdev.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;

import br.skdev.model.EClass;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EClassProxyTest {

	private JavaClass javaClass;

	@Before
	public void init() throws FileNotFoundException, IOException {
		JavaDocBuilder doc = new JavaDocBuilder();
		JavaSource source = doc.addSource(new File("src/test/java/br/skdev/model/Foo.java"));
		this.javaClass = source.getClasses()[0];
	}

	@Test
	public void test_getName_EClass() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getName().equals("Foo"));
	}

	@Test
	public void test_getFullyQualifiedName_EClass() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getFullyQualifiedName().equals("br.skdev.model.Foo"));
	}

	@Test
	public void test_getPackageName_EClass() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getPackageName().equals("br.skdev.model"));
	}

	@Test
	public void test_getAttributes_EClass() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy(this.javaClass);
		Assert.assertTrue(eClass.getAttributes().size() == 1);
	}
}
