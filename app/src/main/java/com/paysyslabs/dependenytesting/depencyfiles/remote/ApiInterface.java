package com.paysyslabs.dependenytesting.depencyfiles.remote;

import com.paysyslabs.dependenytesting.depencyfiles.request.AuthRequest;
import com.paysyslabs.dependenytesting.depencyfiles.response.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("authenticate")
    Call<AuthResponse> callAuth(
            @Body AuthRequest body
    );
}
