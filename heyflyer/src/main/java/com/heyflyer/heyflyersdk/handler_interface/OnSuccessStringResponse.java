package com.heyflyer.heyflyersdk.handler_interface;

import org.json.JSONObject;

public interface OnSuccessStringResponse {

    public void getSuccessStringResponse(boolean isSuccess, String jsonString, String errorMsgSystem);
}
