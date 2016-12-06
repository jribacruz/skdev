package br.skdev.service;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.skdev.core.MavenFolder;
import br.skdev.core.context.WorkspaceContext;
import br.skdev.core.service.WorkspaceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkspaceServiceTest {

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private WorkspaceContext workspaceContext;;

	@Test
	public void loadTest() throws IOException {
		workspaceService.load("/home/jcruz/workspace");
		workspaceContext.getWokspace().getJavaProjects()
				.forEach(project -> System.out.println(project.getName() + " - " + project.getPath()));
		workspaceContext.setJavaProject(workspaceContext.getWokspace().getJavaProjects().first());
		workspaceContext.getJavaProject().getEJavaClasses(MavenFolder.SRC_MAIN_JAVA)
			.forEach(eJavaClass -> System.out.println(eJavaClass.getName()));
			
	}
}
