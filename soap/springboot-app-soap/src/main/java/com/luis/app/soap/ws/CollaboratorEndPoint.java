package com.luis.app.soap.ws;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.luis.app.soap.entity.Collaborator;
import com.luis.app.soap.schema.CollaboratorDetail;
import com.luis.app.soap.schema.CollaboratorRequest;
import com.luis.app.soap.schema.CollaboratorResponse;
import com.luis.app.soap.schema.ObjectFactory;
import com.luis.app.soap.service.CollaboratorServiceImpl;

@Endpoint
public class CollaboratorEndPoint<collaboratorResponse> {
	
	private static final String NAMESPACE_URI="http://www.example.org/collaborator";
	
	@Autowired
	CollaboratorServiceImpl customersServiceImpl;
	
	@PayloadRoot(namespace = NAMESPACE_URI,localPart = "collaboratorRequest")
	@ResponsePayload
	public JAXBElement<CollaboratorResponse> getCollborator(@RequestPayload JAXBElement<CollaboratorRequest> resquest){
		ObjectFactory objFactory = new ObjectFactory();
		CollaboratorResponse collaboratorResponseFactory =objFactory.createCollaboratorResponse();
		JAXBElement<CollaboratorResponse> collaboratorResponse = objFactory.createCollaboratorResponse(collaboratorResponseFactory);
		try {
			
			int action = resquest.getValue().getAction();
			
			if(action==1) {
				CollaboratorResponse collaboratorResponseObj = new CollaboratorResponse();
				List<Collaborator> listaCollaborator = customersServiceImpl.getAll();
				
				if(listaCollaborator!=null) {
					for (Collaborator collaborator : listaCollaborator) {
						CollaboratorDetail detail = new CollaboratorDetail();
						detail.setId(collaborator.getId().intValue());
						detail.setAlias(collaborator.getAlias());
						detail.setDni(collaborator.getDni());
						detail.setEmail(collaborator.getEmail());
						detail.setImageCollaborator(collaborator.getImg());
						detail.setName(collaborator.getName());
						detail.setPassword(collaborator.getPass());
						collaboratorResponseObj.getCollaboratorDetail().add(detail);
					}
					
				}
				
				collaboratorResponse.setValue(collaboratorResponseObj);
			}else if(action==2) {
				CollaboratorResponse collaboratorResponseObj = new CollaboratorResponse();
				Collaborator collaborator = customersServiceImpl.getById(new Long(resquest.getValue().getId()));
				CollaboratorDetail detail = new CollaboratorDetail();
				
				if(collaborator!=null) {
					detail.setId(collaborator.getId().intValue());
					detail.setAlias(collaborator.getAlias());
					detail.setDni(collaborator.getDni());
					detail.setEmail(collaborator.getEmail());
					detail.setImageCollaborator(collaborator.getImg());
					detail.setName(collaborator.getName());
					detail.setPassword(collaborator.getPass());
					collaboratorResponseObj.getCollaboratorDetail().add(detail);
					collaboratorResponse.setValue(collaboratorResponseObj);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collaboratorResponse;
	}
}
