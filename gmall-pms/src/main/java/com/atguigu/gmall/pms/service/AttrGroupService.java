package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.GroupVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;

import java.util.List;
import java.util.concurrent.locks.Condition;


/**
 * 属性分组
 *
 * @author zhangquansheng
 * @email 2415619235@qq.com
 * @date 2020-02-20 23:15:01
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo queryGroupById(QueryCondition condition, Long cid);

    GroupVo queryGroupWithAttrsByGid(Long gid);

    List<GroupVo> queryGroupWithAttrsByCid(Long cid);
}

