package com.encee.MTA.dao.market_executive;

import java.util.List;

import com.encee.MTA.domain.market_executive.MarketExecutiveDomain;
import com.encee.MTA.response.Response;

public interface MarketExecutiveDAO {

	public Response addMarketExecutive(MarketExecutiveDomain marketExecutiveDomain)throws Exception;
	
	public Response updateMarketExecutive(MarketExecutiveDomain marketExecutiveDomain)throws Exception;
	
	public List<MarketExecutiveDomain>getMarketExecutive()throws Exception;

	MarketExecutiveDomain getMarketExecutive(long l) throws Exception;

	Response deleteMarketExecutive(long executiveId) throws Exception;
}
