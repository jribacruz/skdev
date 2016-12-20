package br.skdev.template;

import java.io.IOException;

import org.junit.Assert;
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
		Assert.assertTrue(mergedTemplate.equals("Hello José Ribamar"));
	}

	@Test
	public void mergeInlineTemplate() throws IOException, TemplateException {
		TemplateModel model = TemplateModel.of().add("className", "Atividade");
		String mergedTemplate = template.mergeInline(model, "${className}DAO");
		Assert.assertTrue(mergedTemplate.equals("AtividadeDAO"));
	}
}
