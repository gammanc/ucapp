package com.team.ucapp.data.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.team.ucapp.R;
import com.team.ucapp.data.database.Event;
import com.team.ucapp.utils.AppExecutors;
import com.team.ucapp.utils.NetworkUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkDataSource {

    private static final String TAG = "NetworkDataSource";

    private static final Object LOCK = new Object();
    private static NetworkDataSource mInstance;

    private final Context context;
    private final AppExecutors executors;

    private final MutableLiveData<ArrayList<Event>> eventsArray;

    private NetworkDataSource(Context context, AppExecutors executors) {
        this.context = context;
        this.executors = executors;
        eventsArray = new MutableLiveData<>();
    }

    public static NetworkDataSource getInstance(Context context, AppExecutors executors){
        Log.d(TAG, "Providing NetworkDataSource");
        if(mInstance == null){
            synchronized (LOCK){
                mInstance = new NetworkDataSource(context.getApplicationContext(), executors);
            }
        }
        return mInstance;
    }

    public LiveData<ArrayList<Event>> getLatestsEvents(){
        return eventsArray;
    }

    /*private void startFetch*/

    public void fetchEvents(){
        executors.networkIO().execute(()->{
            Call<ArrayList<Event>> call = NetworkUtils.getClientInstance().getEvents();
            Log.d(TAG, "fetchEvents: Performing a fetch");
            call.enqueue(new Callback<ArrayList<Event>>() {
                @Override
                public void onResponse(@NonNull Call<ArrayList<Event>> call,
                                       @NonNull Response<ArrayList<Event>> response) {
                    if(response.isSuccessful()){
                        Log.d(TAG, "onResponse: data fetched");
                        eventsArray.postValue(response.body());
                    }
                }
                @Override
                public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                    Log.d(TAG, "onFailure: Events fetching failed alv!");
                    showError(t);
                }
            });
        });
    }

    private boolean checkConnection(){
        if (!NetworkUtils.checkConectivity(context)){
            Toast.makeText(context,
                    context.getResources().getText(R.string.e_connection),
                    Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }


    public void showError(Throwable t){
        Toast.makeText(context,
                context.getResources().getText(R.string.e_net_failure),
                Toast.LENGTH_LONG).show();
        Log.d(TAG, "getUserDet: onFailure: the response failed : +"+t.getMessage());
        t.printStackTrace();
    }
}
