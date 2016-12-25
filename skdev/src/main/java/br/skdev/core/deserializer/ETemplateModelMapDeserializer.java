package br.skdev.core.deserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.thoughtworks.qdox.model.JavaClass;

import br.skdev.core.model.EString;
import br.skdev.core.model.ETemplateModel;
import br.skdev.core.proxy.EClassProxy;

public class ETemplateModelMapDeserializer extends JsonDeserializer<Map<String, ETemplateModel>> {

	private Logger log = LoggerFactory.getLogger(ETemplateModelMapDeserializer.class);

	@Override
	public Map<String, ETemplateModel> deserialize(JsonParser jp, DeserializationContext arg1) throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		Map<String, ETemplateModel> model = new HashMap<>();

		log.info("[deserialize] nodes={}", node);

		Iterator<Entry<String, JsonNode>> entries = node.fields();
		while (entries.hasNext()) {
			Entry<String, JsonNode> entry = entries.next();
			JsonNode modelItemNode = entry.getValue();

			String type = modelItemNode.get("@type").asText();
			if (type.equals("EString")) {
				model.put(entry.getKey(), new EString(modelItemNode.get("value").asText()));
			} else if (type.equals("EClass")) {
				Optional<JavaClass> javaClass = EClassProxy.createJavaClass(modelItemNode.get("path").asText());
				if (javaClass.isPresent()) {
					EClassProxy eClassProxy = new EClassProxy(javaClass.get());
					model.put(entry.getKey(), eClassProxy);
				}
			}
		}

		return model;
	}

}
