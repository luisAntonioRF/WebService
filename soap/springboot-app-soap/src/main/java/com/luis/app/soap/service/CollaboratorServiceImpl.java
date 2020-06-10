package com.luis.app.soap.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.app.soap.dao.CollaboratorRepository;
import com.luis.app.soap.entity.Collaborator;

@Service("collaboratorService")
@Transactional
public class CollaboratorServiceImpl implements CollaboratorService  {
	private static final Logger logger = LogManager.getLogger(CollaboratorServiceImpl.class);
	
	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	@Override
	public Collaborator getById(Long id) {
		return collaboratorRepository.getCollaborator(id);
	}

	@Override
	public List<Collaborator> getAll() {
		logger.info("Tamño del Registro"+collaboratorRepository.getAll().size());
		return collaboratorRepository.getAll();
	}
}
