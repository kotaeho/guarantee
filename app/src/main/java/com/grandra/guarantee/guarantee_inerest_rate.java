package com.grandra.guarantee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class guarantee_inerest_rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guarantee_inerest_rate);

        this.fetchData();
    }

    private void fetchData() {
        IntereApiService apiService = IntereApiClient.getApiService();
        Call<GuaranteeInterestmodel> call = apiService.getData(
                "SEyTD6N9tYDcENXw1Yd08q3Snfv+dPJOGaXAv74WZInaJlTQ3ZAGiEbcb4PbpVOwH7y5WEuEoTHmP1GmlT6+6w==",
                "JSON",
                "202306"
        );

        call.enqueue(new Callback<GuaranteeInterestmodel>() {
            @Override
            public void onResponse(@NonNull Call<GuaranteeInterestmodel> call, @NonNull Response<GuaranteeInterestmodel> response) {
                if (response.isSuccessful()) {
                    GuaranteeInterestmodel data = response.body();
                    // 데이터를 처리하거나 표시하는 로직을 추가하세요.
                    Log.v("태그","값:"+data.getBody().getItems().get(0).getGrntDvcd());
                } else {
                    // API 호출 실패 처리
                }
            }

            @Override
            public void onFailure(@NonNull Call<GuaranteeInterestmodel> call, @NonNull Throwable t) {
                // 네트워크 오류 등의 실패 처리
                Log.v("태그","API 오류:"+t.getMessage());
            }
        });
    }
}