package cn.itcast.service;

import cn.itcast.domain.Form;
import cn.itcast.domain.User;

import java.util.List;


public interface FormService {
    List<Form> selectFormByParam(Form record);
    List<Form> selectAll();
    int updateByPrimaryKey(Form record);
    int insert(Form record);
    Form selectByPrimaryKey(Integer id);
}
