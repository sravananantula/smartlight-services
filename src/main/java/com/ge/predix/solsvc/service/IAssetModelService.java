package com.ge.predix.solsvc.service;

import java.util.List;

import com.ge.predix.solsvc.dto.BatteryPercentageDetails;
import com.ge.predix.solsvc.dto.DashBoardDetails;
import com.ge.predix.solsvc.dto.PoleData;
import com.ge.predix.solsvc.dto.TableDetails;


/**
 * Interface that retrieves data from asset model.
 */
public interface IAssetModelService {


    /**
     * Returns a list of enterprise ids from PGS.
     * @return a list of enterprise ids
     */
    List<String> getEnterpriseIds();
    
    List<PoleData> getPolData();
    List<DashBoardDetails> getDashBoardData();
    List<TableDetails> getTableData();
    
    String getCaseDetails(String caseId) throws Exception;
    
    List<BatteryPercentageDetails> getBatteryPercentageDetails();

}
