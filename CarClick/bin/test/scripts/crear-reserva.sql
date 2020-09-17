INSERT INTO Cliente(id, nombre_completo, direccion, telefono, email) VALUES (1112587741,'John Doe','Calle 80', '3212343212', 'jd@gmail.com');
INSERT INTO Carro(id, modelo, num_pasajeros, num_puertas, tipo_cambios, tipo_combustible) VALUES (1, '2020', 2, 2, 'Manual', 'Gas');
INSERT INTO Reserva(id, id_carro, id_cliente, fecha_recogida) VALUES (1, 1, 1112587741, '2020-09-10 09:00:00.000000');