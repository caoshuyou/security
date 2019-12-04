package com.weya.core.social.qq.config;

import com.weya.core.properties.QQProperties;
import com.weya.core.properties.SecurityProperties;
import com.weya.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import java.util.logging.SocketHandler;
@Configuration
@ConditionalOnProperty(prefix = "imooc.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;
    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
    }
}
