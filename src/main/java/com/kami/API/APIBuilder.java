package com.kami.API;


import com.kami.utilities.Util;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class APIBuilder {
public static Properties config = null;


    public APIBuilder() throws Exception {
        config = Util.readConfig("src/main/resources/config.properties");
        RestAssured.baseURI = config.getProperty("baseUri");
    }

    public Response getProUserDetails(String userid,String seq,String invitrUserId,String hmac) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .param("userid", userid)
                .param("seq", seq)
                .param("inviterUserId", invitrUserId)
                .param("hmac", hmac)
                .when()
                .get(EndPoints.UserProps)
                .then()
                .extract().response();
        //response.getBody().prettyPrint();
        return response;
    }
    public Response getCameraInfo(String userid,String seq,String invitrUserId,String timestamp,String hmac) {
    Response response = given()
            .contentType(ContentType.JSON)
            .param("userid", userid)
            .param("seq", seq)
            .param("inviterUserId", invitrUserId)
            .param("timestamp", timestamp)
            .param("hmac", hmac)
            .when()
            .get(EndPoints.Camera)
            .then()
            .extract().response();
    return response;
    }

    public Response getShareInvitation(String userId,String seq,String timestamp,String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("userid", userId)
                .param("seq", seq)
                .param("timestamp", timestamp)
                .param("hmac", hmac)
                .when()
                .get(EndPoints.Invite)
                .then()
                .extract().response();
        return response;
    }
    public Response getGenerateQRCode(String userId,String seq,String timestamp,String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("userid", userId)
                .param("seq", seq)
                .param("timestamp", timestamp)
                .param("hmac", hmac)
                .when()
                .get(EndPoints.QRCode)
                .then()
                .extract().response();
        return response;
    }
    public Response getSupportedCameraList(String userId,String seq,String timestamp,String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("userid", userId)
                .param("seq", seq)
                .param("timestamp", timestamp)
                .param("hmac", hmac)
                .when()
                .get(EndPoints.DeviceModels)
                .then()
                .extract().response();
        return response;
    }

    public Response getSendHelp(String userId,String seq,String timestamp,String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("userid", userId)
                .param("seq", seq)
                .param("timestamp", timestamp)
                .param("hmac", hmac)
                .when()
                .get(EndPoints.SendHelp)
                .then()
                .extract().response();
        return response;
    }
    public Response getproConfig(String userId,String seq,String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("userid", userId)
                .param("seq", seq)
                .param("hmac", hmac)
                .when()
                .get(EndPoints.Config)
                .then()
                .extract().response();
        return response;
    }

    public Response getInvitationListFromOthers(String userID,String seq,String timestamp, String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("userid", userID)
                .param("seq", seq)
                .param("timestamp", timestamp)
                .param("hmac", hmac)
                .when()
                .get(EndPoints.InviteeList)
                .then()
                .extract().response();
        return response;
    }

    public Response getQueryListAlarmTrigger(String userID,String seq,String timestamp, String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("userid", userID)
                .param("seq", seq)
                .param("timestamp", timestamp)
                .param("hmac", hmac)
                .when()
                .get(EndPoints.AlarmTrigger)
                .then()
                .extract().response();
        return response;
    }

    public Response postAddProConfig(String alarmPermitNumber,String disarmBiometricsEnable,String disarmPincodeEnable,
                                     String enable,String mode,String userID,String seq, String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"alarmPermitNumber\": "+alarmPermitNumber+",\n" +
                        "    \"disarmBiometricsEnable\": "+disarmBiometricsEnable+"+,\n" +
                        "    \"disarmPincodeEnable\": "+disarmPincodeEnable+",\n" +
                        "    \"enable\": "+enable+",\n" +
                        "    \"mode\": "+mode+",\n" +
                        "    \"userid\": "+userID+",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"hmac\": \""+hmac+"\n" +
                        "}")
                .when()
                .post(EndPoints.Config)
                .then()
                .extract().response();
        return response;
    }

    public Response postAddProAddress(String city,String state,String streetAddress1,
                                     String streetAddress2,String userId,String zipcode,String seq, String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"city\": \""+city +"\",\n" +
                        "    \"state\": \""+state+"\",\n" +
                        "    \"streetAddr1\": \""+streetAddress1+"\",\n" +
                        "    \"streetAddr2\": \""+streetAddress2+"\",\n" +
                        "    \"userid\": "+userId+",\n" +
                        "    \"zipCode\": \""+zipcode+"\",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"hmac\": \""+hmac+"\"\n" +
                        "}")
                .when()
                .post(EndPoints.monitorUserAddress)
                .then()
                .extract().response();
        return response;
    }

    public Response postTriggerEvent(String userId,String region,String eventType,
                                      String videoURL,String verifedByUser,String kamiURL,String seq, String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"userid\": "+userId+",\n" +
                        "    \"region\": \""+region+"\",\n" +
                        "    \"event_type\": \""+eventType+"\",\n" +
                        "    \"video_url\": \""+videoURL+"\",\n" +
                        "    \"verified_by_user\": "+verifedByUser+",\n" +
                        "    \"kami_url\": \""+kamiURL+"\",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"hmac\": \""+hmac+"\"\n" +
                        "}")
                .when()
                .post(EndPoints.MonitoringTrigger)
                .then()
                .extract().response();
        return response;
    }

    public Response postSendInvitation(String dynamicLink,String seq,String shareRight,
                                     String shareToEmail,String shareType,String timeStamp,String uids, String userId,String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"dynamicLink\": \""+dynamicLink+"\",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"shareRight\": "+shareRight+",\n" +
                        "    \"shareToEmail\": \""+shareToEmail+"\",\n" +
                        "    \"shareType\": "+shareType+",\n" +
                        "    \"timestamp\": "+timeStamp+",\n" +
                        "    \"uids\": \""+uids+"\",\n" +
                        "    \"userid\": "+userId+",\n" +
                        "    \"hmac\": \""+hmac+"\"\n" +
                        "}")
                .when()
                .post(EndPoints.Invite)
                .then()
                .extract().response();
        return response;
    }

    public Response putEditProConfig(String mode,String userID,String inviteUserId,String seq, String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"mode\": "+mode+",\n" +
                        "    \"userid\": "+userID+",\n" +
                        "    \"inviteUserId\": "+inviteUserId+",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"hmac\": \""+hmac+"\n" +
                        "}")
                .when()
                .put(EndPoints.Config)
                .then()
                .extract().response();
        return response;
    }

    public Response putEditProAddress(String city,String state,String streetAddress1,
                                      String streetAddress2,String userId,String zipcode){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"city\": \""+city +"\",\n" +
                        "    \"state\": \""+state+"\",\n" +
                        "    \"streetAddr1\": \""+streetAddress1+"\",\n" +
                        "    \"streetAddr2\": \""+streetAddress2+"\",\n" +
                        "    \"userid\": "+userId+",\n" +
                        "    \"zipCode\": \""+zipcode+"\",\n" +
                        "}")
                .when()
                .put(EndPoints.Config)
                .then()
                .extract().response();
        return response;
    }

    public Response putEditProUserDetails(String accessDuration,String backupContact,String countryCode,String disarmPincode,
                                          String disarmQacodeStatus,String inviteUserId,String mobile,String lastName,String firstName,
                                          String safeWord,String status,String userId,String seq,String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"accessDuration\": \""+accessDuration+"\",\n" +
                        "    \"backupContact\": "+backupContact+",\n" +
                        "    \"countryCode\": \""+countryCode+"\",\n" +
                        "    \"disarmPincode\": \""+disarmPincode+"\",\n" +
                        "    \"disarmQrcodeStatus\": "+disarmQacodeStatus+",\n" +
                        "    \"inviterUserId\": "+inviteUserId+",\n" +
                        "    \"mobile\": \"+"+mobile+"\",\n" +
                        "    \"lastName\": \""+lastName+"\",\n" +
                        "    \"firstName\": \""+firstName+"\",\n" +
                        "    \"safeWord\": \""+safeWord+"\",\n" +
                        "    \"status\": "+status+",\n" +
                        "    \"userid\": "+userId+",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"hmac\": \""+hmac+"\"\n" +
                        "}")
                .when()
                .put(EndPoints.Config)
                .then()
                .extract().response();
        return response;
    }
    public Response putUpdateOrRevokeQRCode(String inviteUserId,String userId,String seq,
                                      String hmac,String disarmQrcode){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"inviterUserId\": "+inviteUserId+",\n" +
                        "    \"userid\": "+userId+",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"hmac\": \""+hmac+"\",\n" +
                        "    \"disarmQrcode\": \""+disarmQrcode+"\"\n" +
                        "}")
                .when()
                .put(EndPoints.Config)
                .then()
                .extract().response();
        return response;
    }

    public Response putValidateQRCode(String disarmQrcode,String seq,String userId,
                                      String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"disarmQrcode\": \""+disarmQrcode+"\",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"userid\": "+userId+",\n" +
                        "    \"hmac\": \""+hmac+"\"\n" +
                        "}")
                .when()
                .put(EndPoints.Config)
                .then()
                .extract().response();
        return response;
    }

    public Response putValidatePincode(String disarmQrcode,String seq,String userId,String inviteUserId,
                                      String hmac){
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"disarmQrcode\": \""+disarmQrcode+"\",\n" +
                        "    \"seq\": "+seq+",\n" +
                        "    \"userid\": "+userId+",\n" +
                        "    \"inviterUserId\": "+inviteUserId+",\n" +
                        "    \"hmac\": \""+hmac+"\"\n" +
                        "}")
                .when()
                .put(EndPoints.Config)
                .then()
                .extract().response();
        return response;
    }

    public Response putAddUpdateCamera(String armedUids,String seq,String userid,String hmac,String timestamp) {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("armedUids", armedUids)
                .param("seq", seq)
                .param("userid", userid)
                .param("hmac", hmac)
                .param("timestamp", timestamp)
                .when()
                .put(EndPoints.Camera)
                .then()
                .extract().response();
        return response;
    }
    public Response putUpdateInvitation(String userid,String seq,String timestamp,String hmac,String shareId,String uid,String shareRight) {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("userid", userid)
                .param("seq", seq)
                .param("timestamp", timestamp)
                .param("hmac", hmac)
                .param("shareId", shareId)
                .param("uid", uid)
                .param("shareRight", shareRight)
                .when()
                .put(EndPoints.Camera)
                .then()
                .extract().response();
        return response;
    }
}
