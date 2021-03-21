package com.dft.onyx50demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.dft.onyx50demo.databinding.ActivityLoginBinding;
import com.dft.onyx50demo.matching.SharedPreferencesAuthStore;
import com.dft.onyx50demo.networkUtils.ApiClient;
import com.dft.onyx50demo.networkUtils.OnyxApi;
import com.dft.onyx50demo.response.ValidationRequest;
import com.dft.onyx50demo.response.ValidationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {

    OnyxApi onyxApi;

    SharedPreferencesAuthStore authstore;

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onyxApi = ApiClient.INSTANCE.getOnyxApi();

        authstore = new SharedPreferencesAuthStore(this);


        binding.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableDisableFields(true);
                String voterId = binding.cnic.getText().toString();
                String expiry =  binding.expiryDate.getText().toString();
                onyxApi.validate(new ValidationRequest(voterId,expiry)).enqueue(
                        new Callback<ValidationResponse>() {
                            @Override
                            public void onResponse(Call<ValidationResponse> call, Response<ValidationResponse> response) {
                                try {
                                    Log.d("data", response.body().getData());
                                    if (response.body().getData() != null && response.body().getData().equals("validated")) {
                                        authstore.setVoterId(voterId);
                                     //  authstore.setVoterId("8881212");
                                        finish();
                                        startActivity(new Intent(LoginActivity.this, SelectHandActivity.class));
                                    } else {
                                        Toast.makeText(LoginActivity.this, response.body().getError(), Toast.LENGTH_SHORT).show();
                                    }
                                }catch (Exception e){
                                    Log.d("exception",e.toString());
                                    Toast.makeText(LoginActivity.this, response.body().getError(), Toast.LENGTH_SHORT).show();

//                                    authstore.setVoterId("8881212");
//                                    finish();
//                                    startActivity(new Intent(LoginActivity.this, SelectHandActivity.class));

                                    enableDisableFields(false);
                                }
                                }

                            @Override
                            public void onFailure(Call<ValidationResponse> call, Throwable t) {
                                Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_SHORT).show();
                                enableDisableFields(false);
                            }
                        }
                );

            }
        });
    }


    void enableDisableFields(Boolean disable) {
        binding.cnic.setEnabled(!disable);
        binding.expiryDate.setEnabled(!disable);
        binding.createButton.setEnabled(!disable);
        if (disable) {
            binding.pbar.setVisibility(View.VISIBLE);
            binding.createButton.setText("");
        } else {
            binding.pbar.setVisibility(View.GONE);
            binding.createButton.setText("Login");
        }
    }

}
