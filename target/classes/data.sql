IF OBJECT_ID('persistent_logins', 'U') IS NOT NULL
	DROP TABLE [persistent_logins];

CREATE TABLE [persistent_logins] ( 
     [username] varchar(100) NOT NULL, 
     [series] varchar(64) PRIMARY KEY, 
     [token] varchar(64) NOT NULL, 
     [last_used] timestamp NOT NULL
);

INSERT INTO dbo.role VALUES(1, 'ROLE_ADMIN')
INSERT INTO dbo.role VALUES(2, 'ROLE_ACTUATOR')
INSERT INTO dbo.role VALUES(3, 'ROLE_USER')

INSERT INTO dbo.usuario VALUES(1, 'ocampo', 'admin@gmail.com', GETDATE(), 'edgar', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', '8700')
INSERT INTO dbo.usuario VALUES(3, 'sanchez', 'user@gmail.com', GETDATE(), 'jose', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', '9900')

INSERT INTO dbo.user_role VALUES(1,1)
INSERT INTO dbo.user_role VALUES(1,2)
INSERT INTO dbo.user_role VALUES(1,3)
INSERT INTO dbo.user_role VALUES(3,2)
INSERT INTO dbo.user_role VALUES(3,3)

--select * from dbo.usuario
--select * from dbo.role
--select * from dbo.user_role

--SELECT *
--FROM dbo.usuario
--INNER JOIN dbo.user_role
--ON dbo.usuario.id_usuario = dbo.user_role.id_role