package com.cute.play.drama.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.vioao.wechat.api.MenuApi;
import com.github.vioao.wechat.api.SnsApi;
import com.github.vioao.wechat.api.TokenApi;
import com.github.vioao.wechat.api.UserApi;
import com.github.vioao.wechat.bean.entity.menu.Button;
import com.github.vioao.wechat.bean.entity.menu.MenuButtons;
import com.github.vioao.wechat.bean.response.BaseResponse;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hanyuting
 * @since 2018/11/29
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class WeChatTest {
    private static final String APP_ID = "wx93a610c9f8cc4282";
//    private static final String APP_ID = "wx326db2ac7a11cbc2";
    private static final String APP_SECRET = "4493415855caf1b70e2c45c4de784110";
//    private static final String APP_SECRET = "db9bdbd82bc5c6dad12808efcbe6e3bc";
    private static final String TOKEN = "16_ezYVmiwl4iN5A8IN0CTIXOGJQegFGvEu4Q893h0MgK0mpYAycnuQ9smcmpz-DwBAB3FmhT_Yl8xUy6kqJ6TmrGPAKL9lCrSIJ8UCa_OtgPhvT-HMtjwTAS4cx2ejVaOCBW_OoSH60uD_ujiwUVYhAAAABE";
//    private static final String TOKEN = "16_7UF3syy5zc1l2TVVXSuWws8Ow-6oOLH4D15IswmaI6w_MejOkpnisLtcdzk_JOs2lxwnGVvvZqfAoo9FaCIjaweOGP2Shvpu-F5Z3aO6DYSaMGoWtOoQr5otLA8de1aKeZXDWTJYVtG_l9LlMWIgAIAYIU";
    private static final String OPEN_ID = "o6GpB5oRrilrOYVDTp2eeGSKSC7I";
    private ObjectMapper json = null;
    private BaseResponse response = null;

    @Before
    public void init(){
        json = new ObjectMapper();
    }
    @After
    public void log() throws JsonProcessingException {
        System.out.println(json.writeValueAsString(response));
    }
    @Test
    public void testToken(){
        response = TokenApi.token(APP_ID,APP_SECRET);
    }

    @Test
    public void testUser() {
        response = UserApi.getUserInfo(TOKEN,OPEN_ID);
    }

    @Test
    public void testUsers() {
        response = UserApi.getUserOpenIds(TOKEN,null);
    }
    @Test
    public void testMenu(){
        response = MenuApi.getCurrentSelfMenuInfo(TOKEN);
    }

    @Test
    public void createMenu(){
        MenuButtons menuButtons = new MenuButtons();
        Button button = new Button();
        button.setAppid(APP_ID);
        button.setName("剧本测试");
        button.setType("view");
        String url = SnsApi.getOath2Url(APP_ID,
            "http://apiplay.janehyt.cn/api/wx/authorize/callback",
            true,
            "200");
        System.out.println(url);
        button.setUrl(url);
        menuButtons.setButton(Collections.singletonList(button));
        response = MenuApi.create(TOKEN,menuButtons);
//        response = MenuApi.getCurrentSelfMenuInfo(TOKEN);
    }

}
