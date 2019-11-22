package com.heyflyer.heyflyersdk.handler_interface;

import com.google.gson.JsonObject;

public interface OnJsonObjectResponse {
    public void getJsonObjectResponse(boolean isSuccess, JsonObject jsonObject, String errorMsgSystem);
}
