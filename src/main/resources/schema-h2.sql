
CREATE TABLE mnd_migration_itest.tblPoles(
	PoleID int NULL,
	ZoneID int NULL,
	PowerInputInVolts int NULL,
	HealthStatus int NULL,
	Switch boolean NULL
);
 
CREATE TABLE mnd_migration_itest.tblBattery(
	BatteryID int NULL,
	ZoneID int NULL,
	Capacity int NULL,
	Voltage int NULL,
	ChargeMode text NULL,
	CurrentLevelOfCharge int NULL
) ;


CREATE TABLE mnd_migration_itest.tblCities(
	CityID int NULL,
	CityName text NULL,
	Status boolean NULL
);

CREATE TABLE mnd_migration_itest.tblPoleHealthDesc(
	HealthID int NULL,
	HealthDesc text NULL
);

CREATE TABLE mnd_migration_itest.tblPoles(
	PoleID int NULL,
	ZoneID int NULL,
	PowerInputInVolts int NULL,
	HealthStatus int NULL,
	Switch boolean NULL
);
CREATE TABLE mnd_migration_itest.tblRunningPoles(
	PoleID int NULL,
	LightStartTime timestamp NULL,
	LightEndTime timestamp NULL,
	LightIllumination int NULL,
	LightOutputInLux int NULL,
	PowerConsumptionInWatts int NULL,
	HealthStatus int NULL
);

CREATE TABLE mnd_migration_itest.tblZoneLumen(
	LumenID int NULL,
	ZoneID int NULL,
	LumenValue int NULL,
	StartTime timestamp NULL,
	EndTime timestamp NULL
) ;

CREATE TABLE mnd_migration_itest.tblZones(
	ZoneID int NULL,
	ZoneName text NULL,
	CityID int NULL,
	MinPoleCount int NULL,
	MaxPoleCount int NULL
);
