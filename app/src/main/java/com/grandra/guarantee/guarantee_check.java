package com.grandra.guarantee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class guarantee_check extends AppCompatActivity {
    private String grntDvcd;
    private Button location_btn;
    private Button seoul_btn;
    private Button Busan_btn;
    private Button Daegu_btn;
    private Button Incheon_btn;
    private Button Gwangju_btn;
    private Button Daejeon_btn;
    private Button Ulsan_btn;
    private Button Saejong_btn;
    private Button gyeonggi_btn;
    private Button Gwangwon_btn;
    private Button Chungbuk_btn;
    private Button Chungnam_btn;
    private Button jeonbuk_btn;
    private Button Jeonnam_btn;
    private Button Gyeongbuk_btn;
    private Button Gyeongnam_btn;
    private Button Jeju_btn;
    private TextView money;
    private ArrayList<String> moneys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guarantee_check);

        this.Init();
        this.fetchData();
        this.location_popup();
    }

    private void Init(){
        location_btn = findViewById(R.id.location_btn);
        money = findViewById(R.id.money);
    }

    private void fetchData() {
        CheckApiService apiService = CheckApiClient.getApiService();
        Call<GuaranteeCheckmodel> call = apiService.getData(
                "SEyTD6N9tYDcENXw1Yd08q3Snfv+dPJOGaXAv74WZInaJlTQ3ZAGiEbcb4PbpVOwH7y5WEuEoTHmP1GmlT6+6w==",
                "JSON",
                "2D",
                1,
                30
        );

        call.enqueue(new Callback<GuaranteeCheckmodel>() {
            @Override
            public void onResponse(@NonNull Call<GuaranteeCheckmodel> call, @NonNull Response<GuaranteeCheckmodel> response) {
                if (response.isSuccessful()) {
                    GuaranteeCheckmodel data = response.body();
                    // 데이터를 처리하거나 표시하는 로직을 추가하세요.

                    Log.v("태그","값:"+data.getBody().getItems().get(0).getMaxRentGrntAmt());

                    for(int i = 0; i < data.getBody().getItems().size(); i++){
                        moneys.add(data.getBody().getItems().get(i).getMaxRentGrntAmt());
                    }
                } else {
                    // API 호출 실패 처리
                }
            }

            @Override
            public void onFailure(@NonNull Call<GuaranteeCheckmodel> call, @NonNull Throwable t) {
                // 네트워크 오류 등의 실패 처리
                Log.v("태그","API 오류:"+t.getMessage());
            }
        });
    }

    private void location_popup(){
        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 팝업 레이아웃을 인플레이트
                View popupView = getLayoutInflater().inflate(R.layout.location_popup, null);

                // 팝업 창을 만들고 팝업 레이아웃을 설정
                PopupWindow popupWindow = new PopupWindow(popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE)); // 팝업 내부 배경 설정
                popupWindow.setElevation(50); // 그림자의 크기를 설정 (원하는 크기로 조정)

                // 팝업 레이아웃 안의 닫기 버튼을 찾아서 클릭 이벤트 처리
                Button closeButton = popupView.findViewById(R.id.close_button);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 팝업 창 닫기
                        popupWindow.dismiss();
                    }
                });

                // 팝업 창을 화면에 표시
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                seoul_btn = popupView.findViewById(R.id.Seoul);
                Busan_btn = popupView.findViewById(R.id.Busan);
                Daegu_btn = popupView.findViewById(R.id.Daegu);
                Incheon_btn = popupView.findViewById(R.id.incheon);
                Gwangju_btn = popupView.findViewById(R.id.Gangju);
                Daejeon_btn = popupView.findViewById(R.id.Daejeon);
                Ulsan_btn = popupView.findViewById(R.id.Ulsan);
                Saejong_btn = popupView.findViewById(R.id.saejong);
                gyeonggi_btn = popupView.findViewById(R.id.gyeonggi);
                Gwangwon_btn = popupView.findViewById(R.id.Gangwon);
                Chungbuk_btn = popupView.findViewById(R.id.Chungbuk);
                Chungnam_btn = popupView.findViewById(R.id.chungnam);
                jeonbuk_btn = popupView.findViewById(R.id.jeonbuk);
                Jeonnam_btn = popupView.findViewById(R.id.Jeonnam);
                Gyeongbuk_btn = popupView.findViewById(R.id.Gyeongbuk);
                Gyeongnam_btn = popupView.findViewById(R.id.Gyeongnam);
                Jeju_btn = popupView.findViewById(R.id.Jeju);

                seoul_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();

                        String moneyText = getString(R.string.money_placeholder, moneys.get(0));
                        money.setText(moneyText);
                        location_btn.setText("지역기관 : 서울");
                    }
                });

                Busan_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 부산");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(1));
                        money.setText(moneyText);
                    }
                });

                Daegu_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 대구");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(2));
                        money.setText(moneyText);
                    }
                });

                Incheon_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 인천");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(3));
                        money.setText(moneyText);
                    }
                });

                Gwangju_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 광주");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(4));
                        money.setText(moneyText);
                    }
                });

                Daejeon_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 대전");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(5));
                        money.setText(moneyText);
                    }
                });

                Ulsan_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 울산");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(6));
                        money.setText(moneyText);
                    }
                });

                Saejong_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 세종");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(7));
                        money.setText(moneyText);
                    }
                });

                gyeonggi_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 경기");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(8));
                        money.setText(moneyText);
                    }
                });

                Gwangwon_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 강원");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(16));
                        money.setText(moneyText);
                    }
                });

                Chungbuk_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 충북");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(9));
                        money.setText(moneyText);
                    }
                });

                Chungnam_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 충남");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(10));
                        money.setText(moneyText);
                    }
                });

                jeonbuk_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 전북");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(11));
                        money.setText(moneyText);
                    }
                });

                Jeonnam_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 전남");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(12));
                        money.setText(moneyText);
                    }
                });

                Gyeongbuk_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 경북");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(13));
                        money.setText(moneyText);
                    }
                });

                Gyeongnam_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 경남");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(14));
                        money.setText(moneyText);
                    }
                });

                Jeju_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        location_btn.setText("지역기관 : 제주");
                        String moneyText = getString(R.string.money_placeholder, moneys.get(15));
                        money.setText(moneyText);
                    }
                });
            }
        });
    }
}