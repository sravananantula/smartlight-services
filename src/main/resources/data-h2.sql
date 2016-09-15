
INSERT into mnd_migration_itest.tblBattery (BatteryID, ZoneID, Capacity, Voltage, ChargeMode, CurrentLevelOfCharge) VALUES 
(1, 1, 5000, 12, 'Solar', 5000),
(2, 2, 5000, 12, 'Solar', 4500),
(3, 3, 5000, 12, 'EB', 5000),
(4, 4, 5000, 12, 'Solar', 3000);


INSERT into mnd_migration_itest.tblCities (CityID, CityName, Status) VALUES 
(1, 'Hyderabad', true),
(2, 'Vijayawada', true),
(3, 'Visakapatnam', true);


INSERT mnd_migration_itest.tblPoleHealthDesc (HealthID, HealthDesc) VALUES
(1, 'Good'),
(2, 'Bad'),
(3, 'Needs Maintenance');


INSERT into mnd_migration_itest.tblPoles(PoleID,ZoneID,PowerInputInVolts,HealthStatus,Switch) VALUES 
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


INSERT into mnd_migration_itest.tblZones (ZoneID, ZoneName, CityID, MinPoleCount, MaxPoleCount) VALUES 
(1, 'HitechCity', 1, 20, 100),
(2, 'Suraram', 1, 20, 100),
(3, 'KPHB', 1, 20, 100),
(4, 'Mothinagar', 1, 20, 100);


INSERT into mnd_migration_itest.tblZoneLumen (LumenID, ZoneID, LumenValue, StartTime, EndTime) VALUES
(1, 1, 500, '2016-09-12 03:00:00.000','2016-09-12 05:00:00.000')
,(2, 1, 1600, '2016-09-12 05:00:00.000','2016-09-12 07:00:00.000')
,(3, 1, 400, '2016-09-12 07:00:00.000','2016-09-12 09:00:00.000')
,(4, 1, 100000, '2016-09-12 09:00:00.000','2016-09-12 11:00:00.000')
,(5, 1, 100000, '2016-09-12 11:00:00.000','2016-09-12 13:00:00.000')
,(6, 1, 120000, '2016-09-12 13:00:00.000','2016-09-12 15:00:00.000')
,(7, 1, 100000, '2016-09-12 15:00:00.000','2016-09-12 16:00:00.000')
,(8, 1, 45000, '2016-09-12 16:00:00.000','2016-09-12 16:30:00.000')
,(9, 1, 15000, '2016-09-12 16:30:00.000','2016-09-12 16:55:00.000')
,(10, 1, 4000, '2016-09-12 16:55:00.000','2016-09-12 17:25:00.000');