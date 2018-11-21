package com.cute.play.drama.mapper;

import com.cute.play.drama.BaseTest;
import com.cute.play.drama.entity.Drama;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
public class DramaMapperTest extends BaseTest {
    @Autowired
    private DramaMapper dramaMapper;

    @Test
    public void test(){
        List<Drama> list = dramaMapper.selectList(null);
        System.out.println(list);
    }
}
