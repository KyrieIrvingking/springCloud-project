package com.atguigu.gmall.sms.dao;

import com.atguigu.gmall.sms.entity.SeckillSkuNoticeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀商品通知订阅
 * 
 * @author zhangquansheng
 * @email 2415619235@qq.com
 * @date 2020-02-27 23:20:50
 */
@Mapper
public interface SeckillSkuNoticeDao extends BaseMapper<SeckillSkuNoticeEntity> {
	
}
