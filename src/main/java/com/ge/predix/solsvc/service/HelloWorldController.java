package com.ge.predix.solsvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ge.predix.solsvc.dto.BatteryPercentageDetails;
import com.ge.predix.solsvc.dto.DashBoardDetails;
import com.ge.predix.solsvc.dto.PoleData;
import com.ge.predix.solsvc.dto.TableDetails;
import com.ge.predix.solsvc.exception.BadRequestException;
import com.ge.predix.solsvc.exception.NoContentException;




@RestController
public class HelloWorldController {
    
    @Autowired
    IAssetModelService service;
  
    @RequestMapping(value = "/services/hello/enterpriseidstest/{uuid}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> testResponse(@PathVariable(value = "uuid") final String uuid) throws Exception{
        try {
            System.out.println("in controller class");
            if(!StringUtils.isEmpty(uuid) ){
                throw new NoContentException("No data found");
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("hello", HttpStatus.OK);
       
    }
    
    @RequestMapping(value = "/services/hello/{caseId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> testResponse1(@PathVariable(value = "caseId") final String caseId) throws Exception{
        String response=null;
            response=service.getCaseDetails(caseId);
        return new ResponseEntity<>(response, HttpStatus.OK);
       
    }
    @RequestMapping(value = "/services/test", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> testResponse2(@RequestParam(value = "caseId") final String caseId) throws Exception{
        if (StringUtils.isEmpty(caseId)) {
            throw new BadRequestException("Invalid Request, missing enterprise name.");
        }
        String response=null;
        response=service.getCaseDetails(caseId);
        return new ResponseEntity<>(response, HttpStatus.OK);
       
    }
    
    @RequestMapping(value = "/services/getpoledata", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> getzonepoles() throws Exception{
       
        List<PoleData> response=null;
        response=service.getPolData();
        return new ResponseEntity<>(response, HttpStatus.OK);
       
    }
    
    @RequestMapping(value = "/services/getdashboarddata", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> getdashboarddata() throws Exception{
       
        List<DashBoardDetails> response=null;
        response=service.getDashBoardData();
        return new ResponseEntity<>(response, HttpStatus.OK);
       
    }
    
    
    
    @RequestMapping(value = "/services/getTabledata", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> getTabledata() throws Exception{
       
        List<TableDetails> response=null;
        response=service.getTableData();
        return new ResponseEntity<>(response, HttpStatus.OK);
       
    }
    
    @RequestMapping(value = "/services/getBatteryData", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> getBatteryData() throws Exception{
    	
    	List<BatteryPercentageDetails> response=null;
    	response=service.getBatteryPercentageDetails();
    	return new ResponseEntity<>(response, HttpStatus.OK);
    	
    }
}
