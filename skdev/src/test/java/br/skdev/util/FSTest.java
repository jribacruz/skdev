package br.skdev.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.skdev.core.util.FS;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FSTest {
	
	@Autowired
	private FS fs;

	
	@Test
	public void mkdirTest() {
		fs.mkdir("src/test/java", "abc");
	}
	
	@Test
	public void createFileTest() {
		fs.createFile("src/test/java/abc////fgh/readme.txt", "Hello José Ribamar");
	}
	
	@Test
	public void appendFileTest() {
		fs.appendFile("src/test/java/abc/fgh/readme.txt", "Hello");
	}
}
