CREATE TABLE Airport (
IATA_location_code char(3) not null,
airport_name varchar(15),
country varchar(15),
state char(2),
primary key (IATA_location_code));


CREATE TABLE Airline(
Airline_code char(2) not null,
Airline_name varchar(25),
Origin_country varchar(15),
primary key (Airline_code));

CREATE TABLE Customer (
c_EmailID varchar(20),
c_Name varchar(20) not null,
mileage numeric(4,0),
registration_in_mlg_program char(1),
home_airport varchar(15),
miles_count numeric(6,0),
password varchar(15),
IATA_location_code char(3),
primary key (c_EmailID),
foreign key  (IATA_location_code) references Airport (IATA_location_code) on delete cascade);

CREATE TABLE Credit_card (
credit_card_no char(16),
card_type varchar(10) not null,
bank_Name varchar(15) not null,
expiry_Date date not null,
Name_on_card varchar(20) not null,
c_EmailID varchar(20),
Primary key (credit_card_no),
Foreign key (c_EmailID) references Customer (c_EmailID) on delete cascade);

create TABLE Booking_ID (
booking_ID varchar(10),
c_EmailID varchar(20),
credit_card_no char(16),
primary key (booking_ID),
Foreign key (c_EmailID) references Customer (c_EmailID) on delete cascade,
foreign key (credit_card_no) references Credit_card (credit_card_no) on delete cascade);

CREATE TABLE Address (
Address varchar(35),
c_EmailID varchar(20),
Primary key(Address, c_EmailID),
Foreign key (c_EmailID) references Customer(c_EmailID) on delete cascade );

CREATE TABLE Flight (
Airline_code char(2),
Flight_no char(5),
Date date,
Dep_airport varchar(15),
Dep_time time,
Arr_airport varchar(15),
Arr_time time,
Max_seat_firstclass numeric(3,0),
Max_seat_economy numeric(3,0),
Length_of_flight numeric(4,0),
Booking_type varchar(15),
Bonus_miles numeric(4,0),
c_EmailID varchar(20),
Firstclass_price numeric(6,2),
Economy_price numeric(6,2),
Primary key (airline_code, flight_no, date),
Foreign key (airline_code) references Airline (airline_code) on delete cascade );

CREATE TABLE Mileage_Program (
Bonus_miles numeric(4,0),
c_EmailID varchar(20),
airline_code char(2),
flight_no char(5),
date date,
primary key(Bonus_miles, c_EmailID, airline_code, flight_no, date),
foreign key (c_EmailID) references Customer (c_EmailID) on delete cascade ,
foreign key (airline_code, flight_no, date) references Flight (airline_code, flight_no, date) on delete cascade);

CREATE TABLE Price(
Firstclass_price numeric(6,2),
Economy_price numeric(6,2),
Airline_code char(2),
Flight_no char(5),
Date date,
Primary key(firstclass_price, economy_price, airline_code, flight_no, date),
Foreign key (airline_code, flight_no, date) references Flight (airline_code, flight_no, date) on delete cascade);

CREATE TABLE Book_flight (
booking_ID varchar(10),
airline_code char(2),
flight_no char(5),
date date,
booking_date date,
primary key (booking_ID, airline_code, flight_no, date),
foreign key (booking_ID) references Booking_ID (booking_ID) on delete cascade,
foreign key (airline_code, flight_no, date) references Flight (airline_code, flight_no, date) on delete cascade);

CREATE TABLE Bonusmiles_cust (
c_EmailID varchar(20),
Bonus_miles numeric(4,0),
airline_code char(2),
flight_no char(5),
date date,
points_acquired_date date,
primary key (c_EmailID, Bonus_miles, airline_code, flight_no, date),
foreign key (c_EmailID) references Customer (c_EmailID) on delete cascade,
foreign key (airline_code, flight_no, date) references Flight (airline_code, flight_no, date) on delete cascade);





alter table book_flight
add booking_type varchar(10);






