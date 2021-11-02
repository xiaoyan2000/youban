package com.example.youban.Initial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youban.PermisionUtils;
import com.example.youban.R;

import java.util.Locale;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        PermisionUtils.verifyStoragePermissions(this);
        TextView btn1 = findViewById(R.id.user_login);
        TextView btn2 = findViewById(R.id.user_forget);
        TextView btn3 = findViewById(R.id.user_register);
        startActivity(new Intent(LoginActivity.this,BottomMenuActivity.class));
        btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, BottomMenuActivity.class);
                    EditText name = findViewById(R.id.user_number_name);
                    EditText password = findViewById(R.id.user_password);
                    String temname = name.getText().toString();
                    String tempass = password.getText().toString();

                    if(temname.equals("user")&&tempass.equals("123456")) {
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "您输入的账号或密码错误，请重新输入！", Toast.LENGTH_LONG).show();
                    }
                }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Regester.class);
                startActivity(intent);
            }
        });
    }
}
