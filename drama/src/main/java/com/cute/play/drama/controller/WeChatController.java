package com.cute.play.drama.controller;

import com.cute.play.drama.config.WeChatConfig;
import com.github.vioao.wechat.utils.signature.SignatureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("security")
    public String authorize(String signature, String timestamp, String nonce, String echostr){
        if(SignatureUtil.check(signature,timestamp,nonce,weChatConfig.getToken())) {
            return echostr;
        }else{
            log.error("security failed,signature:{},timestamp:{},nonce:{},echostr:{}",signature,timestamp,nonce,echostr);
            return "";
        }
    }
}
