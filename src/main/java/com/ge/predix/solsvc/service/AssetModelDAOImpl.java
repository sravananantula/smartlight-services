package com.ge.predix.solsvc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ge.predix.solsvc.dto.BatteryPercentageDetails;
import com.ge.predix.solsvc.dto.DashBoardDetails;
import com.ge.predix.solsvc.dto.PoleData;
import com.ge.predix.solsvc.dto.TableDetails;

@Repository
public class AssetModelDAOImpl  implements IAssetModelDao{
    
    @Autowired
    protected JdbcTemplate jdbc;
    
    
    
    
//    private static final String GET_POLE_DATA_QUERY = "Select CityName,ZoneName,PoleID,HealthStatus,Switch from (Select C1.CityID,ZoneID,CityName,ZoneName from  tblZones Z1 inner join  tblCities C1 ON Z1.CityID=C1.CityID)T1 INNER JOIN  tblPoles P1 ON P1.ZoneID=T1.ZoneID";
    private static final String GET_POLE_DATA_QUERY = "Select CityName,ZoneName,PoleID,BatteryPercentage,HealthStatus,Switch from (Select C1.CityID,ZoneID,CityName,ZoneName from tblZones Z1 inner join tblCities C1 ON Z1.CityID=C1.CityID)T1 INNER JOIN tblPoles P1 ON P1.ZoneID=T1.ZoneID   order by PoleId";
    private static final String GET_DASHBOARD_QUERY = "Select TT1.CityName,CountOfstreetlights,StreetlightsON,((StreetlightsON * 1.0)/CountOfstreetlights * 1.0)*100.0 PercentOfLightsON from (Select CityName,Count(PoleID) CountOfstreetlights from  (Select C1.CityID,ZoneID,CityName,ZoneName from  tblZones Z1 inner join  tblCities C1 ON Z1.CityID=C1.CityID)T1 INNER JOIN  tblPoles P1 ON P1.ZoneID=T1.ZoneID group by CityName)TT1 inner join (Select CityName,Count(PoleID) StreetlightsON from  (Select C1.CityID,ZoneID,CityName,ZoneName from  tblZones Z1 inner join  tblCities C1 ON Z1.CityID=C1.CityID)T1 INNER JOIN  tblPoles P1 ON P1.ZoneID=T1.ZoneID where HealthStatus=1group by CityName)TT2 ON TT1.CityName=TT2.CityName";
    private static final String GET_TABLE_QUERY = "Select TTT1.CityName,TTT1.ZoneName,StreetlightsON,StreetlightsOFF, (StreetlightsON+StreetlightsOFF) totallights, CurrentBattery,RecentLumenValue from (Select TT1.CityName,TT1.ZoneID,TT1.ZoneName,StreetlightsON,StreetlightsOFF from (Select CityName,T1.ZoneID,ZoneName,Count(PoleID) StreetlightsON from (Select C1.CityID,ZoneID,CityName,ZoneName from  tblZones Z1 inner join  tblCities C1 ON Z1.CityID=C1.CityID)T1 LEFT OUTER JOIN  tblPoles P1 ON P1.ZoneID=T1.ZoneID AND Switch=1 group by CityName,T1.ZoneID,ZoneName)TT1 INNER JOIN (Select CityName,T2.ZoneID,ZoneName,Count(PoleID) StreetlightsOFF from (Select C1.CityID,ZoneID,CityName,ZoneName from  tblZones Z1 inner join  tblCities C1 ON Z1.CityID=C1.CityID)T2 LEFT OUTER JOIN tblPoles P1 ON P1.ZoneID=T2.ZoneID AND Switch=0 group by CityName,T2.ZoneID,ZoneName) TT2 ON TT1.CityNAme=TT2.CityName and TT1.ZoneID=TT2.ZoneID)TTT1 LEFT OUTER JOIN (Select S1.ZoneID,RecentLumenValue,CurrentLevelOfCharge CurrentBattery from (select ZoneID,Max(LumenValue) RecentLumenValue from  tblZoneLumen group by ZoneID)S1 left outer join (Select * from  tblBattery) S2 ON S1.ZoneID=S2.ZoneID)TTT2 ON TTT1.ZoneID=TTT2.ZoneID";
    private static final String SCHEDULER_QUERY = "UPDATE tblPOles SET Switch=UpdateSwitch FROM (Select *, CASE WHEN HealthStatus=2 OR LumenValue>300 THEN 0 WHEN LumenValue>200 AND LumenValue<=300 AND POLEID%2=0 THEN 1 WHEN LumenValue>200 AND LumenValue<=300 AND POLEID%2<>0 THEN 0 WHEN LumenValue<=200 THEN 1 END UpdateSwitch from (Select P1.PoleID,P1.ZoneID,P1.Switch,P1.HealthStatus,Z1.LumenValue from tblPoles P1 inner join tblZoneLumen Z1 on P1.ZoneID=Z1.ZoneID)T1)T2 WHERE tblPoles.ZoneID=T2.ZoneID and tblPoles.PoleID=T2.PoleID"; 
    private static final String BATTERYPERCENTAGEDETAILS = "Select ZoneName,Capacity TotalCapacity,ChargeMode,CurrentLevelOfCharge,(CurrentLevelOfCharge * 1.0/Capacity)*100 BatteryPercent  from tblBattery B1,tblZones Z1  where B1.ZoneID=Z1.ZoneID";
    
    @Override
    public List<String> getServiceImpact() {
      //  List<String> enterprises =jdbc.query(GET_POLES_QUERY, PROPERTY_ROW_MAPPER);
        return null;
        
    }
    
    private static final RowMapper<String> PROPERTY_ROW_MAPPER = new RowMapper<String>() {
        public String mapRow(final ResultSet rs, final int rowNum) throws SQLException {

            return rs.getString("PoleID")+"_"+rs.getString("ZoneID");
        }
    };
    private static final RowMapper<PoleData> POLEDATA_ROW_MAPPER = new RowMapper<PoleData>() {
    	public PoleData mapRow(final ResultSet rs, final int rowNum) throws SQLException {
    		PoleData pole= new PoleData();
    		pole.setCityName(rs.getString("cityName"));
    		pole.setHealthStatus(rs.getString("HealthStatus"));
    		pole.setSwitchStatus(rs.getString("Switch"));
    		pole.setPoleID(rs.getString("PoleID"));
    		pole.setZoneName(rs.getString("ZoneName"));
    		pole.setBatteryPercentage(rs.getString("BatteryPercentage"));
    		return pole;
    		
    		
    	}
    };
    private static final RowMapper<DashBoardDetails> DASHBOARD_ROW_MAPPER = new RowMapper<DashBoardDetails>() {
    	public DashBoardDetails mapRow(final ResultSet rs, final int rowNum) throws SQLException {
    		DashBoardDetails db= new DashBoardDetails();
    		db.setCityName(rs.getString("cityName"));
    		db.setNoOfStreetlights(rs.getLong("CountOfstreetlights"));
    		db.setNoOfStreetlightsON(rs.getLong("StreetlightsON"));
    		db.setPercentOfLightsON(rs.getDouble("PercentOfLightsON"));
    		return db;
    	}
    };
    private static final RowMapper<TableDetails> TABLE_ROW_MAPPER = new RowMapper<TableDetails>() {
    	public TableDetails mapRow(final ResultSet rs, final int rowNum) throws SQLException {
    		TableDetails db= new TableDetails();
    		db.setCityName(rs.getString("CityName"));
    		db.setZoneName(rs.getString("ZoneName"));
    		db.setNoOfStreetlightsOff(rs.getString("StreetlightsOFF"));
    		db.setNoOfStreetlightsON(rs.getString("StreetlightsON"));
    		db.setCurrentBattery(rs.getString("CurrentBattery"));
    		db.setRecentLumensValue(rs.getString("RecentLumenValue"));
    		db.setTotalLights(rs.getString("totallights"));
    		return db;
    	}
    };
    private static final RowMapper<BatteryPercentageDetails> BATTERYPERCENTAGE_ROW_MAPPER = new RowMapper<BatteryPercentageDetails>() {
    	public BatteryPercentageDetails mapRow(final ResultSet rs, final int rowNum) throws SQLException {
    		BatteryPercentageDetails db= new BatteryPercentageDetails();
    		db.setZoneName(rs.getString("ZoneName"));
    		db.setChargeMode(rs.getString("ChargeMode"));
    		db.setCurrentLevelOfCharge(rs.getString("CurrentLevelOfCharge"));
    		db.setTotalCapacity(rs.getString("totalCapacity"));
    		return db;
    	}
    };
    
	@Override
	public List<PoleData> getPolData() {
		  List<PoleData> poleData =jdbc.query(GET_POLE_DATA_QUERY, POLEDATA_ROW_MAPPER);
	        return poleData;
	}
	@Override
	public List<DashBoardDetails> getDashBoardData() {
		// TODO Auto-generated method stub
		  List<DashBoardDetails> dashboardData =jdbc.query(GET_DASHBOARD_QUERY, DASHBOARD_ROW_MAPPER);
	        return dashboardData;
	}

	@Override
	public List<TableDetails> getTableData() {
		// TODO Auto-generated method stub
		  List<TableDetails> tableData =jdbc.query(GET_TABLE_QUERY, TABLE_ROW_MAPPER);
	        return tableData;
	}
	@Override
	public void polestausScheduler() {
			System.out.println("Scheduler run::"+Calendar.getInstance().getTime());
			jdbc.update(SCHEDULER_QUERY);
	}
	@Override
	public List<BatteryPercentageDetails> getBatteryPercentageDetails() {
		List<BatteryPercentageDetails> tableData =jdbc.query(BATTERYPERCENTAGEDETAILS, BATTERYPERCENTAGE_ROW_MAPPER);
        return tableData;
	}
	
}
