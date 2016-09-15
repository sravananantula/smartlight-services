package com.ge.predix.solsvc.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ge.predix.solsvc.service.IAssetModelDao;

/**
 * Scheduler of tasks for asset ingestion.
 * @author 212472184
 */
@Component
public class AssetIngestionScheduler {

   @Autowired
   private IAssetModelDao assetModelDao;
	  
    /**
     * Checks task in the in-progress directory, to see if they're complete.
     */
    @Scheduled(cron = "*/10 * * * * *")
    public void polestausScheduler() {
    	assetModelDao.polestausScheduler();
    }
}
