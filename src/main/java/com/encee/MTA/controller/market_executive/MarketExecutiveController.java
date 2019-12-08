package com.encee.MTA.controller.market_executive;

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
import com.encee.MTA.model.market_executive.MarketExecutiveModel;
import com.encee.MTA.response.ErrorObject;
import com.encee.MTA.response.Response;
import com.encee.MTA.service.market_executive.MarketExecutiveService;
import com.encee.MTA.utils.CommonUtils;

@RestController
@RequestMapping("/v4")
public class MarketExecutiveController {

	private static final Logger logger=LoggerFactory.getLogger(MarketExecutiveController.class);
	
	@Autowired
	MarketExecutiveService marketExecutiveService;
	
	
//Add Customer Data Start code Here 
	
	@RequestMapping(value = "/add",method=RequestMethod.POST,produces ="Application/json")
	public Response addMarketExecutive(@RequestBody MarketExecutiveModel marketExecutiveModel ,HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		logger.info("addParent: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
		logger.info("addUser: Received request: "+ CommonUtils.getJson(marketExecutiveModel));
		return marketExecutiveService.addMarketExecutive(marketExecutiveModel);
	}
	
//	Deleting Customer Data Start Here
	
	@RequestMapping(value = "/delete/{executiveId}",method=RequestMethod.DELETE,produces ="Application/json")
	public @ResponseBody Response DeleteMarketExecutive (@PathVariable ("executiveId")long id,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Delete MarketExecutive :Received request url :" + request.getRequestURL().toString()
				+((request.getQueryString() == null) ? "": "?" + request.getQueryString().toString()));
		return marketExecutiveService.deleteMarketExecutive(id);
	}
	
	// Getting Customer Single Id Code Start Here.
	
	@RequestMapping(value = "/executive/{id}",method=RequestMethod.GET,produces="Application/json")
	public @ResponseBody String getMarketExecutive(@PathVariable("id") long id,HttpServletRequest request,HttpServletResponse response)
    throws Exception{
		logger.info("Getting data :Recevied request url :"+request.getRequestURL().toString()
				+((request.getQueryString() == null) ? "" : "?" +request.getQueryString().toString()));
		MarketExecutiveModel marketExecutiveModel=marketExecutiveService.getMarketExecutive(id);
		Response res = CommonUtils.getResponseObject("marketExecutiveList details");
		if(marketExecutiveModel == null) {
			ErrorObject err = CommonUtils.getErrorResponse("MarketExecutive Not Found", "MarketExecutive Not Found");
			res.setError(err);
			res.setStatusText(StatusCode.ERROR.name());
		} 
		else
		{
			res.setData(marketExecutiveModel);
		}
		logger.info("Get marketExecutive :Send Response");
	      return CommonUtils.getJson(res);
	}
	
	//Getting All Customer Code Start Here.
	
	@RequestMapping(value = "/executive",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String getMarketExecutive(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Getting data: Recevied request:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
		
		       List<MarketExecutiveModel>list=marketExecutiveService.getMarketExecutive();
				Response res=CommonUtils.getResponseObject("List of MarketExecutive Data");
				
				if(list==null) {
					ErrorObject err=CommonUtils.getErrorResponse("MarketExecutive Not Found", "MarketExecutive Not Found");
					res.setError(err);
					res.setStatusText(StatusCode.ERROR.name());
				}else {
					res.setData(list);
				}
					logger.info("get MarketExecutive: sent response");
					return CommonUtils.getJson(res);
	}
	
	//updating Customer Code Start Here.
	
	@RequestMapping(value = "/executive",method = RequestMethod.PUT,produces = "Application/json")
	public Response updateMarketExecutive(@RequestBody MarketExecutiveModel marketExecutiveModel ,HttpServletRequest request,HttpServletResponse response)
			throws Exception{
		logger.info("Getting Data Recevied request:"+request.getRequestURL().toString()
				+((request.getQueryString()==null)?"":"?"+request.getQueryString().toString()));
		logger.info("Update MarketExecutive: Recevied request"+CommonUtils.getJson(marketExecutiveModel));
		return marketExecutiveService.updateMarketExecutive(marketExecutiveModel);
	}
}
