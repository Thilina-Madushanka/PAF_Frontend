package com;

import model.Bill;

//for REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//for JSON
import com.google.gson.*;

//for XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Bill")

public class BillService {
	
	Bill BillObj = new Bill();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readBill() {
		
		return BillObj.readBill();
		
	}
	
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String insertBill(@FormParam("userName") String userName,
							@FormParam("userAddress") String userAddress,
							@FormParam("userMobile") String userMobile,
							@FormParam("units") Float units,
							@FormParam("amount") Float amount,
							@FormParam("arrears") Float arrears,
							@FormParam("finalBill") Float finalBill)
	{
		
		String output = BillObj.insertBill(userName, userAddress, userMobile, units , amount , arrears, finalBill);
		return output;
		
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBill(String BillData)
	{
		//Convert input string to a JSON object
		JsonObject BillObject = new JsonParser().parse(BillData).getAsJsonObject();
		
		//Read values from JSON object
		Integer userID = BillObject.get("userID").getAsInt();
		String userName = BillObject.get("userName").getAsString();
		String userAddress = BillObject.get("userAddress").getAsString();
		String userMobile = BillObject.get("userMobile").getAsString();
		Float units = BillObject.get("units").getAsFloat();
		Float amount = BillObject.get("amount").getAsFloat();
		Float arrears = BillObject.get("arrears").getAsFloat();
		Float finalBill = BillObject.get("finalBill").getAsFloat();

		
//		float units = BillObject.getFloat("units");
//		float amount = BillObject.getFloat("amount");
//		float arrears = BillObject.getFloat("arrears");
//		float finalBill = BillObject.getFloat("finalBill");
		
	
		
		String output = BillObj.updateBill(userID, userName, userAddress, userMobile, units , amount , arrears , finalBill);
		return output;
		
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBill(String BillData)
	{
		//Convert input string to a JSON object
		Document doc = Jsoup.parse(BillData, "", Parser.xmlParser());
		
		//Read values from JSON object
		String userID = doc.select("userID").text();
		
		String output = BillObj.deleteBill(userID);
		return output;
		
	}

}
