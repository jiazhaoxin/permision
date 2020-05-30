package com.mmall.service;

import com.mmall.common.JsonData;
import com.mmall.dao.SysDeptMapper;
import com.mmall.param.DeptParam;
import com.mmall.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2020/5/29.
 */
@Service
public class SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    public JsonData save(DeptParam deptParam){
        BeanValidator.check(deptParam);
        return null;
    }
}
