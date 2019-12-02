package com.weya.core.validate.code;

import com.weya.core.validate.code.image.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
