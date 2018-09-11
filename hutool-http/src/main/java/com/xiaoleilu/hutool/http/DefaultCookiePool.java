
package com.xiaoleilu.hutool.http;

import com.xiaoleilu.hutool.util.StrUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *Cookie池。此池针对所有HTTP请求可用。<br>
 *此Cookie池用于模拟浏览器的Cookie，当访问后站点，记录Cookie，下次再访问这个站点时，一并提交Cookie到站点。
 * @author Looly
 *
 */
public class DefaultCookiePool implements CookiePool {

	private static DefaultCookiePool defaultCookiePool = new DefaultCookiePool();

	public static DefaultCookiePool getInstance() {
		return defaultCookiePool;
	}
	
	//key: host, value: cookies字符串
	private Map<String, String> cookies = new ConcurrentHashMap<String, String>();
	
	/**
	 * 获得某个网站的Cookie信息
	 * @param host 网站Host
	 * @return Cookie字符串
	 */
	public String get(String host) {
		String cookie = cookies.get(host);
		if (StrUtil.isEmpty(cookie) && host.contains(".")) {
			host = host.substring(host.indexOf(".") + 1, host.length());
		}
		cookie = cookies.get(host);
		return cookie;
	}
	
	/**
	 * 将某个网站的Cookie放入Cookie池
	 * @param host 网站Host
	 * @param cookie Cookie字符串
	 */
	public void put(String host, String cookie) {
		cookies.put(host, cookie);
	}
	
	/**
	 * 清空Cookie
	 * @since 3.0.7
	 */
	public void clear(){
		cookies.clear();
	}
}
