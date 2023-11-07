package com.kami;

import com.kami.report.TestListners;
import io.restassured.RestAssured;
import org.testng.annotations.Listeners;

@Listeners(TestListners.class)
public class BaseTest {

    public void BaseTest(){

    }
}
