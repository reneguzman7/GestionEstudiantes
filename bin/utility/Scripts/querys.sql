CREATE DATABASE gestion_estudiantes;
.DATABASE
USE gestion_estudiantes;

CREATE TABLE Estudiante (
                            id INT PRIMARY KEY,
                            nombre VARCHAR(50),
                            edad INT
);

CREATE TABLE Curso (
                       id INT PRIMARY KEY,
                       nombre VARCHAR(50),
                       descripcion VARCHAR(200)
);

CREATE TABLE Inscripcion (
                             id INT PRIMARY KEY,
                             idEstudiante INT,
                             idCurso INT,
                             FOREIGN KEY (idEstudiante) REFERENCES Estudiante(id),
                             FOREIGN KEY (idCurso) REFERENCES Curso(id)
);

-- Insertar registros en la tabla Estudiante
INSERT INTO Estudiante (id, nombre, edad) VALUES
                                              (1, 'Juan', 20),
                                              (2, 'María', 22),
                                              (3, 'Carlos', 19),
                                              (4, 'Luis', 21),
                                              (5, 'Ana', 23),
                                              (6, 'Pedro', 25),
                                              (7, 'Laura', 24),
                                              (8, 'David', 22),
                                              (9, 'Isabel', 23),
                                              (10, 'Hugo', 20),
                                              (11, 'Elena', 21),
                                              (12, 'Diego', 24),
                                              (13, 'Andrea', 22),
                                              (14, 'Santiago', 20),
                                              (15, 'Valeria', 23),
                                              (16, 'Miguel', 25),
                                              (17, 'Camila', 19),
                                              (18, 'Alejandro', 21),
                                              (19, 'Julia', 22),
                                              (20, 'Daniel', 24),
                                              (21, 'Carolina', 23),
                                              (22, 'Sofía', 20),
                                              (23, 'Javier', 22),
                                              (24, 'Fernanda', 24),
                                              (25, 'Adrián', 21),
                                              (26, 'Lucía', 23),
                                              (27, 'Mateo', 22),
                                              (28, 'Paula', 20),
                                              (29, 'Emilio', 25),
                                              (30, 'Catalina', 24);

-- Insertar registros en la tabla Curso
INSERT INTO Curso (id, nombre, descripcion) VALUES
                                                (1, 'Programación Java', 'Curso introductorio de programación en Java'),
                                                (2, 'Diseño Web', 'Curso de diseño de páginas web'),
                                                (3, 'Redes', 'Curso de redes de computadoras'),
                                                (4, 'Bases de Datos', 'Curso de bases de datos'),
                                                (5, 'Ingeniería de Software I', 'Curso de ingeniería de software'),
                                                (6, 'Algoritmos y Estructuras de Datos', 'Curso de algoritmos y estructuras de datos'),
                                                (7, 'Desarrollo de Aplicaciones Web', 'Curso de desarrollo de aplicaciones web'),
                                                (8, 'Sistemas Operativos', 'Curso de sistemas operativos'),
                                                (9, 'Inteligencia Artificial', 'Curso de inteligencia artificial'),
                                                (10, 'Ingeniería de Software II', 'Curso avanzado de ingeniería de software'),
                                                (11, 'Seguridad Informática', 'Curso de seguridad informática'),
                                                (12, 'Desarrollo de Aplicaciones Móviles', 'Curso de desarrollo de aplicaciones móviles'),
                                                (13, 'Diseño de Bases de Datos', 'Curso de diseño de bases de datos'),
                                                (14, 'Redes Avanzadas', 'Curso de redes avanzadas'),
                                                (15, 'Programación en C++', 'Curso de programación en C++'),
                                                (16, 'Ingeniería de Requisitos', 'Curso de ingeniería de requisitos'),
                                                (17, 'Desarrollo Ágil', 'Curso de desarrollo ágil de software'),
                                                (18, 'Minería de Datos', 'Curso de minería de datos'),
                                                (19, 'Arquitectura de Software', 'Curso de arquitectura de software'),
                                                (20, 'Programación en Python', 'Curso de programación en Python'),
                                                (21, 'Pruebas de Software', 'Curso de pruebas de software'),
                                                (22, 'Desarrollo Frontend', 'Curso de desarrollo frontend'),
                                                (23, 'Gestión de Proyectos', 'Curso de gestión de proyectos'),
                                                (24, 'Machine Learning', 'Curso de machine learning'),
                                                (25, 'Desarrollo Backend', 'Curso de desarrollo backend'),
                                                (26, 'Automatización de Pruebas', 'Curso de automatización de pruebas'),
                                                (27, 'Ética en la Ingeniería', 'Curso de ética en la ingeniería'),
                                                (28, 'Realidad Virtual y Aumentada', 'Curso de realidad virtual y aumentada'),
                                                (29, 'Blockchain', 'Curso de blockchain'),
                                                (30, 'Diseño de Interfaces de Usuario', 'Curso de diseño de interfaces');

-- Insertar registros en la tabla Inscripcion
INSERT INTO Inscripcion (id, idEstudiante, idCurso) VALUES
                                                        (1, 1, 1),
                                                        (2, 2, 2),
                                                        (3, 3, 3),
                                                        (4, 4, 4),
                                                        (5, 5, 5),
                                                        (6, 6, 6),
                                                        (7, 7, 7),
                                                        (8, 8, 8),
                                                        (9, 9, 9),
                                                        (10, 10, 10),
                                                        (11, 11, 11),
                                                        (12, 12, 12),
                                                        (13, 13, 13),
                                                        (14, 14, 14),
                                                        (15, 15, 15),
                                                        (16, 16, 16),
                                                        (17, 17, 17),
                                                        (18, 18, 18),
                                                        (19, 19, 19),
                                                        (20, 20, 20),
                                                        (21, 21, 21),
                                                        (22, 22, 22),
                                                        (23, 23, 23),
                                                        (24, 24, 24),
                                                        (25, 25, 25),
                                                        (26, 26, 26),
                                                        (27, 27, 27),
                                                        (28, 28, 28),
                                                        (29, 29, 29),
                                                        (30, 30, 30);

SELECT * FROM Estudiante;
SELECT * FROM Curso;
SELECT * FROM Inscripcion;


