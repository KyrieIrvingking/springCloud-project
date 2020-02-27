package com.atguigu.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.ums.entity.MemberCollectSpuEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;


/**
 * 会员收藏的商品
 *
 * @author zhangquansheng
 * @email 2415619235@qq.com
 * @date 2020-02-27 23:33:36
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageVo queryPage(QueryCondition params);
}

