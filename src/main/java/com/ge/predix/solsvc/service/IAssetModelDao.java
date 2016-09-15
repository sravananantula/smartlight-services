package com.ge.predix.solsvc.service;

import java.util.List;

import com.ge.predix.solsvc.dto.BatteryPercentageDetails;
import com.ge.predix.solsvc.dto.DashBoardDetails;
import com.ge.predix.solsvc.dto.PoleData;
import com.ge.predix.solsvc.dto.TableDetails;

public interface IAssetModelDao {
    List<String> getServiceImpact();
    List<PoleData> getPolData();
    List<DashBoardDetails> getDashBoardData();
    List<TableDetails> getTableData();
    void polestausScheduler();
    List<BatteryPercentageDetails> getBatteryPercentageDetails();
    
}
