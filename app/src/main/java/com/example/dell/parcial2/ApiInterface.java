package com.example.dell.parcial2;


import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Dell on 21/12/2017.
 */

public interface ApiInterface {

    @GET("posts")
    Observable<Response<ResponseBody>> posts();

}
