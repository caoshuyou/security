package com.weya.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ImageCode {
    private BufferedImage image; // 图片
    private String code; // 验证码
    private LocalDateTime expireTime; // 有效时间
    public ImageCode(BufferedImage image, String code, int expireIn){
        this.image = image;
        this.code = code;
        // 输入一个秒数，自动转为时间，如过期时间为60s，这里的expireIn就是60，转换为当前时间上加上这个秒数
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
