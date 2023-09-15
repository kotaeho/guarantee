package com.grandra.guarantee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IntereApiService {
    @GET("B551408/jnse-rcmd-info/jnse-grtd-loan-rat-list")
    Call<GuaranteeInterestmodel> getData(
            @Query("serviceKey") String serviceKey,
            @Query("dataType") String dataType,
            @Query("loanYm") String loanYm
    );
}

