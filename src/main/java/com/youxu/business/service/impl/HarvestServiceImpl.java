package com.youxu.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.youxu.business.dao.HarvestMapper;
import com.youxu.business.pojo.Harvest;
import com.youxu.business.service.HarvestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HarvestServiceImpl implements HarvestService {
    @Resource
    private HarvestMapper harvestMapper;

    @Override
    public Integer insertHarvestAddress(Harvest harvest) {
        return harvestMapper.insertHarvestAddress(harvest);
    }

    @Override
    public Integer updateHarvestAddress(Harvest harvest) {
        return harvestMapper.updateHarvestAddress(harvest);
    }

    @Override
    public Harvest selectOneHarvestAddress(String id) {
        return harvestMapper.selectOneHarvestAddress(Integer.valueOf(id));
    }

    @Override
    public List<Harvest> selectHarvestAddressList(Harvest harvest) {
        return harvestMapper.selectHarvestAddressList(harvest);
    }
}
