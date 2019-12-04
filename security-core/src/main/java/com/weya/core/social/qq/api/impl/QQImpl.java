package com.weya.core.social.qq.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weya.core.social.qq.api.QQ;
import com.weya.core.social.qq.api.QQUserInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    Logger logger = LoggerFactory.getLogger(QQImpl.class);

    //GET_OPENID的网址 http://wiki.connect.qq.com/openapi%E8%B0%83%E7%94%A8%E8%AF%B4%E6%98%8E_oauth2-0
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    //http://wiki.connect.qq.com/get_user_info(access_token由父类提供)
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
    /**
     * appId 配置文件读取
     */
    private String appId;
    /**
     * openId 请求QQ_URL_GET_OPENID返回
     */
    private String openId;
    /**
     * 工具类
     */
    private ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 构造方法获取openId
     */
    public QQImpl(String accessToken, String appId) {
        //access_token作为查询参数来携带。
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);

        this.appId = appId;

        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);

        logger.info("【QQImpl】 QQ_URL_GET_OPENID={} result={}", URL_GET_OPENID, result);

        this.openId = StringUtils.substringBetween(result, "\"openid\":", "}");
    }

    /* (non-Javadoc)
     * @see com.imooc.security.core.social.qq.api.QQ#getUserInfo()
     */
    @Override
    public QQUserInfo getUserInfo() {

        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);

        logger.info("【QQImpl】 QQ_URL_GET_USER_INFO={} result={}", URL_GET_USERINFO, result);


        try {
            return objectMapper.readValue(result, QQUserInfo.class);
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
    }

}
