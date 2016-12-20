package br.skdev.core.util;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FS implements Serializable {

	private Logger log = LoggerFactory.getLogger(FS.class);

	public Optional<Stream<Path>> listDirectories(String path) {
		try {
			return Optional.of(Files.list(Paths.get(path)).filter(Files::isDirectory));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return Optional.empty();
	}

	public Optional<Stream<Path>> listFiles(String path) {
		try {
			return Optional.of(Files.list(Paths.get(path)).filter(Files::isRegularFile));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return Optional.empty();
	}

	public Optional<Stream<Path>> listFilesRecursively(String path) {
		try {
			return Optional.of(Files.walk(Paths.get(path)).filter(Files::isRegularFile));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return Optional.empty();
	}

	public Optional<Stream<Path>> listFilesRecursively(Path path) {
		try {
			return Optional.of(Files.walk(path).filter(Files::isRegularFile));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return Optional.empty();
	}

	public boolean hasFile(String path, String fileName) {
		try {
			return Files.list(Paths.get(path)).filter(Files::isRegularFile)
					.anyMatch(path1 -> path1.toFile().getName().equals(fileName));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public boolean hasFile(Path path, String fileName) {
		try {
			return Files.list(path).filter(Files::isRegularFile)
					.anyMatch(path1 -> path1.toFile().getName().equals(fileName));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public boolean hasDirectory(Path path, String dirName) {
		try {
			return Files.list(path).filter(Files::isDirectory)
					.anyMatch(path1 -> path1.toFile().getName().equals(dirName));
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public void mkdir(String path) {
		if (Files.notExists(Paths.get(path))) {
			try {
				Files.createDirectories(Paths.get(path));
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
	}
}
