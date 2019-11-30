package com.weya.validator;

import com.weya.sercive.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
   @Autowired
   private HelloService helloService;
   public void initialize(MyConstraint constraint) {
      System.out.println("my validator init");
   }

   public boolean isValid(Object value, ConstraintValidatorContext context) {
      helloService.greeting("tom");
      System.out.println(value);
      return false;
   }

}
