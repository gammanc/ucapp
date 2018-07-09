package com.team.ucapp.data.network;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MessageDeserializer implements JsonDeserializer<String> {
    private static final String TAG = "MessageDeserializer";
    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject logininfo = json.getAsJsonObject();
        if(logininfo != null){
            Log.d(TAG, "deserialize: login info correct");
            if(logininfo.has("api_key"))
                return "api_key:"+logininfo.get("api_key").getAsString();
            else
                return "message:"+logininfo.get("message").getAsString();

        } else
            return "message: Operation failed. Please try again later";

    }
}
