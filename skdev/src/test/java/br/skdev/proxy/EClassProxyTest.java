package br.skdev.proxy;

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
	public void test_getName_EClass() {
		EClass eClass = new EClassProxy("src/test/java/br/skdev/model/Foo.java");
		Assert.assertTrue(eClass.getName().equals("Foo"));
	}
}