use smartcals;

ALTER TABLE administratorlogin ADD LoginTimeStamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP after Location;
ALTER TABLE administratorlogin ADD LoginAttempts int after Password;
ALTER TABLE administratorlogin ADD PRIMARY KEY(UserName);
ALTER TABLE administratorlogin ADD Status varchar (100);

INSERT INTO administratorlogin (VendingMachineID, UserName, Password, Location, Status) VALUES (1000, 'admin', 'test123', 'santa clara', 'ACTIVE');

