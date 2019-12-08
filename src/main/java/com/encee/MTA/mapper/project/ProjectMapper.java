package com.encee.MTA.mapper.project;

import org.springframework.stereotype.Component;

import com.encee.MTA.domain.project.ProjectDomain;
import com.encee.MTA.mapper.AbstractMapper;
import com.encee.MTA.model.project.ProjectModel;

@Component
public class ProjectMapper extends AbstractMapper <ProjectModel ,ProjectDomain>{

	@Override
	public Class<ProjectModel> entityType() {
		return ProjectModel.class;
	}

	@Override
	public Class<ProjectDomain> modelType() {
		return ProjectDomain.class;
	}

}
