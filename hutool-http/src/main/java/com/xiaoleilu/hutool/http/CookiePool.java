package com.xiaoleilu.hutool.http;

/**
 * Created by imkgo on 2017/9/6.
 */
public interface CookiePool {

    /**
     * 获得某个网站的Cookie信息
     * @param host 网站Host
     * @return Cookie字符串
     */
    String get(String host);

    /**
     * 将某个网站的Cookie放入Cookie池
     * @param host 网站Host
     * @param cookie Cookie字符串
     */
    void put(String host, String cookie);

    /**
     * 清空Cookie
     * @since 3.0.7
     */
    void clear();
}
