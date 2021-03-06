CREATE TABLE tblBattery(
	BatteryID int NULL,
	ZoneID int NULL,
	Capacity int NULL,
	Voltage int NULL,
	ChargeMode text NULL,
	CurrentLevelOfCharge int NULL
) 


CREATE TABLE tblCities(
	CityID int NULL,
	CityName text NULL,
	Status boolean NULL
)

CREATE TABLE tblPoleHealthDesc(
	HealthID int NULL,
	HealthDesc text NULL
)

CREATE TABLE tblPoles(
	PoleID int NULL,
	ZoneID int NULL,
	PowerInputInVolts int NULL,
	HealthStatus int NULL,
	Switch boolean NULL
)
 
CREATE TABLE tblRunningPoles(
	PoleID int NULL,
	LightStartTime timestamp NULL,
	LightEndTime timestamp NULL,
	LightIllumination int NULL,
	LightOutputInLux int NULL,
	PowerConsumptionInWatts int NULL,
	HealthStatus int NULL
)

CREATE TABLE tblZoneLumen(
	LumenID int NULL,
	ZoneID int NULL,
	LumenValue int NULL,
	StartTime timestamp NULL,
	EndTime timestamp NULL
) 

CREATE TABLE tblZones(
	ZoneID int NULL,
	ZoneName text NULL,
	CityID int NULL,
	MinPoleCount int NULL,
	MaxPoleCount int NULL
)

INSERT into tblBattery (BatteryID, ZoneID, Capacity, Voltage, ChargeMode, CurrentLevelOfCharge) VALUES 
(1, 1, 5000, 12, 'Solar', 5000),
(2, 2, 5000, 12, 'Solar', 4500),
(3, 3, 5000, 12, 'EB', 5000),
(4, 4, 5000, 12, 'Solar', 3000)


INSERT into tblCities (CityID, CityName, Status) VALUES 
(1, 'Hyderabad', true),
(2, 'Vijayawada', true),
(3, 'Visakapatnam', true)


INSERT tblPoleHealthDesc (HealthID, HealthDesc) VALUES
(1, 'Good'),
(2, 'Bad'),
(3, 'Needs Maintenance')


INSERT into tblPoles(PoleID,ZoneID,PowerInputInVolts,HealthStatus,Switch) VALUES 
(1, 1, 12, 1, true),
(2, 1, 12, 1, true),
(3, 1, 12, 2, false),
(4, 2, 12, 3, false),
(5, 2, 12, 1, true),
(6, 2, 12, 2, false),
(7, 2, 12, 3, false),
(8, 3, 12, 1, true),
(9, 3, 12, 1, true),
(10, 4, 12, 1, true)


INSERT into tblZones (ZoneID, ZoneName, CityID, MinPoleCount, MaxPoleCount) VALUES 
(1, 'HitechCity', 1, 20, 100),
(2, 'Suraram', 1, 20, 100),
(3, 'KPHB', 1, 20, 100),
(4, 'Mothinagar', 1, 20, 100)


INSERT into tblZoneLumen (LumenID, ZoneID, LumenValue, StartTime, EndTime) VALUES
(1, 1, 500, '2016-09-12 03:00:00.000','2016-09-12 05:00:00.000')
,(2, 1, 1600, '2016-09-12 05:00:00.000','2016-09-12 07:00:00.000')
,(3, 1, 400, '2016-09-12 07:00:00.000','2016-09-12 09:00:00.000')
,(4, 1, 100000, '2016-09-12 09:00:00.000','2016-09-12 11:00:00.000')
,(5, 1, 100000, '2016-09-12 11:00:00.000','2016-09-12 13:00:00.000')
,(6, 1, 120000, '2016-09-12 13:00:00.000','2016-09-12 15:00:00.000')
,(7, 1, 100000, '2016-09-12 15:00:00.000','2016-09-12 16:00:00.000')
,(8, 1, 45000, '2016-09-12 16:00:00.000','2016-09-12 16:30:00.000')
,(9, 1, 15000, '2016-09-12 16:30:00.000','2016-09-12 16:55:00.000')
,(10, 1, 4000, '2016-09-12 16:55:00.000','2016-09-12 17:25:00.000')