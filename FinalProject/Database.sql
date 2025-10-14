CREATE DATABASE javafinal;
USE javafinal;

CREATE TABLE Persons(
	PersonID int primary key auto_increment,
    FName varchar(50),
    LName varchar(50)
);

CREATE TABLE Products(
	ProductID int primary key auto_increment,
    PName varchar(50),
    Price decimal(10,2),
    Quantity int
);

CREATE TABLE Purchase(
	PurchaseID int primary key auto_increment,
    PersonID int,
    ProductID int,
    PurchaseDate date,
    Quantity int,
    foreign key (PersonID) references Persons(PersonID),
    foreign key (ProductID) references Products(ProductID)
);

INSERT INTO Persons(FName,LName) VALUES ("Nick","Wonder");

INSERT INTO Products(PName,Price,Quantity) VALUES ("Protein Powder", 29.99, 5);

INSERT INTO purchase(PersonID, ProductID, PurchaseDate, Quantity) VALUES (1,1,current_date(),1);

SELECT * FROM Persons;
SELECT * FROM Products;
SELECT * FROM Purchase;