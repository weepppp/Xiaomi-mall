package com.tang.pay;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092000555789";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCbkBtue5AJ7I8ZFhMgnIj5nGxndyWSOP9e1PeDf0ovHMNgBSTUCuRJ+xUGVI8ulQjr3dNilSMLQiAU8Y6MDc20ilJ4fQDcGevdalrE6K2x7r3RUhdT2MAaqgeZKQ1Poqd/ir+BoQN4nHQwKDPoq7TLEDQZj3Cw7X0/mJscacoP1ddWGJHKxqMvILBq1G9WXkBGLVhkb5J4NEKzFxMM31OBNPXQVqXk1mm79kadIpm9H2bLsBaUIWjJfArs4NO4nFM5A5gIMYaMLgcdwWjKdKOOkg8KM27I3jh6G7+wX2nzXHY9rrL0hOSst0aBF1MUI8bFWqJMKoJegzBBURW6Hbh1AgMBAAECggEBAJcNjmVwnAPW7Xipg7c16JegOW8aNaRPrkDSQOkx78HhhyE0vXccgGIJ6Xd1IndUBg6qHjlqoVWsRuSvTgBW4vi9G6mdj/kpPmuIe00atpbBQRYBRV+IZ7k8gxZI04ERat2gx6ZCx9EU8olUcFssZ+iJ+l0beIyEfwsCzxL+8lL+gAcc7FUFtGA4fMYTebhrxzuScdRjFBgW6mrtIfs3rXtdW1s49P7V2xw52G2lbWBsHmvAxAvn/2w0xQobWni4i2HN5WY2DWBE18A+nEP5oo969xEFNfNcVXTqZD+L5bZBro7r9IO+DdKcJCIMzGg70CaJ8Ibc4EFo+62YrEjsaOECgYEA+OMDMiN6F8IKnphJast70v208zZ0A/bsLXtbW5wnpSUjW+kj0kg5Lsy+6ad7iXriBkPWkZpKyaePgtM7M3zdcwvUgVuIBZ5ozWrK8jPy2V+Hg0+pqsrDPew8IAmLyEpoOewcL2jd5nKMfsabAoGZAErsrE88waSO7sM3lXwdIc0CgYEAoAJJtW2gtFKHMwU92U9J2MukwdqbKfx33i2cEcZ4IDWPGR1EmTm2vTaJdlA8JR4e9ADtfEiwffWk30mFXE/U2x9YJg2iY5ChFp2g1/QtvjD3TGfS6qdR7E/6pO0DHqsb0y0F4OFO0I66E/bO2mHG0HYh/24rXaa7bd2uKiS6aUkCgYEAni8CV/qOXc05HKVjfBnKIEaZnD7Oq7pjT2Dopqfv1pltCLx7xOmcVm9RI4YMEUvlnd+93xq2T8ZMgvSn2siQos8xB+pZ4GBW8b/fLuLvhVKe+UlHZ8KpJpEfgakvi2QnLDExlLxM1GuXeffWi1g9Gx+DntxZnCVvprayfDK+/T0CgYEAhl0FelWhomq+32giZK5BK8zuAF9K9rnsCmUwbnjD/QActxEtvqGJQ2BdlD2SE/U0Nt/kjP4ZPtyc42fAliDvdEXg5quCVqtnqi8Zlt6T3ucNc1qn8aYplBAhQIdKnGFBT1a6Xfm1DkscFJGnaBi9M+ZPbEgeIFlXgM2rZ/ZJlwkCgYEAwqVfjdUhR+A0153AOLK1y4EFPLuIoJ68zh0kz1tDB5T4bNAO+TReUl+sdtMZRWa1m16e0gHpXnMlDkkvWEniaQVVaL6ZvUpCbwahTDnY7JYsxNUhoQrDW2FODvB6Zhl4pr+cszbCCEKIVWnxurIFUGIe6zcplCMgVl1k8KN6ypY=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvJIG5ElJK5fjagIrBCgx10amhraQYInip5oe+hL73jPtnrvGTwpuW77rooiHsCg2rjMg4QvomA23B2QV/m5Wg0FOE9tFfMPPWLSst1jf3M/lhBgXsTxGw5DUoCDnvDoN8d80lC2H2ChpFGCOi9IGilAsLyG6QMrmmzcIfSQ/NXQxGht3HkaVa1pPYYEh2jDVtYesA85ysFIEayRS3Psc+xof91VOUuA3hF7NrupGXR1BKcRpZcVSDIKQo9EQf8uJaR5bLPzHD0OuKa+uBr/TYuWyDNTqTyXRF9o4Pi2YOkV5/QWnmEhKbJ19jK4V37UKNOiqztzchkUzv3uitli+NQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/pay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/pay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
