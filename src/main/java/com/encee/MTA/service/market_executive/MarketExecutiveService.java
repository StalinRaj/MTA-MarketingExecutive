package com.encee.MTA.service.market_executive;

import java.util.List;

import com.encee.MTA.model.market_executive.MarketExecutiveModel;
import com.encee.MTA.response.Response;

public interface MarketExecutiveService {

	public Response addMarketExecutive(MarketExecutiveModel marketExecutiveModel)throws Exception;
	
	public  List<MarketExecutiveModel> getMarketExecutive()throws Exception;
	
	Response updateMarketExecutive(MarketExecutiveModel marketExecutiveMdodel) throws Exception;

	MarketExecutiveModel getMarketExecutive(long executiveId) throws Exception;

	Response deleteMarketExecutive(long executiveId) throws Exception;
}
