package com.example.alumno_fp.estech_revista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etEmail,etPass;
    private String PASS = "escuela_estech";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }
    private void initUI(){
        btnLogin = findViewById(R.id.button_login);
        etEmail = findViewById(R.id.edit_text_email);
        etPass = findViewById(R.id.edit_text_pass);
    }
    private void submitForm(){
        if (!validate()){
            Toast.makeText(getApplicationContext(),"¡No puedes dejar campos sin rellenar!", Toast.LENGTH_SHORT).show();
        }else{
            if (!validateEmail()){
                Toast.makeText(getApplicationContext(),"¡Email no válido!", Toast.LENGTH_SHORT).show();
            }else{
                if (!validatePass()){
                    Toast.makeText(getApplicationContext(),"¡Contraseña incorrecta!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,NavigationActivity.class);
                    startActivity(intent);
                }
            }
        }
    }
    private boolean validate(){
        String email = etEmail.getText().toString().trim();
        String pass = etPass.getText().toString().trim();
        boolean isValid = true;
        if (email.isEmpty() || pass.isEmpty()){
            isValid = false;
        }
        return isValid;
    }
    private boolean validateEmail(){
        String email = etEmail.getText().toString().trim();
        boolean isValid = true;
        if (!isValidEmail(email)){
            isValid = false;
        }
        return  isValid;
    }
    private boolean validatePass(){
        String pass = etPass.getText().toString().trim();
        boolean isValid = true;
        if (!pass.equals(PASS)){
            isValid = false;
        }
        return isValid;
    }
    private static boolean isValidEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
