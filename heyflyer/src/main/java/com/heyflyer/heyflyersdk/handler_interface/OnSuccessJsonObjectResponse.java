package com.heyflyer.heyflyersdk.handler_interface;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public interface OnSuccessJsonObjectResponse {
    public void getSuccessJsonObjectResponse(boolean isSuccess, JSONObject jsonObject, String errorMsgSystem);
}
