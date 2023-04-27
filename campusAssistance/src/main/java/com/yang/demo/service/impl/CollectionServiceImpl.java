package com.yang.demo.service.impl;

import com.yang.demo.pojo.Collection;
import com.yang.demo.mapper.CollectionMapper;
import com.yang.demo.service.CollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ?ղ 服务实现类
 * </p>
 *
 * @author jing
 * @since 2023-04-21
 */
@Service
@Qualifier("CollectionServiceImpl")
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {

}
