package com.grandra.guarantee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DetailApiService {
    @GET("B551408/jnse-rcmd-info/jnse-prod-dtl-info")
    Call<GuaranteeDetailmodel> getData(
            @Query("serviceKey") String serviceKey,
            @Query("dataType") String dataType,
            @Query("grntDvcd") String grntDvcd
    );
}
