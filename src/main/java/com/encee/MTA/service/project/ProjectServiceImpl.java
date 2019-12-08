package com.encee.MTA.service.project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.dao.project.ProjectDAO;
import com.encee.MTA.domain.project.ProjectDomain;
import com.encee.MTA.mapper.project.ProjectMapper;
import com.encee.MTA.model.project.ProjectModel;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired
	ProjectMapper projectMapper;
	
	private static final Logger logger=LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Override
	public Response addProject(ProjectModel projectModel) throws Exception {
		Response response=CommonUtils.getResponseObject("Project Creation ");
		try {
			ProjectDomain projectDomain= new ProjectDomain();
			BeanUtils.copyProperties(projectModel, projectDomain);
			response=projectDAO.addProject(projectDomain);
		}
		catch(Exception e) {
			logger.error("Exception in Adding Project Data " + e.getMessage());
			response.setStatusText(StatusCode.ERROR.getDesc());
			response.setStatus(StatusCode.ERROR.getCode());
		}
		return response;
	}

	@Override
	public ProjectModel getProject(long id) throws Exception {
		try {
			ProjectModel projectModel= new ProjectModel();
			ProjectDomain projectDomain=projectDAO.getProject(id);
			BeanUtils.copyProperties(projectDomain,projectModel);
			return projectModel;
		}
		catch(Exception e) {
			logger.info("Exception in Getting Project id",e );
			return null;
		}
	}

	@Override
	public List<ProjectModel> getProject() throws Exception {
		try {
			List<ProjectDomain>list=projectDAO.getProject();
			return projectMapper.entityList(list);
		}
		catch(Exception e) {
			logger.error("Exception in getting Project Data",e);
		}
		return null;
	}

	@Override
	public Response deleteProject(long id) throws Exception {
		try {
			return projectDAO.deleteProject(id);
		}
		catch(Exception e) {
			logger.info("Getting probleam to deleting Project Data",e);
			return null;
			
		}
	}
	
	@Override
	public Response updateProject(ProjectModel projectModel)throws Exception
	{
		ProjectDomain project=new ProjectDomain();
		BeanUtils.copyProperties(projectModel, project);
		Response response=projectDAO.updateProject(project);
		return response;
	}

}
