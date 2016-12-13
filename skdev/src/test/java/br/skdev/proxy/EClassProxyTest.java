package br.skdev.proxy;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.skdev.model.EClass;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EClassProxyTest {

	@Test
	public void test_getName_EClass() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy("src/test/java/br/skdev/model/Foo.java");
		Assert.assertTrue(eClass.getName().equals("Foo"));
	}

	@Test
	public void test_getFullyQualifiedName_EClass() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy("src/test/java/br/skdev/model/Foo.java");
		Assert.assertTrue(eClass.getFullyQualifiedName().equals("br.skdev.model.Foo"));
	}
	
	@Test
	public void test_getPackageName_EClass() throws FileNotFoundException, IOException {
		EClass eClass = new EClassProxy("src/test/java/br/skdev/model/Foo.java");
		Assert.assertTrue(eClass.getPackageName().equals("br.skdev.model"));
	}
}
