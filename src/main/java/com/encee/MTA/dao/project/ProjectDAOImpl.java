package com.encee.MTA.dao.project;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.domain.project.ProjectDomain;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	EntityManager entityManager;
	
	private static final Logger logger=LoggerFactory.getLogger(ProjectDAOImpl.class);

	@Override
	public Response addProject(ProjectDomain projectDomain) {
		Response response=CommonUtils.getResponseObject("Add Project Data");
		try {
			entityManager.persist(projectDomain);
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setStatus(StatusCode.SUCCESS.getCode());
			response.setData(projectDomain);
		}
		catch(Exception e) {
			logger.error("Exception create in ProjectDAOImpl" + e.getMessage());
			response.setStatus(StatusCode.ERROR.getCode());
			response.setStatusText(StatusCode.ERROR.getDesc());
		}
		return response;
	}

	@Override
	public ProjectDomain getProject(long id) throws Exception {
		try 
		{
			String hql = "From ProjectDomain where id=?1 and isActive=true";
			return (ProjectDomain) entityManager.createQuery(hql).setParameter(1,id).getSingleResult();
		}
			catch (EmptyResultDataAccessException e) 
			{
				return null;
			} 
			catch (Exception e) 
			{
				logger.error("Exception in getting Project Data"+ e.getMessage());
				return null;
			}
		}

	@Override
	public Response updateProject(ProjectDomain project) throws Exception {
		Response response=CommonUtils.getResponseObject("Updating Project Data");
		try {
			ProjectDomain projects=getProject(project.getId());
			projects.setProjectName(project.getProjectName());
			projects.setVendorName(project.getVendorName());
			projects.setProjectManager(project.getProjectManager());
			projects.setStatus(project.getStatus());
			projects.setProjectDescription(project.getProjectDescription());
			projects.setEstimatedHours(project.getEstimatedHours());
			projects.setTargetcomplitionDate(project.getTargetcomplitionDate());
			
			 entityManager.flush();
			 response.setStatusText(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception in updating Project Data",e);
			response.setStatusText(StatusCode.ERROR.name());
			response.setError(e.getMessage());
		}
		return response;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectDomain> getProject() throws Exception 
	{
		try {
			String hql="From ProjectDomain where isActive=true";
			return (List<ProjectDomain>)entityManager.createQuery(hql).getResultList();
		}
		catch (Exception e) {
			logger.error("Exception in Getting Data", e);
		}
		return null;
		
		
	}

	@Override
	public Response deleteProject(long id) throws Exception {
		Response response = CommonUtils.getResponseObject("Deleted Project Data ");
		try {
			ProjectDomain projectDomain=getProject(id);
			projectDomain.setActive(false);
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}
		catch(Exception ex) {
			logger.error("Exception in Deleting Project Data",ex);
			response.setStatusText(StatusCode.ERROR.name());
			response.setError(ex.getMessage());
		}
		return response;
	}

	
	
}
