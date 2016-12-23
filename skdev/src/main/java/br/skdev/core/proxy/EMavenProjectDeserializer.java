package br.skdev.core.proxy;

import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.skdev.core.model.EMavenProject;

public class EMavenProjectDeserializer extends JsonDeserializer<EMavenProject> {

	@Override
	public EMavenProject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		System.out.println(node);
		final String projectPath = node.get("absolutePath").asText();
		return new EMavenProjectProxy(Paths.get(projectPath));
	}

}