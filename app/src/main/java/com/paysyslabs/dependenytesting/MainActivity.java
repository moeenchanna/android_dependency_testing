package com.paysyslabs.dependenytesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.paysyslabs.dependenytesting.depencyfiles.remote.ApiClient;
import com.paysyslabs.dependenytesting.depencyfiles.remote.ApiInterface;
import com.paysyslabs.dependenytesting.depencyfiles.request.AuthRequest;
import com.paysyslabs.dependenytesting.depencyfiles.response.AuthResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //TODO HIDE THIS LINES
    protected ApiInterface apiInterface;
    protected  ProgressDialog progress;
    //TODO HIDE THIS LINES
    Button auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO HIDE THIS LINES
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        progress = new ProgressDialog(this);
        //TODO HIDE THIS LINES

        auth =findViewById(R.id.auth);
        auth.setOnClickListener(view -> callAuthentication("String","03118135166"));
    }

    //TODO HIDE THIS LINES
    private void callAuthentication(String xAuthToken, String xAuthUserName) {

        progress.setMessage("Authentication please wait...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(false);
        progress.setCancelable(false);
        progress.show();
        Call<AuthResponse> call = apiInterface.callAuth(new AuthRequest(xAuthToken, xAuthUserName));
        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(@NonNull Call<AuthResponse> call, @NonNull Response<AuthResponse> response) {
                AuthResponse genericResponse = response.body();
                assert genericResponse != null;
                Log.i(TAG, "AuthResponse " + new Gson().toJson(response.body()));

                if (genericResponse.getResponseCode().equals("00")) {
                    if (!MainActivity.this.isFinishing() && progress != null) {
                        progress.dismiss();
                    }
                    toastShow(genericResponse.getResponseDescription());

                } else {
                    if (!MainActivity.this.isFinishing() && progress != null) {
                        progress.dismiss();
                        toastShow(genericResponse.getResponseDescription());
                    }

                }

            }


            @Override
            public void onFailure(@NonNull Call<AuthResponse> call, @NonNull Throwable t) {
                if (!MainActivity.this.isFinishing() && progress != null) {
                    progress.dismiss();
                    toastShow(t.getMessage());
                    Log.e(TAG, "onFailure on AuthResponse: ", t);
                }
            }
        });

    }


    protected void toastShow(final String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    //TODO HIDE THIS LINES
}