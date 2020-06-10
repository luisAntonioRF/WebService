package com.luis.app.cliente.soap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientCollaboratorConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.luis.app.cliente.soap.schema");
		return marshaller;
	}
	
	@Bean
	public CollaboratorSoapClient getCollaboratorClient(Jaxb2Marshaller marshaller) {
		CollaboratorSoapClient client = new CollaboratorSoapClient();
		client.setDefaultUri("http://localhost:5005/ws/collaborator.wsdl?wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
