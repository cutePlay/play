package com.cute.play.drama.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cute.play.drama.entity.Drama;
import org.springframework.stereotype.Repository;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Repository
public class DramaRepository extends ServiceImpl<BaseMapper<Drama>, Drama> {

}
