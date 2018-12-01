package com.cute.play.drama.utils;

import com.github.vioao.wechat.api.TokenApi;
import com.github.vioao.wechat.bean.response.token.TokenResponse;
import java.util.concurrent.TimeUnit;
import org.springframework.util.StringUtils;

/**
 * @author hanyuting
 * @since 2018/11/30
 */
public class WechatTokenUtil {
    private static String token = "";
    private static long expiredMills = System.currentTimeMillis();

    public static String getToken(String appId,String appSecret){
        long current = System.currentTimeMillis();
        if(StringUtils.isEmpty(token)||System.currentTimeMillis()-TimeUnit.MINUTES.toMillis(5) <expiredMills){
            TokenResponse tokenResponse = TokenApi.token(appId,appSecret);
            token = tokenResponse.getAccessToken();
            expiredMills = current+TimeUnit.SECONDS.toMillis(tokenResponse.getExpiresIn());
        }
        return token;
    }
}
