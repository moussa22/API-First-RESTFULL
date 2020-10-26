package com.isaccof;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String []  args){

        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        String password="123456789";

      String passwordencod=  bCryptPasswordEncoder.encode(password);

        System.out.println(passwordencod);

    }


}
