package com.encee.MTA.dao.project;

import java.util.List;

import com.encee.MTA.domain.project.ProjectDomain;
import com.encee.MTA.response.Response;

public interface ProjectDAO {

	public Response addProject(ProjectDomain projectDomain)throws Exception;
	
	public Response updateProject(ProjectDomain projectDomain)throws Exception;
	
	public List<ProjectDomain>getProject()throws Exception;

	ProjectDomain getProject(long l) throws Exception;

	Response deleteProject(long id) throws Exception;
}
