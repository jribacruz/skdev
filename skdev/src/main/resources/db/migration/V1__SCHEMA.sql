CREATE TABLE WORKSPACE(
	ID IDENTITY PRIMARY KEY,
	PATH VARCHAR(255)
);

CREATE TABLE TEMPLATE(
	ID IDENTITY PRIMARY KEY,
	NAME VARCHAR(64),
	CONTENT VARCHAR(4096)
);

INSERT INTO TEMPLATE(NAME,CONTENT) VALUES('teste.ftl','Hello ${entity.name} artifactId: ${artifactId.value} <#list entity.attributes as attr> attribute: ${attr.name}:${attr.type} </#list>');