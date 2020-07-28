package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.SpuInfoEntity;
import lombok.Data;

import java.util.List;
@Data
public class SpuInfoVo extends SpuInfoEntity {
    List<String> spuImages;
    List<?> baseAttrs;
    List<?> skus;

}
