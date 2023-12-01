create database viajes;
create user viajes identified by '123456';
GRANT ALL PRIVILEGES ON viajes.* TO viajes;
FLUSH PRIVILEGES;

use viajes;

-- Sample data for table `cliente`
INSERT INTO `cliente` (`apellidos`, `email`, `nombres`, `telefono`) VALUES
('Gomez', 'gomez@example.com', 'Juan', 123456789),
('Lopez', 'lopez@example.com', 'Maria', 987654321),
('Martinez', 'martinez@example.com', 'Carlos', 555666777),
('Rodriguez', 'rodriguez@example.com', 'Ana', 111222333),
('Fernandez', 'fernandez@example.com', 'Pablo', 999888777);

-- Sample data for table `hotel`
INSERT INTO `hotel` (`direccion`, `localidad`, `nombre`, `numero_estrellas`, `provincia`, `telefono`) VALUES
('123 Main St', 'City1', 'Hotel A', 4, 'Province1', 111111111),
('456 Oak St', 'City2', 'Hotel B', 3, 'Province2', 222222222),
('789 Pine St', 'City3', 'Hotel C', 5, 'Province3', 333333333),
('101 Elm St', 'City4', 'Hotel D', 4, 'Province4', 444444444),
('202 Maple St', 'City5', 'Hotel E', 3, 'Province5', 555555555);

-- Sample data for table `sucursal`
INSERT INTO `sucursal` (`direccion`, `localidad`, `provincia`, `telefono`) VALUES
('789 Oak St', 'City2', 'Province2', 666666666),
('234 Birch St', 'City4', 'Province4', 777777777),
('567 Cedar St', 'City1', 'Province1', 888888888),
('890 Pine St', 'City3', 'Province3', 999999999),
('123 Maple St', 'City5', 'Province5', 101010101);

-- Sample data for table `vuelo`
INSERT INTO `vuelo` (`destino`, `fecha_llegada`, `fecha_salida`, `hora_llegada`, `hora_salida`, `numero_plazas_totales`, `origen`) VALUES
('City1', '2023-12-10', '2023-12-05', '12:00 PM', '08:00 AM', 150, 'City2'),
('City2', '2023-12-15', '2023-12-10', '03:00 PM', '01:00 PM', 200, 'City3'),
('City3', '2023-12-20', '2023-12-15', '06:00 PM', '04:00 PM', 100, 'City4'),
('City4', '2023-12-25', '2023-12-20', '09:00 PM', '07:00 PM', 120, 'City5'),
('City5', '2023-12-30', '2023-12-25', '12:00 AM', '10:00 PM', 180, 'City1');

-- Sample data for table `reserva`
INSERT INTO `reserva` (`clase`, `idcliente`, `idhotel`, `idsucursal`, `idvuelo`) VALUES
('Economy', 1, 1, 1, 1),
('Business', 2, 2, 2, 2),
('First Class', 3, 3, 3, 3),
('Economy', 4, 4, 4, 4),
('Business', 5, 5, 5, 5);
