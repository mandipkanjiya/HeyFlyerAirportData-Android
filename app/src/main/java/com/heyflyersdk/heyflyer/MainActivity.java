package com.heyflyersdk.heyflyer;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.heyflyer.heyflyersdk.airport_data.AirPortInformation;
import com.heyflyer.heyflyersdk.handler_interface.OnSuccessJsonObjectResponse;
import com.heyflyer.heyflyersdk.handler_interface.OnSuccessStringResponse;
import com.heyflyer.heyflyersdk.rest_api.ApiErrorUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.heyflyer.heyflyersdk.utils.ViewUtils.showToast;

public class MainActivity extends AppCompatActivity {
TextView tvapiResponse;
String nApiUserId="1",cApiKey="z2I5xrtiU",cAirportCode="DXB";
String airportInfoStr;
JSONObject airportInfoJson;
String cBusinessName="i can infotech",cCpName="aadil mansuri",cCpMobile="8595869586",cCpEmail="ican.aadil123@gmail.com",cEmail="ican.aadil123@gmail.com",cPassword="123456";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvapiResponse = findViewById(R.id.tvapiResponse);

      AirPortInformation.getAirportInformationJson(MainActivity.this,nApiUserId,cApiKey,cAirportCode, new OnSuccessJsonObjectResponse() {
           @Override
           public void getSuccessJsonObjectResponse(boolean isSuccess, JSONObject jsonObject, String errorMsgSystem) {
               if(isSuccess)
               {
                   airportInfoJson = jsonObject;
                   Log.e("airportInfoJson",airportInfoJson.toString());
               }
               else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                       showToast(MainActivity.this, errorMsgSystem, 0);
               }
           }
       });


        AirPortInformation.getAirportInformationString(MainActivity.this,nApiUserId,cApiKey,cAirportCode, new OnSuccessStringResponse() {
            @Override
            public void getSuccessStringResponse(boolean isSuccess, String stringJson, String errorMsgSystem) {
                if(isSuccess)
                {
                    airportInfoStr = stringJson;
                    Log.e("airportInfoStr",airportInfoStr.toString());
                }
                else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    showToast(MainActivity.this, errorMsgSystem, 0);
                }
            }
        });


       /* AirPortInformation.getDepartureTimeTableAirportDataUsingCodeJson(MainActivity.this,nApiUserId,cApiKey,cAirportCode, new OnSuccessJsonObjectResponse() {
            @Override
            public void getSuccessJsonObjectResponse(boolean isSuccess, JSONObject jsonObject, String errorMsgSystem) {
                if(isSuccess)
                {
                    airportInfoJson = jsonObject;
                    tvapiResponse.setText(airportInfoJson.toString());
                    Log.e("DeparturairportInfoJson",airportInfoJson.toString());
                }
                else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    showToast(MainActivity.this, errorMsgSystem, 0);
                }
            }
        });
        AirPortInformation.getDepartureTimeTableAirportDataUsingCodeString(MainActivity.this,nApiUserId,cApiKey,cAirportCode, new OnSuccessStringResponse() {
            @Override
            public void getSuccessStringResponse(boolean isSuccess, String stringJson, String errorMsgSystem) {
                if(isSuccess)
                {
                    airportInfoStr = stringJson;
                    Log.e("DeparturairportInfoStr",airportInfoStr.toString());
                }
                else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    showToast(MainActivity.this, errorMsgSystem, 0);
                }
            }
        });

        AirPortInformation.getArrivalTimeTableAirportDataUsingCodeJson(MainActivity.this,nApiUserId,cApiKey,cAirportCode, new OnSuccessJsonObjectResponse() {
            @Override
            public void getSuccessJsonObjectResponse(boolean isSuccess, JSONObject jsonObject, String errorMsgSystem) {
                if(isSuccess)
                {
                    airportInfoJson = jsonObject;
                    Log.e("arrivalairportInfoJson",airportInfoJson.toString());
                }
                else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    showToast(MainActivity.this, errorMsgSystem, 0);
                }
            }
        });
        AirPortInformation.getArrivalTimeTableAirportDataUsingCodeString(MainActivity.this,nApiUserId,cApiKey,cAirportCode, new OnSuccessStringResponse() {
            @Override
            public void getSuccessStringResponse(boolean isSuccess, String stringJson, String errorMsgSystem) {
                if(isSuccess)
                {
                    airportInfoStr = stringJson;
                    Log.e("arrivalairportInfoStr",airportInfoStr.toString());
                }
                else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    showToast(MainActivity.this, errorMsgSystem, 0);
                }
            }
        });

        AirPortInformation.insertUserJson(MainActivity.this,cBusinessName,cCpName,cCpMobile,cCpEmail,cEmail,cPassword, new OnSuccessJsonObjectResponse() {
            @Override
            public void getSuccessJsonObjectResponse(boolean isSuccess, JSONObject jsonObject, String errorMsgSystem) {
                if(isSuccess)
                {
                    airportInfoJson = jsonObject;
                    Log.e("airportInfoJson",airportInfoJson.toString());
                }
                else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    showToast(MainActivity.this, errorMsgSystem, 0);
                }
            }
        });

        AirPortInformation.insertUserString(MainActivity.this,cBusinessName,cCpName,cCpMobile,cCpEmail,cEmail,cPassword, new OnSuccessStringResponse() {
            @Override
            public void getSuccessStringResponse(boolean isSuccess, String stringJson, String errorMsgSystem) {
                if(isSuccess)
                {
                    airportInfoStr = stringJson;
                    Log.e("airportInfoStr",airportInfoStr.toString());
                }
                else if (errorMsgSystem.equals(ApiErrorUtils.SOMETHING_WENT_WRONG) || errorMsgSystem.equals(ApiErrorUtils.ERROR_NETWORK)) {
                    showToast(MainActivity.this, errorMsgSystem, 0);
                }
            }
        });*/
       // airportInfoStr= AirPortInformation.getAirportInformationString(MainActivity.this,nApiUserId,cApiKey,cAirportCode);
        //airportInfoStr= AirPortInformation.insertUserString(MainActivity.this,cBusinessName,cCpName,cCpMobile,cCpEmail,cEmail,cPassword);

        //Log.e("airportInfoJson",airportInfoJson.toString());
        //Log.e("airportInfoStr",airportInfoStr);
    }
}
