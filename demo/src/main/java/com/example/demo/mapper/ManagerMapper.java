package com.example.demo.mapper;

import com.example.demo.domain.entity.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    Manager selectByUsername(@Param("manager") Manager manager);

}