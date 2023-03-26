USE kardio;

CREATE TABLE users(
	id INT PRIMARY KEY,
	registrationDate DATE,
	fullName CHAR(128),
	login CHAR(255),
	password CHAR(255),
	role CHAR(32),
	status CHAR(32),
	deletionDate DATE
);

INSERT INTO users values
	(111222, NULL, NULL, 'login1', 'password1', NULL, NULL, NULL),
	(222333, NULL, NULL, 'login2', 'password2', NULL, NULL, NULL);