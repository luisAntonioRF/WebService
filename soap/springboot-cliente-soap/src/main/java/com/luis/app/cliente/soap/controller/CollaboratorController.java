package com.luis.app.cliente.soap.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.app.cliente.soap.client.ClientCollaboratorConfig;
import com.luis.app.cliente.soap.client.CollaboratorSoapClient;
import com.luis.app.cliente.soap.schema.CollaboratorDetail;
import com.luis.app.cliente.soap.schema.CollaboratorResponse;

@RestController
@RequestMapping("/app")
public class CollaboratorController {
	
	private static final Logger logger = LogManager.getLogger(CollaboratorController.class);
	
	@GetMapping("/ws/{action}/{id}")
	public void getCollaborator(@PathVariable int action,@PathVariable int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ClientCollaboratorConfig.class);
		context.refresh();
		CollaboratorSoapClient client = context.getBean(CollaboratorSoapClient.class);
		CollaboratorResponse response = client.getCollaborator(action, id);
		
		for (CollaboratorDetail collab : response.getCollaboratorDetail()) {
			logger.info(":ALIAS:"+collab.getAlias());
		}
	}
}
