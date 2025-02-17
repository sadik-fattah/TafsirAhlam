package com.guercifzone.tafsirahlam.API;

import com.guercifzone.tafsirahlam.DataBase.DataItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {
    @GET("data_endpoint")
    Call<List<DataItem>> getData();
    public class RetrofitClient{
        private static Retrofit retrofit;
        public static Retrofit getRetrofitInstance(){
            if(retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.mktbtk.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
            return retrofit;
        }
    }
}
