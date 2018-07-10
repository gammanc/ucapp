package com.team.ucapp.data.network;

import com.team.ucapp.data.database.Event;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Defines the operations NetworkUtils can perform
 */

public interface DataService {
    @FormUrlEncoded
    @POST("/login")
    Call<String> login(@Field("carnet") String user, @Field("password")String password);

    @GET("/events")
    Call<ArrayList<Event>> getEvents();
}
