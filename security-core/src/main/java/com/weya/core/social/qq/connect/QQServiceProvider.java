package com.weya.core.social.qq.connect;

import com.weya.core.social.qq.api.QQ;
import com.weya.core.social.qq.api.impl.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {
    private String appId;

    /**
     * 获取code
     */
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    /**
     * 获取access_token 也就是令牌
     */
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));

    }


    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
