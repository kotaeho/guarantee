package com.grandra.guarantee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class guarantee_recommend extends AppCompatActivity {


    private String money;
    private String age;
    private String marry;
    private String income;  //소득
    private String debt; // 빚

    private String home;

    private String prefer; // 우대사항

    private EditText edit_money;
    private EditText edit_age;
    private EditText edit_marry;
    private EditText edit_income;
    private EditText edit_debt;
    private EditText edit_home;
    private EditText edit_prefer;

    private Button search_btn;

    private Button edit_location_btn;

    private boolean edit_location;
    private String location_code;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guarantee_recommend);

        this.Init();
        this.search();
        this.location_popup();
    }

    private void Init(){
        edit_money = findViewById(R.id.edit_money);
        edit_age = findViewById(R.id.edit_age);
        edit_marry = findViewById(R.id.edit_marry);
        edit_income = findViewById(R.id.edit_income);
        edit_debt = findViewById(R.id.edit_debt);
        edit_home = findViewById(R.id.edit_home);
        edit_prefer = findViewById(R.id.edit_prefer);
        search_btn = findViewById(R.id.search_btn);
        edit_location_btn = findViewById(R.id.edit_location_btn);
    }

    private void search(){
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money = edit_money.getText().toString();
                age = edit_age.getText().toString();
                marry = edit_marry.getText().toString();
                income = edit_income.getText().toString();
                debt = edit_debt.getText().toString();
                home = edit_home.getText().toString();
                prefer = edit_prefer.getText().toString();

                if (!TextUtils.isDigitsOnly(money)) {
                    showToast("보증금액을 숫자로 입력하세요.");
                    return;
                }

                if (!TextUtils.isDigitsOnly(age)) {
                    showToast("나이를 숫자로 입력하세요.");
                    return;
                }

                if (!TextUtils.isDigitsOnly(income)) {
                    showToast("소득을 숫자로 입력하세요.");
                    return;
                }

                if (!TextUtils.isDigitsOnly(debt)) {
                    showToast("부채를 숫자로 입력하세요.");
                    return;
                }

                if (!TextUtils.isDigitsOnly(home)) {
                    showToast("보유주택수를 숫자로 입력하세요.");
                    return;
                }

                if (!TextUtils.isDigitsOnly(marry)) {
                    showToast("결혼여부를 숫자로 입력하세요.");
                    return;
                }

                if (!TextUtils.isDigitsOnly(prefer)) {
                    showToast("선호지역코드를 숫자로 입력하세요.");
                    return;
                }

                if(location_code == null){
                    showToast("지역을 선택하세요.");
                    return;
                }

                fetchData();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    private void fetchData() {
        RecomApiService apiService = RecomApiClient.getApiService();
        Call<GuaranteeRecommodel> call = apiService.getData(
                "SEyTD6N9tYDcENXw1Yd08q3Snfv+dPJOGaXAv74WZInaJlTQ3ZAGiEbcb4PbpVOwH7y5WEuEoTHmP1GmlT6+6w==",
                "JSON",
                10,
                1,
                money,
                "2629000000",
                age,
                marry,
                income,
                debt,
                home,
                prefer
        );

        call.enqueue(new Callback<GuaranteeRecommodel>() {
            @Override
            public void onResponse(@NonNull Call<GuaranteeRecommodel> call, @NonNull Response<GuaranteeRecommodel> response) {
                if (response.isSuccessful()) {
                    GuaranteeRecommodel data = response.body();
                    // 데이터를 처리하거나 표시하는 로직을 추가하세요.

                    Log.v("태그","추천값:"+data.getBody().getItems().get(0).getGrntDvcd());
                } else {
                    // API 호출 실패 처리
                }
            }

            @Override
            public void onFailure(@NonNull Call<GuaranteeRecommodel> call, @NonNull Throwable t) {
                // 네트워크 오류 등의 실패 처리
                Log.v("태그","API 오류:"+t.getMessage());
            }
        });
    }

    private void location_popup(){
        edit_location_btn.setOnClickListener(new View.OnClickListener() {
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
                        edit_location_btn.setText("지역기관 : 서울");
                        location_code = "1100000000";
                        edit_location = true;
                    }
                });

                Busan_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 부산");
                        location_code = "2600000000";
                        edit_location = true;
                    }
                });

                Daegu_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 대구");
                        location_code = "2700000000";
                        edit_location = true;
                    }
                });

                Incheon_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 인천");
                        location_code = "2800000000";
                        edit_location = true;
                    }
                });

                Gwangju_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 광주");
                        location_code = "2900000000";
                        edit_location = true;
                    }
                });

                Daejeon_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 대전");
                        location_code = "3000000000";
                        edit_location = true;
                    }
                });

                Ulsan_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 울산");
                        location_code = "3100000000";
                        edit_location = true;
                    }
                });

                Saejong_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 세종");
                        location_code = "3611000000";
                        edit_location = true;
                    }
                });

                gyeonggi_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 경기");
                        location_code = "4100000000";
                        edit_location = true;
                    }
                });

                Gwangwon_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 강원");
                        location_code = "5100000000";
                        edit_location = true;
                    }
                });

                Chungbuk_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 충북");
                        location_code = "4300000000";
                        edit_location = true;
                    }
                });

                Chungnam_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 충남");
                        location_code = "4400000000";
                        edit_location = true;

                    }
                });

                jeonbuk_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 전북");
                        location_code = "4500000000";
                        edit_location = true;

                    }
                });

                Jeonnam_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 전남");
                        location_code = "4600000000";
                        edit_location = true;

                    }
                });

                Gyeongbuk_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 경북");
                        location_code = "4700000000";
                        edit_location = true;
                    }
                });

                Gyeongnam_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 경남");
                        location_code = "4800000000";
                        edit_location = true;
                    }
                });

                Jeju_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        popupWindow.dismiss();
                        edit_location_btn.setText("지역기관 : 제주");
                        location_code = "5000000000";
                        edit_location = true;
                    }
                });
            }
        });
    }
}