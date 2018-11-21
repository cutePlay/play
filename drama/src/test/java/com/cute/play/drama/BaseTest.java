package com.cute.play.drama;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest {

    protected ObjectMapper json;

    @Before
    public void init() {
        json = new ObjectMapper();
    }

}
