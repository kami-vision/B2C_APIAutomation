package com.kami;

import com.kami.API.APIBuilder;
import com.kami.report.TestListners;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class postAPI extends BaseTest {
public APIBuilder apiBuilder = null;

	  @BeforeTest
	  public void setup() {
		  try {
			  apiBuilder = new APIBuilder();
		  }catch(Exception e){
			  e.printStackTrace();
		  }


	  }
	@Test
	public void postAddProConfig() {
		Response response = apiBuilder.postAddProConfig("123123","1",
				"1","1","1","4777393","1","pGk8ofW6lhGLsXVjs018fCuzlFI=");
		response.getBody().prettyPrint();
		Assert.assertEquals(200,response.getStatusCode());
	}

	  @Test
	  public void getproUserDetail() {
		 Response response = apiBuilder.getProUserDetails("4777393","1","4777393","j0pcYkwJR7spw3Qup5lRzaL0QCo");
		  response.getBody().prettyPrint();
		  Assert.assertEquals(200,response.getStatusCode());
	  }

	@Test
	public void getGenerateQRCode() {
		Response response = apiBuilder.getGenerateQRCode("4777393","1","4777393","mx2xja6+6TA+vwjgWtpGh6wE15s=");
		response.getBody().prettyPrint();
		Assert.assertEquals(200,response.getStatusCode());
	}


	@Test
	public void getCameraInfo() {
		Response response = apiBuilder.getCameraInfo("5597448","1","4777393","1655385105770","jn0Eaq/k4HzGkXVia9CLrnGMw80=");
		response.getBody().prettyPrint();
		Assert.assertEquals(200,response.getStatusCode());
	}

	@Test
	public void getShareInvitation() {
		Response response = apiBuilder.getShareInvitation("5548377","1","4777393","1655385105770");
		response.getBody().prettyPrint();
		Assert.assertEquals(200,response.getStatusCode());
	}

	@Test
	public void getInvitationListFromOthers() {
		Response response = apiBuilder.getInvitationListFromOthers("5332039","1","1650157350","j7MskFCs3bbZhzljFVs0q2vShh4=");
		response.prettyPrint();
		Assert.assertEquals(200,response.getStatusCode());
	}

	@Test
	public void getSupportedCameraList() {
		Response response = apiBuilder.getSupportedCameraList("4777393","1","1655384105770","1fUyzpEWoOnUDvUpk93nnTTX3D4==");
		response.prettyPrint();
		Assert.assertEquals(200,response.getStatusCode());
	}

	@Test
	public void getSendHelp() {
		Response response = apiBuilder.getSendHelp("5380385","1","1650187340","HYQmScE0wyC/xhvc4NzBO72t3lI==");
		response.prettyPrint();
		Assert.assertEquals(200,response.getStatusCode());
	}

	@Test
	public void getQueryListAlarmTrigger() {
		Response response = apiBuilder.getQueryListAlarmTrigger("4777393","1","1650187349","UuB5Bx9jB1NHPNahHxQd1uTtGyI=");
		response.prettyPrint();
		Assert.assertEquals(200,response.getStatusCode());
	}

}
