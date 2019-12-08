package com.encee.MTA.dao.market_executive;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.domain.market_executive.MarketExecutiveDomain;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Repository
@Transactional
public class MarketExecutiveDAOImpl implements MarketExecutiveDAO {

	@Autowired
	EntityManager entityManager;
	
	private static final Logger logger=LoggerFactory.getLogger(MarketExecutiveDAOImpl.class);

	@Override
	public Response addMarketExecutive(MarketExecutiveDomain marketExecutiveDomain) {
		Response response=CommonUtils.getResponseObject("Add Customer Data");
		try {
			entityManager.persist(marketExecutiveDomain);
			response.setStatusText(StatusCode.SUCCESS.name());
			response.setStatus(StatusCode.SUCCESS.getCode());
			response.setData(marketExecutiveDomain);
		}
		catch(Exception e) {
			logger.error("Exception create in MarketExecutiveDAOImpl" + e.getMessage());
			response.setStatus(StatusCode.ERROR.getCode());
			response.setStatusText(StatusCode.ERROR.getDesc());
		}
		return response;
	}

	@Override
	public MarketExecutiveDomain getMarketExecutive(long executiveId) throws Exception {
		try 
		{
			String hql = "From MarketExecutiveDomain where executiveId=?1 and isActive=true";
			return (MarketExecutiveDomain) entityManager.createQuery(hql).setParameter(1,executiveId).getSingleResult();
		}
			catch (EmptyResultDataAccessException e) 
			{
				return null;
			} 
			catch (Exception e) 
			{
				logger.error("Exception in getting Customer Data"+ e.getMessage());
				return null;
			}
		}

	@Override
	public Response updateMarketExecutive(MarketExecutiveDomain marketingExecutive) throws Exception {
		Response response=CommonUtils.getResponseObject("Updating MarketingExecutive Data");
		try {
			MarketExecutiveDomain marketExecutives=getMarketExecutive(marketingExecutive.getExecutiveId());
			marketExecutives.setExecutiveName(marketExecutives.getExecutiveName());
			marketExecutives.setAssignedProject(marketingExecutive.getAssignedProject());
			marketExecutives.setRegistration(marketingExecutive.getRegistration());
			marketExecutives.setState(marketingExecutive.getState());
			marketExecutives.setCity(marketingExecutive.getCity());
			marketExecutives.setEmailId(marketingExecutive.getEmailId());
			marketExecutives.setMobileNumber(marketingExecutive.getMobileNumber());
			marketExecutives.setDateOfBirth(marketingExecutive.getDateOfBirth());
			marketExecutives.setGender(marketingExecutive.getGender());
			marketExecutives.setPinCode(marketingExecutive.getPinCode());
	
			 entityManager.flush();
			 response.setStatusText(StatusCode.SUCCESS.name());
		}
		catch(Exception e) {
			logger.error("Exception in updating Customer Data",e);
			response.setStatusText(StatusCode.ERROR.name());
			response.setError(e.getMessage());
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MarketExecutiveDomain> getMarketExecutive() throws Exception 
	{
		try {
			String hql="From MarketExecutiveDomain where isActive=true";
			return (List<MarketExecutiveDomain>)entityManager.createQuery(hql).getResultList();
		}
		catch (Exception e) {
			logger.error("Exception in Getting Data", e);
		}
		return null;
		
		
	}

	@Override
	public Response deleteMarketExecutive(long executiveId) throws Exception {
		Response response = CommonUtils.getResponseObject("Deleted Customer Data ");
		try {
			MarketExecutiveDomain marketExecutiveDomain=getMarketExecutive(executiveId);
			marketExecutiveDomain.setActive(false);
			entityManager.flush();
			response.setStatusText(StatusCode.SUCCESS.name());
		}
		catch(Exception ex) {
			logger.error("Exception in Deleting Customer Data",ex);
			response.setStatusText(StatusCode.ERROR.name());
			response.setError(ex.getMessage());
		}
		return response;
	}

	
	
}
