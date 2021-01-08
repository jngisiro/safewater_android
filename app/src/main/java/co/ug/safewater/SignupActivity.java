package co.ug.safewater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    EditText editName;
    EditText editEmail;
    EditText editPassword;
    EditText editPasswordConfirm;
    Button btnRegister;
    TextView textHaveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editPasswordConfirm = findViewById(R.id.editPasswordConfirm);
        btnRegister = findViewById(R.id.btnLogin);
        textHaveAccount = findViewById(R.id.textHaveAccount);

        textHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editEmail.getText().toString()) ||
                        TextUtils.isEmpty(editName.getText().toString()) ||
                        TextUtils.isEmpty(editPassword.getText().toString()) ||
                        TextUtils.isEmpty(editPasswordConfirm.getText().toString())){

                    String message = "Please fill in all the fields";
                    Toast.makeText(SignupActivity.this, message, Toast.LENGTH_LONG).show();
                }
                else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setEmail(editEmail.getText().toString());
                    registerRequest.setName(editName.getText().toString());
                    registerRequest.setPassword(editPassword.getText().toString());
                    registerRequest.setPasswordConfirm(editPasswordConfirm.getText().toString());

                    // Register User
                    registerUser(registerRequest);
                }
            }
        });
    }

    public void registerUser(RegisterRequest registerRequest){
        Call<RegisterResponse> registerResponseCall = ApiService.getService().
                registerUser(registerRequest);

        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    String message = "Registration Successful...";
                    Toast.makeText(SignupActivity.this, message, Toast.LENGTH_LONG).show();

                }else{
                    String message = "Unable to register User. Try again later...";
                    Toast.makeText(SignupActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(SignupActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}