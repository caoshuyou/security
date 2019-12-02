package com.weya.core.validate.code.image;

import com.weya.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ImageCode extends ValidateCode {
    private BufferedImage image; // 图片

    public ImageCode(BufferedImage image, String code, int expireIn){
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
        super(code, expireTime);
        this.image = image;
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


}
