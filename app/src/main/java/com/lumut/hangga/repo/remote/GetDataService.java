package com.lumut.hangga.repo.remote;

import com.lumut.hangga.repo.remote.response.ItemResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService  {
    @GET("todos")
    Observable<List<ItemResponse>> getItems();

    @GET("todos")
    Observable<ItemResponse> getDetil(@Query("id") int id);
}
