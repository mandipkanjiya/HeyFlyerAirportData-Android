package com.heyflyer.heyflyersdk.handler_interface;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public interface OnJsonResponse {
   public void getJsonResponse(boolean isSuccess, JsonArray mJsonArray, String errorMsgSystem);
    //public void getJsonObjectResponse(boolean isSuccess, JsonObject jsonObject, String errorMsgSystem);
}
