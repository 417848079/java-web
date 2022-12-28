package com.xxq.web.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <p>
 *
 * <p>
 *
 * @ClassName: UrlDemo
 * @Author: xxq
 * @Create: 2022-12-28 14:19
 */
public class UrlDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String userName = "张三";

        //1.url编码
        String encode = URLEncoder.encode(userName, "utf-8");
        System.out.println(encode);
        //2.url解码
//        String decode = URLDecoder.decode(encode, "utf-8");
        String decode = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decode);

        //3.转换为字节数据
        byte[] bytes = decode.getBytes("ISO-8859-1");
//        for (byte b : bytes){
//            System.out.print(b+" ");
//        }
        //4.将字节数组转为字符串
        String s = new String(bytes, "utf-8");
        System.out.println(s);
    }
}