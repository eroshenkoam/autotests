package io.eroshenkoam.autotests.api.retrofit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class DefaultCookieJar implements CookieJar {

    private final Map<String, Cookie> cookieMap = new HashMap<>();

    @Override
    public void saveFromResponse(final HttpUrl httpUrl, final List<Cookie> list) {
        if (httpUrl.url().toString().contains("logout")) {
            cookieMap.clear();
        }
        list.stream()
                .map(cookie -> createCookie(httpUrl.host(), cookie.name(), cookie.value()))
                .collect(Collectors.toMap(Cookie::name, c -> c))
                .forEach(cookieMap::put);
    }

    @Override
    public List<Cookie> loadForRequest(final HttpUrl httpUrl) {
        return new ArrayList<>(cookieMap.values());
    }

    private Cookie createCookie(final String domain, final String name, final String value) {
        return new Cookie.Builder().domain(domain).name(name).value(value).build();
    }

}

