package com.ge.predix.solsvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.predix.solsvc.dto.BatteryPercentageDetails;
import com.ge.predix.solsvc.dto.DashBoardDetails;
import com.ge.predix.solsvc.dto.PoleData;
import com.ge.predix.solsvc.dto.TableDetails;
import com.ge.predix.solsvc.exception.AssetIngestionUnrecoverableMappingException;






/**
 * Put all out business logic here.
 */
@Service
public class AssetModelServiceImpl implements IAssetModelService {

    @Autowired
    private IAssetModelDao assetModelDao;

    @Override
    public List<String> getEnterpriseIds() {
        // TODO Auto-generated method stub
        return assetModelDao.getServiceImpact();
    }

    @Override
    public String getCaseDetails(String caseId) throws Exception {
        try{
           return "this is your case Id :"+ Integer.parseInt(caseId);
        }catch(NumberFormatException e){
            throw new AssetIngestionUnrecoverableMappingException("case id not valid");
        }
        
    }

	@Override
	public List<PoleData> getPolData() {
		  return assetModelDao.getPolData();
	}

	@Override
	public List<DashBoardDetails> getDashBoardData() {
		// TODO Auto-generated method stub
		return assetModelDao.getDashBoardData();
	}
    
	@Override
	public List<TableDetails> getTableData() {
		// TODO Auto-generated method stub
		return assetModelDao.getTableData();
	}

	@Override
	public List<BatteryPercentageDetails> getBatteryPercentageDetails() {
		// TODO Auto-generated method stub
		return assetModelDao.getBatteryPercentageDetails();
	}
   


 

}
