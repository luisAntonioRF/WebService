package com.luis.app.cliente.soap.client;

import javax.xml.bind.JAXBElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.luis.app.cliente.soap.schema.CollaboratorRequest;
import com.luis.app.cliente.soap.schema.CollaboratorResponse;
import com.luis.app.cliente.soap.schema.ObjectFactory;

public class CollaboratorSoapClient extends WebServiceGatewaySupport {
	
	private static final Logger logger = LogManager.getLogger(CollaboratorSoapClient.class);
	
	public CollaboratorResponse getCollaborator(Integer action,Integer id) {
		ObjectFactory objFactory =  new ObjectFactory();
		CollaboratorRequest request = objFactory.createCollaboratorRequest();
		request.setAction(action);
		request.setId(id);
		JAXBElement<CollaboratorRequest> collaboratorRequest = objFactory.createCollaboratorRequest(request);
		
		JAXBElement<CollaboratorResponse> response = (JAXBElement<CollaboratorResponse>) getWebServiceTemplate().marshalSendAndReceive(
				collaboratorRequest, new SoapActionCallback("http://www.example.org/collaborator"));
		logger.info("TOTAL COLLABORATOR"+response.getValue().getCollaboratorDetail().size());
		
		return response.getValue();
	}
}
