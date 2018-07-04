package cordova.plugin.GongAnAuth;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jungle.gtauthlibrary.AuthNewResult;
import com.jungle.gtauthlibrary.GetResultListener;
import com.jungle.gtauthlibrary.util.JSONUtils;
import com.jungle.gtauthlibrary.util.StringUtils;

import com.jungle.gtauthlibrary.AuthNewResult;
import com.jungle.gtauthlibrary.GetResultListener;
import com.jungle.gtauthlibrary.util.JSONUtils;
/**
 * This class echoes a string called from JavaScript.
 */
public class GongAnAuth extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        if (action.equals("StartAuth")) {
            String sfzh = args.getString(0);
            String xm = args.getString(1);
            String sjh = args.getString(2);
            String mm = args.getString(3);
            this.StartAuth(sfzh, xm, sjh, mm , callbackContext);
            return  true;
          }
        return false;
    }

    private void StartAuth( String sfzh,  String xm,  String sjh,  String mm, final CallbackContext callbackContext){
        AuthNewResult.getInstance().startAuth(cordova.getActivity(), sfzh, xm, sjh, mm, new GetResultListener() {
          @Override
          public void getResult(String result) {
            int state = 0; //(int) JSONUtils.get(result, "State", 1);
            if (state == 0) {// 0：成功，1：失败
              callbackContext.success(result);
  
            } else {
              callbackContext.error(result);
            }
          }
        });
  
      }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
