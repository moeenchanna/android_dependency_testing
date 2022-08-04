package com.paysyslabs.dependenytesting.depencyfiles.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthRequest {

    public AuthRequest(String xAuthToken, String xAuthUserName) {
        this.xAuthToken = xAuthToken;
        this.xAuthUserName = xAuthUserName;
    }

    @SerializedName("xAuthToken")
    @Expose
    private String xAuthToken;
    @SerializedName("xAuthUserName")
    @Expose
    private String xAuthUserName;

    public String getxAuthToken() {
        return xAuthToken;
    }

    public void setxAuthToken(String xAuthToken) {
        this.xAuthToken = xAuthToken;
    }

    public String getxAuthUserName() {
        return xAuthUserName;
    }

    public void setxAuthUserName(String xAuthUserName) {
        this.xAuthUserName = xAuthUserName;
    }
}
