package com.youxu.business.service.impl;

import com.youxu.business.dao.HarvestMapper;
import com.youxu.business.pojo.Harvest;
import com.youxu.business.service.HarvestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
