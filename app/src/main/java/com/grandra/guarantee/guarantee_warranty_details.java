package com.grandra.guarantee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class guarantee_warranty_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guarantee_warranty_details);

        this.fetchData();
    }

    private void fetchData() {
        DetailApiService apiService = DetailApiClient.getApiService();
        Call<GuaranteeDetailmodel> call = apiService.getData(
                "SEyTD6N9tYDcENXw1Yd08q3Snfv+dPJOGaXAv74WZInaJlTQ3ZAGiEbcb4PbpVOwH7y5WEuEoTHmP1GmlT6+6w==",
                "JSON",
                "2D"
        );

        call.enqueue(new Callback<GuaranteeDetailmodel>() {
            @Override
            public void onResponse(@NonNull Call<GuaranteeDetailmodel> call, @NonNull Response<GuaranteeDetailmodel> response) {
                if (response.isSuccessful()) {
                    GuaranteeDetailmodel data = response.body();
                    // 데이터를 처리하거나 표시하는 로직을 추가하세요.
                    Log.v("태그","값:"+data.getBody().getItem().getGrntDvcd());
                } else {
                    // API 호출 실패 처리
                }
            }

            @Override
            public void onFailure(@NonNull Call<GuaranteeDetailmodel> call, @NonNull Throwable t) {
                // 네트워크 오류 등의 실패 처리
                Log.v("태그","API 오류:"+t.getMessage());
            }
        });
    }
}