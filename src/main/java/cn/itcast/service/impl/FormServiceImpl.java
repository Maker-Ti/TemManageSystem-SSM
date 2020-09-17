package cn.itcast.service.impl;


import cn.itcast.dao.FormMapper;
import cn.itcast.dao.UserMapper;
import cn.itcast.domain.Form;
import cn.itcast.domain.User;
import cn.itcast.service.FormService;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormMapper formMapper;


    @Override
    public List<Form> selectFormByParam(Form record) {
        return formMapper.selectFormByParam(record);
    }

    @Override
    public List<Form> selectAll() {
        return formMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Form record) {
        return formMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(Form record) {
        return formMapper.insert(record);
    }

    @Override
    public Form selectByPrimaryKey(Integer id) {
        return formMapper.selectByPrimaryKey(id);
    }
}
