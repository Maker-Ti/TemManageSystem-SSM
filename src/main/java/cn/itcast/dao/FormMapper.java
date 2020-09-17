package cn.itcast.dao;

import cn.itcast.domain.Form;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FormMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Form record);

    Form selectByPrimaryKey(Integer id);

    List<Form> selectAll();

    List<Form> selectFormByParam(Form record);

    int updateByPrimaryKey(Form record);
}