package com.cute.play.drama.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cute.play.drama.entity.Drama;
import com.cute.play.drama.mapper.DramaMapper;
import org.springframework.stereotype.Repository;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Repository
public class DramaRepository extends ServiceImpl<DramaMapper, Drama> {

}
