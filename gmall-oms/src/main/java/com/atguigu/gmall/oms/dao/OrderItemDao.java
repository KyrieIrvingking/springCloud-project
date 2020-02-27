package com.atguigu.gmall.oms.dao;

import com.atguigu.gmall.oms.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author zhangquansheng
 * @email 2415619235@qq.com
 * @date 2020-02-27 23:36:48
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
