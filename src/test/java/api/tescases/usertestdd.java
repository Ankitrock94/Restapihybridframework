package api.tescases;


import org.testng.Assert;

import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class usertestdd {


	
	@Test(priority=1,dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String UserId, String UserName , String FirstName , String LastName ,String Email , String Password , String Phone)
	{

		user userPayload = new user();

		userPayload.setId(Integer.parseInt(UserId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		Response response = userEndPoints.createUser(userPayload);

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
	}

	
}