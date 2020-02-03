package com.sbs.qa.stepImplementation;

import com.sbs.qa.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class API extends TestBase {
    int statusCode;


    public API(){
        super();
    }


    @BeforeMethod
    public void setup(){
      initialization();
    }

    @Test (priority = 1)
    public void testGetArchiveAudioMp3Files(){
        // Initialize the end-point
        RestAssured.baseURI=prop.getProperty("api_url");

        RestAssured.requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation().build();

        //execute the Get method and store the response
       Response response =  RestAssured.given().log().uri().get();

            //printing the status code=200
           System.out.println("status code is : " + response.getStatusCode());

           //storing statusCode into int variable = statusCode
        statusCode =   response.getStatusCode();

       //Assert the status code to 200
        Assert.assertEquals(200,statusCode,"statusCode is not matching");

        //initializing JsonPath
        JsonPath jsonPath = new JsonPath(response.asString());

        //getting list of archiveAudio.mp3
       List<String> list =  jsonPath.getList("archiveAudio.mp3");

       for(int i=0;i<list.size();i++){
           System.out.println("list of archiveAudio.mp3 : " + list.get(i));
       }





    }

    @Test(priority = 2)
    public void TestToNavigateTo(){
        //navigate to fe url

        driver.navigate().to(prop.getProperty("fe_url"));

        //please provide details what to assert?

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
