package br.skdev.proxy;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.skdev.model.EPersistence;
import br.skdev.parser.XMLParser;

public class EPersistenceProxy extends EPersistence {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private XMLParser xmlParser;

	public EPersistenceProxy(File file) throws SAXException, IOException, ParserConfigurationException {
		super();
		this.xmlParser = new XMLParser(file, false);
	}

	@Override
	public Set<String> getClasses() {
		if (this.classes == null) {
			//// @formatter:off
			this.classes = xmlParser.getNodesByXPathExpression("//class")
					.stream()
					.map(node -> node.getTextContent())
					.collect(Collectors.toSet());
			// @formatter:on
		}
		return this.classes;
	}

}
