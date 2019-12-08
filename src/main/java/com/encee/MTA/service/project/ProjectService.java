package com.encee.MTA.service.project;

import java.util.List;

import com.encee.MTA.model.project.ProjectModel;
import com.encee.MTA.response.Response;

public interface ProjectService {

	public Response addProject(ProjectModel projectModel)throws Exception;
	
	public  List<ProjectModel> getProject()throws Exception;
	
	Response updateProject(ProjectModel projectMdodel) throws Exception;

	ProjectModel getProject(long id) throws Exception;

	Response deleteProject(long id) throws Exception;
}
