package com.grandra.guarantee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecomApiService {
    @GET("B551408/jnse-rcmd-info/jnse-rcmd-list")
    Call<GuaranteeRecommodel> getData(
            @Query("serviceKey") String serviceKey,
            @Query("dataType") String dataType,
            @Query("numOfRows") int numOfRows,
            @Query("pageNo") int pageNo,
            @Query("rentGrntAmt") String rentGrntAmt,
            @Query("trgtLwdgCd") String trgtLwdgCd,
            @Query("age") String age,
            @Query("weddStcd") String weddStcd,
            @Query("myIncmAmt") String myIncmAmt,
            @Query("myTotDebtAmt") String myTotDebtAmt,
            @Query("ownHsCnt") String ownHsCnt,
            @Query("grntPrmeActnDvcdCont") String grntPrmeActnDvcdCont
    );
}
