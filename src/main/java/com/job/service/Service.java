package com.job.service;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.job.business.FileProcess;
import com.job.dto.Agreement;

@Path("test")
public class Service {
	
	Logger logger = Logger.getLogger(Service.class.getName());
	
	@POST
	@Path("/store")
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON)
	public String storeFile(Agreement agreement) throws Exception{
		logger.info("storeFile(): "+agreement.toString());
		try {
			if(Agreement.validateAgreement(agreement)) {
				new FileProcess().storeFile(new Gson().toJson(agreement), agreement.getName());
				return "ok";
			}else {
				return "error - parametro name invalido: "+agreement.getName() + " o arreglo de productos invalidos";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "error - "+e.getMessage();
		}
		
	}
	
	@POST
	@Path("/agreement")
	@Consumes(MediaType.TEXT_PLAIN) 
	@Produces(MediaType.APPLICATION_JSON)
	public Object getAgreement(String path) throws Exception{
		logger.info("storeFile(): "+path);
		try {
			String json =new FileProcess().getFromFile(path);
			return new Gson().fromJson(json, Agreement.class);
		}catch(Exception e) {
			e.printStackTrace();
			return "error - "+e.getMessage();
		}
		
	}
	
}
