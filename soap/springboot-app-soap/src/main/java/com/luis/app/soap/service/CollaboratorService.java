package com.luis.app.soap.service;

import java.util.List;

import com.luis.app.soap.entity.Collaborator;

public interface CollaboratorService {
	
	public Collaborator getById(Long id);
	
	public List<Collaborator> getAll();
}
