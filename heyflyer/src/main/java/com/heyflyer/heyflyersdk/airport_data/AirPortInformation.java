package com.heyflyer.heyflyersdk.airport_data;

import android.content.Context;

import android.util.Log;
import android.view.View;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.heyflyer.heyflyersdk.handler_interface.ApiHandler;
import com.heyflyer.heyflyersdk.handler_interface.OnJsonObjectResponse;
import com.heyflyer.heyflyersdk.handler_interface.OnJsonResponse;
import com.heyflyer.heyflyersdk.handler_interface.OnSuccessJsonObjectResponse;
import com.heyflyer.heyflyersdk.handler_interface.OnSuccessStringResponse;
import com.heyflyer.heyflyersdk.rest_api.ApiClient;
import com.heyflyer.heyflyersdk.rest_api.ApiErrorUtils;
import com.heyflyer.heyflyersdk.utils.ViewUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import retrofit2.Call;

import static com.heyflyer.heyflyersdk.utils.ViewUtils.showToast;

public class AirPortInformation {
    //Airport Information
    public static JSONObject jsonObject=null;

    public static JSONArray jsonArray=null;
    public static String responseString="";
    public static void getAirportInformationJson(final Context context, String nApiUserId, String cApiKey, String cAirportCode, final OnSuccessJsonObjectResponse onSuccessJsonObjectResponse) {
        ViewUtils.showDialog(context, false);
        HashMap<String, String> params = new HashMap<>();

        params.put("nApiUserId", nApiUserId);
        params.put("cApiKey", cApiKey);
        params.put("cAirportCode", cAirportCode);


        ApiHandler apiHandler = new ApiHandler();
        Call<JsonObject> listCall = ApiClient.getApiInterface().getAirportData(params);
        apiHandler.requestJsonObject(listCall, new OnJsonObjectResponse() {
            @Override
            public void getJsonObjectResponse(boolean isSuccess, JsonObject mJsonArray, String errorMsgSystem) {
                ViewUtils.showDialog(context, true);
                if (isSuccess) {

                    try {
                        jsonObject= new JSONObject(mJsonArray.toString());
                     //   Log.e("airportInfoJson",jsonObject.toString());
                        onSuccessJsonObjectResponse.getSuccessJsonObjectResponse(isSuccess,jsonObject,errorMsgSystem);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    showToast(context, errorMsgSystem, 0);
                }
            }
        });
        //return mJsonArray1;
        //return jsonObject;

    }

    public static void getAirportInformationString(final Context mcontext, String nApiUserId, String cApiKey, String cAirportCode, final OnSuccessStringResponse onSuccessStringResponse) {
        // final JsonArray mJsonArray1 =;
        HashMap<String, String> params = new HashMap<>();

        params.put("nApiUserId", nApiUserId);
        params.put("cApiKey", cApiKey);
        params.put("cAirportCode", cAirportCode);

        ApiHandler apiHandler = new ApiHandler();
        Call<JsonObject> listCall = ApiClient.getApiInterface().getAirportData(params);
        apiHandler.requestJsonObject(listCall, new OnJsonObjectResponse() {

            @Override
            public void getJsonObjectResponse(boolean isSuccess, JsonObject jsonObject, String errorMsgSystem) {
                if (isSuccess) {
                    responseString= jsonObject.toString();
                    onSuccessStringResponse.getSuccessStringResponse(isSuccess,responseString,errorMsgSystem);
                } else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    //showToast(mActivity, errorMsgSystem, 0);
                    showToast(mcontext, errorMsgSystem, 0);
                }
            }
        });
        //return mJsonArray1;


    }

    public static void getDepartureTimeTableAirportDataUsingCodeJson(Context context, String nApiUserId, String cApiKey, String cAirportCode,final OnSuccessJsonObjectResponse onSuccessJsonObjectResponse) {
        // final JsonArray mJsonArray1 =;
        HashMap<String, String> params = new HashMap<>();

        params.put("nApiUserId", nApiUserId);
        params.put("cApiKey", cApiKey);
        params.put("cAirportCode", cAirportCode);

        ApiHandler apiHandler = new ApiHandler();
        Call<JsonObject> listCall = ApiClient.getApiInterface().getDepartureTimeTableAirportDataUsingCode(params);
        apiHandler.requestJsonObject(listCall, new OnJsonObjectResponse() {
            @Override
            public void getJsonObjectResponse(boolean isSuccess, JsonObject mJsonArray, String errorMsgSystem) {
                try {
                    jsonObject= new JSONObject(mJsonArray.toString());
                    onSuccessJsonObjectResponse.getSuccessJsonObjectResponse(isSuccess,jsonObject,errorMsgSystem);
                  //  Log.e("airportInfoJson",mJsonArray.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        //return mJsonArray1;


    }

    public static void getDepartureTimeTableAirportDataUsingCodeString(Context mcontext, String nApiUserId, String cApiKey, String cAirportCode,final OnSuccessStringResponse onSuccessStringResponse) {
        // final JsonArray mJsonArray1 =;
        HashMap<String, String> params = new HashMap<>();

        params.put("nApiUserId", nApiUserId);
        params.put("cApiKey", cApiKey);
        params.put("cAirportCode", cAirportCode);


        ApiHandler apiHandler = new ApiHandler();
        Call<JsonObject> listCall = ApiClient.getApiInterface().getDepartureTimeTableAirportDataUsingCode(params);
        apiHandler.requestJsonObject(listCall, new OnJsonObjectResponse() {
            @Override
            public void getJsonObjectResponse(boolean isSuccess, JsonObject jsonObject, String errorMsgSystem) {
                if (isSuccess) {
                    responseString= jsonObject.toString();
                    onSuccessStringResponse.getSuccessStringResponse(isSuccess,responseString,errorMsgSystem);
                } else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    //showToast(mActivity, errorMsgSystem, 0);
                }
            }
        });
        //return mJsonArray1;


    }


    public static void getArrivalTimeTableAirportDataUsingCodeJson(Context context, String nApiUserId, String cApiKey, String cAirportCode,final OnSuccessJsonObjectResponse onSuccessJsonObjectResponse) {
        // final JsonArray mJsonArray1 =;
        HashMap<String, String> params = new HashMap<>();

        params.put("nApiUserId", nApiUserId);
        params.put("cApiKey", cApiKey);
        params.put("cAirportCode", cAirportCode);


        ApiHandler apiHandler = new ApiHandler();
        Call<JsonObject> listCall = ApiClient.getApiInterface().getArrivalTimeTableAirportDataUsingCode(params);
        apiHandler.requestJsonObject(listCall, new OnJsonObjectResponse() {
            @Override
            public void getJsonObjectResponse(boolean isSuccess, JsonObject mJsonArray, String errorMsgSystem) {
                try {
                    jsonObject= new JSONObject(mJsonArray.toString());
                    onSuccessJsonObjectResponse.getSuccessJsonObjectResponse(isSuccess,jsonObject,errorMsgSystem);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        //return mJsonArray1;


    }

    public static void getArrivalTimeTableAirportDataUsingCodeString(Context mcontext, String nApiUserId, String cApiKey, String cAirportCode,final OnSuccessStringResponse onSuccessStringResponse) {
        // final JsonArray mJsonArray1 =;
        HashMap<String, String> params = new HashMap<>();

        params.put("nApiUserId", nApiUserId);
        params.put("cApiKey", cApiKey);
        params.put("cAirportCode", cAirportCode);

        ApiHandler apiHandler = new ApiHandler();
        Call<JsonObject> listCall = ApiClient.getApiInterface().getArrivalTimeTableAirportDataUsingCode(params);
        apiHandler.requestJsonObject(listCall, new OnJsonObjectResponse() {


            @Override
            public void getJsonObjectResponse(boolean isSuccess, JsonObject jsonObject, String errorMsgSystem) {
                if (isSuccess) {

                    responseString= jsonObject.toString();
                    onSuccessStringResponse.getSuccessStringResponse(isSuccess,responseString,errorMsgSystem);
                } else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    //showToast(mActivity, errorMsgSystem, 0);
                }
            }
        });
        //return mJsonArray1;


    }

    public static void insertUserJson(Context context, String cBusinessName, String cCpName, String cCpMobile, String cCpEmail, String cEmail, String cPassword,final OnSuccessJsonObjectResponse onSuccessJsonObjectResponse) {
        // final JsonArray mJsonArray1 =;
        HashMap<String, String> params = new HashMap<>();

        params.put("cBusinessName", cBusinessName);
        params.put("cCpName", cCpName);
        params.put("cCpMobile", cCpMobile);
        params.put("cCpEmail", cCpEmail);
        params.put("cEmail", cEmail);
        params.put("cPassword", cPassword);


        ApiHandler apiHandler = new ApiHandler();
        Call<JsonObject> listCall = ApiClient.getApiInterface().insertUser(params);
        apiHandler.requestJsonObject(listCall, new OnJsonObjectResponse() {

            @Override
            public void getJsonObjectResponse(boolean isSuccess, JsonObject mJsonArray, String errorMsgSystem) {
                try {
                    jsonObject= new JSONObject(mJsonArray.toString());
                    onSuccessJsonObjectResponse.getSuccessJsonObjectResponse(isSuccess,jsonObject,errorMsgSystem);

                   // Log.e("airportInfoJson",mJsonArray.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        //return mJsonArray1;


    }

    public static void insertUserString(Context mcontext, String cBusinessName, String cCpName, String cCpMobile, String cCpEmail, String cEmail, String cPassword,final OnSuccessStringResponse onSuccessStringResponse) {
        // final JsonArray mJsonArray1 =;
        HashMap<String, String> params = new HashMap<>();

        params.put("cBusinessName", cBusinessName);
        params.put("cCpName", cCpName);
        params.put("cCpMobile", cCpMobile);
        params.put("cCpEmail", cCpEmail);
        params.put("cEmail", cEmail);
        params.put("cPassword", cPassword);



        ApiHandler apiHandler = new ApiHandler();
        Call<JsonObject> listCall = ApiClient.getApiInterface().insertUser(params);
        apiHandler.requestJsonObject(listCall, new OnJsonObjectResponse() {
            @Override
            public void getJsonObjectResponse(boolean isSuccess, JsonObject mJsonArray, String errorMsgSystem) {
                if (isSuccess) {
                    responseString= mJsonArray.toString();
                    onSuccessStringResponse.getSuccessStringResponse(isSuccess,responseString,errorMsgSystem);
                } else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    //showToast(mActivity, errorMsgSystem, 0);
                }
            }
        });


    }

}
