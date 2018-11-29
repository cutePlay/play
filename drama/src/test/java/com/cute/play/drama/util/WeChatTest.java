package com.cute.play.drama.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.vioao.wechat.api.MenuApi;
import com.github.vioao.wechat.api.TokenApi;
import com.github.vioao.wechat.api.UserApi;
import com.github.vioao.wechat.bean.response.BaseResponse;
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
//    private static final String APP_ID = "wx93a610c9f8cc4282";
    private static final String APP_ID = "wx326db2ac7a11cbc2";
//    private static final String APP_SECRET = "4493415855caf1b70e2c45c4de784110";
    private static final String APP_SECRET = "db9bdbd82bc5c6dad12808efcbe6e3bc";
//    private static final String TOKEN = "16_DMVVOWaFvacbUhH5Mmk-d4nojWc-IlXp-kYug-b9blHzGqxMSTbADO0SwRL8xnhFds9On4PD7xzNyGqegRCtt0xLxnruZD-AJVA7_NZHwTK14kGHYKRddPqPm8iFJ0XXHEeKlrVuxQ7ZjMtdVAZaAGAINM";
    private static final String TOKEN = "16_5Kovw0oYSjwo7wf0nmTm87mjucHM0L-RdtnMaDfyEI_VAMrZrgz1RNp2_LdL6ZIfNp21Lf1AJ9J51909ruwvJy8dDiMYy5z9sNIaiZS2Xs0gXFHPBH4AVCeOHtZpHA49fVwylB-4aUMHcqrVSEYjAIAHTN";
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
}
