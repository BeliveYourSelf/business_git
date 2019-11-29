package com.youxu.business.service;

import com.youxu.business.pojo.Harvest;

import java.util.List;

public interface HarvestService {

    Integer insertHarvestAddress(Harvest harvest);

    Integer updateHarvestAddress(Harvest harvest);

    Harvest selectOneHarvestAddress(String id);

    List<Harvest> selectHarvestAddressList(Harvest harvest);
}
