package br.skdev.proxy;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.skdev.model.EPom;
import br.skdev.model.EPomDependency;
import br.skdev.parser.XMLParser;

public class EPomProxy extends EPom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private XMLParser xmlParser;

	public EPomProxy(File file) throws SAXException, IOException, ParserConfigurationException {
		super();
		this.xmlParser = new XMLParser(file, false);
	}

	@Override
	public Set<EPomDependency> getDependecies() {
		if (this.dependecies == null) {
			this.dependecies = new HashSet<>();
			List<Node> dependecyNodes = xmlParser.getNodesByXPathExpression("/project/dependencies/dependency");
			for (Node dependencyNode : dependecyNodes) {
				NodeList nodeList = dependencyNode.getChildNodes();
				EPomDependency pomDependency = new EPomDependency();
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node childNode = nodeList.item(i);
					if (!childNode.getNodeName().equals("#text")) {
						String nodeName = childNode.getNodeName();
						String nodeContent = childNode.getTextContent();
						System.out.println("Index: " + i + " Item: " + nodeName + " Text: " + nodeContent);
						System.out.println("=================================================================\n");
						if (nodeName.equals("groupId")) {
							pomDependency.setGroupId(nodeContent);
						} else if (nodeName.equals("artifactId")) {
							pomDependency.setArtifactId(nodeContent);
						} else if (nodeName.equals("version")) {
							pomDependency.setVersion(nodeContent);
						} else if (nodeName.equals("scope")) {
							pomDependency.setScope(nodeContent);
						}
					}
				}
				this.dependecies.add(pomDependency);
			}
		}
		return this.dependecies;
	}

}
