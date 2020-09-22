INSERT INTO Cliente(id, nombre_completo, direccion, telefono, email) VALUES (1123321432,'John Doe','Calle 80', '3212343212', 'jd@gmail.com');
INSERT INTO Carro(id, modelo, num_pasajeros, num_puertas, tipo_cambios, tipo_combustible) VALUES (1, '2020', 2, 2, 'Manual', 'Gas');
INSERT INTO Carro(id, modelo, num_pasajeros, num_puertas, tipo_cambios, tipo_combustible) VALUES (2, '2018', 5, 4, 'Automatico', 'Electrico');
INSERT INTO Carro(id, modelo, num_pasajeros, num_puertas, tipo_cambios, tipo_combustible) VALUES (3, '2020', 2, 2, 'Manual', 'Gas');
INSERT INTO Carro(id, modelo, num_pasajeros, num_puertas, tipo_cambios, tipo_combustible) VALUES (4, '2019', 5, 4, 'Automatico', 'Electrico');
INSERT INTO Reserva(id, id_carro, id_cliente, fecha_recogida) VALUES (1, 1, 1123321432, '2020-09-05 14:00:00.000000');
INSERT INTO Reserva(id, id_carro, id_cliente, fecha_recogida) VALUES (2, 2, 1123321432, '2020-09-06 14:00:00.000000');
INSERT INTO Reserva(id, id_carro, id_cliente, fecha_recogida) VALUES (3, 3, 1123321432, '2020-09-07 14:00:00.000000');
INSERT INTO Reserva(id, id_carro, id_cliente, fecha_recogida) VALUES (4, 4, 1123321432, '2020-09-08 14:00:00.000000');