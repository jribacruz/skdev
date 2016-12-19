package br.skdev;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.skdev.core.template.Template;
import br.skdev.core.template.TemplateModel;
import freemarker.template.TemplateException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateTest {

	@Autowired
	private Template template;

	@Test
	public void mergeHelloTemplate() throws IOException, TemplateException {
		TemplateModel model = TemplateModel.of().add("name", "José Ribamar");
		String mergedTemplate = template.merge(model, "hello.ftl");
		System.out.println(mergedTemplate);
	}
}
