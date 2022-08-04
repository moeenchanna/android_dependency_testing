package com.paysyslabs.dependenytesting.depencyfiles.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthResponse {



    @SerializedName("responseCode")
    @Expose
    private String responseCode;
    @SerializedName("responseDescription")
    @Expose
    private String responseDescription;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("expiry")
        @Expose
        private String expiry;
        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("user")
        @Expose
        private String user;

        public String getExpiry() {
            return expiry;
        }

        public void setExpiry(String expiry) {
            this.expiry = expiry;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

    }

}
