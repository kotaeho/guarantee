package com.grandra.guarantee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CheckApiService {
    @GET("B551408/jnse-rcmd-info/jnse-max-rent-amt-list")
    Call<GuaranteeCheckmodel> getData(
            @Query("serviceKey") String serviceKey,
            @Query("dataType") String dataType,
            @Query("grntDvcd") String grntDvcd,
            @Query("pageNo") int pageNo,
            @Query("numOfRows") int numOfRows
    );
}

