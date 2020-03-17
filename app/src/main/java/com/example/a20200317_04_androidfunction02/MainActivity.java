package com.example.a20200317_04_androidfunction02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.a20200317_04_androidfunction02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                다른 화면으로 이동 : Intent
//                => 우리가 만든게 아니라, 안드로이드가 제공하는 화면으로 이동.
//                => 전화걸기 화면!

//                어느 화면으로 갈지 => 안드로이드가 요구하는 양식으로 작성: Uri

//                응용문제 : EditText에 입력한폰번으로 전화 걸도록.
                String phoneNum = binding.inputPhoneNum.getText().toString();

                String phoneUriStr = String.format("tel:%s", phoneNum);

                Uri uri = Uri.parse(phoneUriStr);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);

            }
        });

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                현재까지 배운것만으론 실행불가 :

                Uri uri = Uri.parse("tel:01095253290");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        });
    }
}
