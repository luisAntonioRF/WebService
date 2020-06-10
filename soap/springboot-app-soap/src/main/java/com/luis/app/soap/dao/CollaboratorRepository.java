package com.luis.app.soap.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luis.app.soap.entity.Collaborator;

public interface CollaboratorRepository  extends JpaRepository<Collaborator, Long> {
	
	@Query("SELECT c FROM Collaborator c WHERE c.id= :id")
	public Collaborator getCollaborator(@Param("id") Long id);
	
	@Query("SELECT c FROM Collaborator c")
	public List<Collaborator> getAll();

}
