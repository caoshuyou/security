package com.weya.core.properties;

public class BrowserProperties {
    private String loginPage = "/sign.html";
    private LoginType loginType = LoginType.JSON;


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

}
