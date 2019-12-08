package com.encee.MTA.controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.model.project.ProjectModel;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.service.project.ProjectService;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping("/v5")
public class ProjectController {

	private static final Logger logger=LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectService;
	
	
//Add Customer Data Start code Here 
	
	@RequestMapping(value = "/add",method=RequestMethod.POST,produces ="Application/json")
	public Response addProject(@RequestBody ProjectModel projectMdoel ,HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("addParent: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addUser: Received request: "+ CommonUtils.getJson(projectMdoel));
		return projectService.addProject(projectMdoel);
	}
	
//	Deleting Customer Data Start Here
	
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE,produces ="Application/json")
	public @ResponseBody Response DeleteProject (@PathVariable ("id")long id,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Delete Project :Received request url :" + request.getRequestURL().toString()
				+((request.getQueryString() == null) ? "": "?" + request.getQueryString().toString()));
		return projectService.deleteProject(id);
	}
	
	// Getting Customer Single Id Code Start Here.
	
	@RequestMapping(value = "/Project/{id}",method=RequestMethod.GET,produces="Application/json")
	public @ResponseBody String getProject(@PathVariable("id") long id,HttpServletRequest request,HttpServletResponse response)
    throws Exception{
		logger.info("Getting data :Recevied request url :"+request.getRequestURL().toString()
				+((request.getQueryString() == null) ? "" : "?" +request.getQueryString().toString()));
		ProjectModel projectModel=projectService.getProject(id);
		Response res = CommonUtils.getResponseObject("Project List details");
		if(projectModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("Project Not Found", "Project Not Found");
			res.setError(err);
			res.setStatusText(StatusCode.ERROR.name());
		} 
		else
		{
			res.setData(projectModel);
		}
		logger.info("Get Project:Send Response");
	      return CommonUtils.getJson(res);
	}
	
	//Getting All Customer Code Start Here.
	
	@RequestMapping(value = "/Project",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String getProject(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Getting data: Recevied request:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
		
		       List<ProjectModel>list=projectService.getProject();
				Response res=CommonUtils.getResponseObject("List of Project  Data");
				
				if(list==null) {
					ErrorObject err=CommonUtils.getErrorResponse("Project Not Found", "Project Not Found");
					res.setError(err);
					res.setStatusText(StatusCode.ERROR.name());
				}else {
					res.setData(list);
				}
					logger.info("get Project: sent response");
					return CommonUtils.getJson(res);
	}
	
	//updating Customer Code Start Here.
	
	@RequestMapping(value = "/Project",method = RequestMethod.PUT,produces = "Application/json")
	public Response updateProject(@RequestBody ProjectModel projectModel ,HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		logger.info("Getting Data Recevied request:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
		logger.info("Update Customer: Recevied request"+CommonUtils.getJson(projectModel));
		return projectService.updateProject(projectModel);
	}
}
