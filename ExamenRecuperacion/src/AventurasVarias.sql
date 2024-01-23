-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS AventurasVarias;

-- Usar la base de datos
USE AventurasVarias;

-- Crear la tabla Clientes
CREATE TABLE Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    email VARCHAR(255),
    vip BOOLEAN,
    nacionalidad VARCHAR(255)
);

-- Insertar datos en la tabla Clientes
INSERT INTO Clientes (nombre, apellido, telefono, direccion, email, vip, nacionalidad) VALUES
    ('Luis', 'Hernández', '665544333', 'Avda. de los Pinos, 7', 'luis.hernandez@gmail.com', 1, 'Español'),
    ('Sophie', 'Leclair', '667788999', 'C/Cervantes, 15 Bajo Izquierda', 'sophie.leclair@gmail.com', 1, 'Francés'),
    ('Raj', 'Patel', '664433222', 'Paseo del Sol, 42', 'raj.patel@gmail.com', 0, 'Indio'),
    ('Elena', 'Sanchez', '669911000', 'C/Alameda, 18', 'elena.sanchez@hotmail.com', 0, 'Española'),
    ('Kenji', 'Tanaka', '661122333', 'Avda. de las Rosas, 88', 'kenji.tanaka@gmail.com', 1, 'Japonés'),
    ('Chiara', 'Rossi', '578934567', 'C/Alfonso X, 5, 2ºB', 'chiara.rossi@hotmail.com', 0, 'Italiana'),
    ('Mateo', 'Gómez', '645678987', 'Plaza Mayor, 3', 'mateo.gomez@gmail.com', 0, 'Argentino'),
    ('Sofia', 'Martinez', '601234567', 'C/Gran Vía, 55', 'sofia.martinez@gmail.com', 1, 'Mexicana');
