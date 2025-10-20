INSERT INTO clients (name, surname, age, email, phone, status) VALUES
('Ana', 'García', 34, 'ana.garcia@example.com', '600111222', TRUE),
('Carlos', 'Martínez', 45, 'c.martinez@example.com', '611222333', TRUE),
('Lucía', 'Fernández', 28, 'lucia.f@example.com', '622333444', FALSE),
('David', 'Sánchez', 51, 'david.sanchez@example.com', '633444555', TRUE),
('Elena', 'López', 22, 'elena.lopez@example.com', '644555666', TRUE);

INSERT INTO trips (origin, destination, departure_date, arrival_date) VALUES
('Madrid - Atocha', 'Barcelona - Sants', '2025-11-10 09:00:00', '2025-11-10 11:45:00'),
('Aeropuerto de Sevilla (SVQ)', 'Aeropuerto de París (CDG)', '2025-11-12 15:30:00', '2025-11-12 18:00:00'),
('Estación de Autobuses de Valencia', 'Estación de Autobuses de Granada', '2025-11-15 22:00:00', '2025-11-16 04:30:00'),
('Málaga - María Zambrano', 'Madrid - Atocha', '2025-11-18 10:00:00', '2025-11-18 12:50:00'),
('Aeropuerto de Bilbao (BIO)', 'Aeropuerto de Londres (LHR)', '2025-11-20 07:15:00', '2025-11-20 08:30:00');

insert into client_trip (client_id, trip_id) values
(1,1),
(2,1),
(3,1),
(1,2),
(1,3);