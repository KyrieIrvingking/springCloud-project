package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.ProductAttrValueEntity;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class BaseAttrVo extends ProductAttrValueEntity {
    public void setValueSelected(List<String> selected) {
        if(selected != null) {
            this.setAttrValue(StringUtils.join(selected,","));
        }
    }
}
