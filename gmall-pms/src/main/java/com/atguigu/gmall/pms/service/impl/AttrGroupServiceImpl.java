package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.dao.AttrAttrgroupRelationDao;
import com.atguigu.gmall.pms.dao.AttrDao;
import com.atguigu.gmall.pms.entity.AttrAttrgroupRelationEntity;
import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.vo.GroupVo;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.atguigu.gmall.pms.dao.AttrGroupDao;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.gmall.pms.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Autowired
    AttrDao attrDao;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryGroupById(QueryCondition condition, Long cid) {
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper();
        if (cid != null) {
            wrapper.eq("catelog_id", cid);
        }
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(condition),
                wrapper
        );

        return new PageVo(page);
    }

    @Override
    public GroupVo queryGroupWithAttrsByGid(Long gid) {
        GroupVo groupVo = new GroupVo();
        AttrGroupEntity byId = this.getById(gid);
        BeanUtils.copyProperties(byId,groupVo);
        QueryWrapper<AttrAttrgroupRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("attr_group_id",byId.getAttrGroupId());
        List<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntities = attrAttrgroupRelationDao.selectList(wrapper);
        if(attrAttrgroupRelationEntities.isEmpty()){
            return groupVo;
        }
        groupVo.setRelations(attrAttrgroupRelationEntities);
        List<Long> collect = attrAttrgroupRelationEntities.stream().map(x -> x.getAttrId()).collect(Collectors.toList());
        List<AttrEntity> attrEntities = attrDao.selectBatchIds(collect);
        groupVo.setAttrEntities(attrEntities);
        return groupVo;
    }

    @Override
    public List<GroupVo> queryGroupWithAttrsByCid(Long cid) {
        List<AttrGroupEntity> groupList = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id",cid));
        return groupList.stream().map(attrGroupEntity ->
                this.queryGroupWithAttrsByGid(attrGroupEntity.getAttrGroupId())
        ).collect(Collectors.toList());
    }

}