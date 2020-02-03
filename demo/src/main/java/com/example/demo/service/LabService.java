package com.example.demo.service;

import com.example.demo.domain.entity.Lab;
import com.example.demo.mapper.LabMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/1/31 14:43
 * @Description:
 */
@Service
public class LabService {

    @Resource
    LabMapper labMapper;


    //展示所有实验室状态
    public List<Lab> showAllLabs(Integer page,Integer pageSize)
    {
        page=(page-1)*pageSize;
        List<Lab> labs = labMapper.selectAll(page, pageSize);
        return labs;
    }

    //预约实验室
    public Integer preOrder(Integer labId)
    {
        if(labId!=2)
        {
            return 0;
        }
        return labMapper.updateStatus(labId,2);
    }

    //添加实验室
    public Integer addLab(Lab lab)
    {
        return labMapper.insertSelective(lab);
    }

    //获取实验室总数
    public Integer getCount()
    {
        return labMapper.countAll();
    }

    //删除实验室
    public Integer delLab(Integer id)
    {
        return labMapper.deleteByPrimaryKey(id);
    }

    //修改实验室信息
    public Integer modLab(Lab lab)
    {
        return labMapper.updateByPrimaryKeySelective(lab);
    }

    //查询
    public Lab getById(Integer lId)
    {
        return labMapper.selectByPrimaryKey(lId);
    }

}
