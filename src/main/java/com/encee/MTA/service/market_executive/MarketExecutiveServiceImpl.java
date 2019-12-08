package com.encee.MTA.service.market_executive;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encee.MTA.constants.StatusCode;
import com.encee.MTA.dao.market_executive.MarketExecutiveDAO;
import com.encee.MTA.domain.market_executive.MarketExecutiveDomain;
import com.encee.MTA.mapper.market_executive.MarketExecutiveMapper;
import com.encee.MTA.model.market_executive.MarketExecutiveModel;
import com.encee.MTA.response.Response;
import com.encee.MTA.utils.CommonUtils;

@Service
public class MarketExecutiveServiceImpl implements MarketExecutiveService {
	
	@Autowired
	MarketExecutiveDAO marketExecutiveDAO;
	
	@Autowired
	MarketExecutiveMapper marketExecutiveMapper;
	
	private static final Logger logger=LoggerFactory.getLogger(MarketExecutiveServiceImpl.class);

	@Override
	public Response addMarketExecutive(MarketExecutiveModel marketExecutiveModel) throws Exception {
		Response response=CommonUtils.getResponseObject("MarketExecutive Creation ");
		try {
			MarketExecutiveDomain marketExecutiveDomain= new MarketExecutiveDomain();
			BeanUtils.copyProperties(marketExecutiveModel, marketExecutiveDomain);
			response=marketExecutiveDAO.addMarketExecutive(marketExecutiveDomain);
		}
		catch(Exception e) {
			logger.error("Exception in Adding Customer Data " + e.getMessage());
			response.setStatusText(StatusCode.ERROR.getDesc());
			response.setStatus(StatusCode.ERROR.getCode());
		}
		return response;
	}

	@Override
	public MarketExecutiveModel getMarketExecutive(long executiveId) throws Exception {
		try {
			MarketExecutiveModel marketExecutiveModel= new MarketExecutiveModel();
			MarketExecutiveDomain marketExecutiveDomain=marketExecutiveDAO.getMarketExecutive(executiveId);
			BeanUtils.copyProperties(marketExecutiveDomain,marketExecutiveModel);
			return marketExecutiveModel;
		}
		catch(Exception e) {
			logger.info("Exception in Getting customer id",e );
			return null;
		}
	}

	@Override
	public List<MarketExecutiveModel> getMarketExecutive() throws Exception {
		try {
			List<MarketExecutiveDomain>list=marketExecutiveDAO.getMarketExecutive();
			return marketExecutiveMapper.entityList(list);
		}
		catch(Exception e) {
			logger.error("Exception in getting MarketExecutive Data",e);
		}
		return null;
	}

	@Override
	public Response deleteMarketExecutive(long executiveId) throws Exception {
		try {
			return marketExecutiveDAO.deleteMarketExecutive(executiveId);
		}
		catch(Exception e) {
			logger.info("Getting probleam to deleting MarketExecutive Data",e);
			return null;
			
		}
	}
	
	@Override
	public Response updateMarketExecutive(MarketExecutiveModel marketExecutiveModel)throws Exception
	{
		MarketExecutiveDomain marketExecutive=new MarketExecutiveDomain();
		BeanUtils.copyProperties(marketExecutiveModel, marketExecutive);
		Response response=marketExecutiveDAO.updateMarketExecutive(marketExecutive);
		return response;
	}

}
