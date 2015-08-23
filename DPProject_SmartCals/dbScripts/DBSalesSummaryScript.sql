use smartcals;

CREATE TABLE `salessummary` (
 `VendingMachineID` int(11) DEFAULT NULL,
 `DailySalesAmount` double DEFAULT NULL,
 `TotalSales` double DEFAULT NULL,
 `LastModifiedTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `VendingMachineID_idx` (`VendingMachineID`),
  CONSTRAINT `VendingMachineID` FOREIGN KEY (`VendingMachineID`) REFERENCES `vendingmachine` (`VendingMachineID`) ON DELETE CASCADE
);


INSERT INTO salessummary (DailySalesAmount, VendingMachineID, TotalSales)
	VALUES (50.00, 2000, 100.00);
    
INSERT INTO salessummary (DailySalesAmount, VendingMachineID, TotalSales)
	VALUES (200.00, 2000, 300.00);
    
INSERT INTO salessummary (DailySalesAmount, VendingMachineID, TotalSales)
	VALUES (200.00, 1000, 300.00);