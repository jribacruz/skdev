package br.skdev.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FS {

	public static Optional<Stream<Path>> directories(String path) {
		try {
			return Optional.of(Files.list(Paths.get(path)).filter(Files::isDirectory));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public static boolean hasFile(String path, String fileName) {
		try {
			return Files.list(Paths.get(path)).filter(Files::isRegularFile)
					.anyMatch(path1 -> path1.toFile().getName().equals(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean hasFile(Path path, String fileName) {
		try {
			return Files.list(path).filter(Files::isRegularFile)
					.anyMatch(path1 -> path1.toFile().getName().equals(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
