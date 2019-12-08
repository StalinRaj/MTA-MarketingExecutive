package com.encee.MTA.mapper.market_executive;

import org.springframework.stereotype.Component;

import com.encee.MTA.domain.market_executive.MarketExecutiveDomain;
import com.encee.MTA.mapper.AbstractMapper;
import com.encee.MTA.model.market_executive.MarketExecutiveModel;

@Component
public class MarketExecutiveMapper extends AbstractMapper <MarketExecutiveModel ,MarketExecutiveDomain>{

	@Override
	public Class<MarketExecutiveModel> entityType() {
		return MarketExecutiveModel.class;
	}

	@Override
	public Class<MarketExecutiveDomain> modelType() {
		return MarketExecutiveDomain.class;
	}

}
