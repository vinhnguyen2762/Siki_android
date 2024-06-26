package com.example.siki.dto.auth;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginDto implements Serializable {

    @SerializedName("access_token")
    private String access_token;

    private int expires_in;

    private int refresh_expires_in;

    private String refresh_token;
    private String token_type;

    private String session_state;
    private String scope;

    @SerializedName("not-before-policy")
    private String notBeforePolicy;

    public LoginDto(String access_token, int expires_in, int refresh_expires_in, String refresh_token, String token_type, String session_state, String scope, String notBeforePolicy) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.refresh_expires_in = refresh_expires_in;
        this.refresh_token = refresh_token;
        this.token_type = token_type;
        this.session_state = session_state;
        this.scope = scope;
        this.notBeforePolicy = notBeforePolicy;
    }

    public String getNotBeforePolicy() {
        return notBeforePolicy;
    }

    public void setNotBeforePolicy(String notBeforePolicy) {
        this.notBeforePolicy = notBeforePolicy;
    }

    public LoginDto() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public int getRefresh_expires_in() {
        return refresh_expires_in;
    }

    public void setRefresh_expires_in(int refresh_expires_in) {
        this.refresh_expires_in = refresh_expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getSession_state() {
        return session_state;
    }

    public void setSession_state(String session_state) {
        this.session_state = session_state;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
