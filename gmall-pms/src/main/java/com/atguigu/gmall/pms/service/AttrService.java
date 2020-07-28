package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 商品属性
 *
 * @author zhangquansheng
 * @email 2415619235@qq.com
 * @date 2020-02-20 23:15:01
 */
public interface AttrService extends IService<AttrEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo queryAttrByCid(QueryCondition queryCondition, Long cid, Integer type);

    void saveAttr(AttrVo attrVo);
}

