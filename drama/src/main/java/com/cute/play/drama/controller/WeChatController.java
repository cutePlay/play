package com.cute.play.drama.controller;

import com.cute.play.drama.config.PlayConfig;
import com.cute.play.drama.config.WeChatConfig;
import com.cute.play.drama.utils.WechatTokenUtil;
import com.github.vioao.wechat.api.SnsApi;
import com.github.vioao.wechat.api.UserApi;
import com.github.vioao.wechat.bean.response.sns.SnsTokenResponse;
import com.github.vioao.wechat.bean.response.user.UserResponse;
import com.github.vioao.wechat.utils.StringUtils;
import com.github.vioao.wechat.utils.signature.SignatureUtil;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanyuting
 * @since 2018/11/29
 */
@Slf4j
@RestController
@RequestMapping("api/wx/authorize")
public class WeChatController {
    @Autowired
    private WeChatConfig weChatConfig;
    @Autowired
    private PlayConfig playConfig;
    @GetMapping("security")
    @ResponseBody
    public String authorize(String signature, String timestamp, String nonce, String echostr){
        if(SignatureUtil.check(signature,timestamp,nonce,weChatConfig.getToken())) {
            return echostr;
        }else{
            log.error("security failed,signature:{},timestamp:{},nonce:{},echostr:{}",signature,timestamp,nonce,echostr);
            return "";
        }
    }
    @GetMapping("callback")
    public void callback(String code,String state, HttpServletResponse response) throws IOException {
        log.info("code:{},state:{}",code,state);
        SnsTokenResponse sns = SnsApi.oauth2AccessToken(weChatConfig.getAppId(),weChatConfig.getAppSecret(),code);
        String openId = sns.getOpenid();
        UserResponse user = UserApi.getUserInfo(WechatTokenUtil.getToken(weChatConfig.getAppId(),weChatConfig.getAppSecret()),openId);
        log.info("UserInfo:{}",user);
        response.sendRedirect(String.format(playConfig.getFrontUrl(),user.getOpenid()));
    }

    @GetMapping("redirect")
    public void callback(HttpServletResponse response) throws IOException {
        if(StringUtils.isNotBlank(playConfig.getCallbackUrl())) {
            response.sendRedirect(SnsApi.getOath2Url(weChatConfig.getAppId(), playConfig.getCallbackUrl(), true, "200"));
        }else {
            response.sendRedirect(String.format(playConfig.getFrontUrl(), "123"));
        }
    }
}
