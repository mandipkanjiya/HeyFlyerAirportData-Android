package com.heyflyer.heyflyersdk.rest_api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import java.util.HashMap;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import static com.heyflyer.heyflyersdk.rest_api.NetworkConstants.SERVICE.METHOD_GET_AIRPORTDATA;
import static com.heyflyer.heyflyersdk.rest_api.NetworkConstants.SERVICE.METHOD_GET_ARRIVAL_AIRPORTDATA;
import static com.heyflyer.heyflyersdk.rest_api.NetworkConstants.SERVICE.METHOD_GET_DEPARTURE_AIRPORTDATA;
import static com.heyflyer.heyflyersdk.rest_api.NetworkConstants.SERVICE.METHOD_INSERT_USER;

public interface ApiInterface {



    @FormUrlEncoded
    @POST(METHOD_GET_AIRPORTDATA)
    Call<JsonObject> getAirportData(@FieldMap HashMap<String, String> map);


    @FormUrlEncoded
    @POST(METHOD_GET_DEPARTURE_AIRPORTDATA)
    Call<JsonObject> getDepartureTimeTableAirportDataUsingCode(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST(METHOD_GET_ARRIVAL_AIRPORTDATA)
    Call<JsonObject> getArrivalTimeTableAirportDataUsingCode(@FieldMap HashMap<String, String> map);


    @FormUrlEncoded
    @POST(METHOD_INSERT_USER)
    Call<JsonObject> insertUser(@FieldMap HashMap<String, String> map);


}
