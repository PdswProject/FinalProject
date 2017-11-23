-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-11-14 20:52:23.357

-- tables
-- Table: Acudiente
CREATE TABLE Acudiente (
    cc int  NOT NULL,
    nombre int  NOT NULL,
    apellido int  NOT NULL,
    vistoBueno boolean  NOT NULL,
    estudiante int  NOT NULL,
    CONSTRAINT Acudiente_pk PRIMARY KEY (cc)
);

-- Table: Asignatura
CREATE TABLE Asignatura (
    codigo int  NOT NULL,
    nombre varchar(30)  NULL,
    unidadAcademica varchar(40)  NOT NULL,
    Profesor_id int  NOT NULL,
    PlanDeEstudios_id int  NOT NULL,
    CONSTRAINT Asignatura_pk PRIMARY KEY (codigo)
);

-- Table: ConsejeroAcademico
CREATE TABLE ConsejeroAcademico (
    aval boolean  NOT NULL,
    comentarios varchar(100)  NOT NULL,
    id int  NOT NULL,
    CONSTRAINT ConsejeroAcademico_pk PRIMARY KEY (id)
);

-- Table: Decano
CREATE TABLE Decano (
    id int  NOT NULL,
    nombre varchar(25)  NULL,
    CONSTRAINT Decano_pk PRIMARY KEY (id)
);

-- Table: Estudiante
CREATE TABLE Estudiante (
    id int  NOT NULL,
    nombre varchar(25)  NULL,
    apellido varchar(25)  NULL,
    semestre int  NULL,
    creditosAprobados int  NULL,
    SolicitudCancelacion_id int  NOT NULL,
    Acudiente_id int  NOT NULL,
    ConsejeroAcademico_id int  NOT NULL,
    CONSTRAINT Estudiante_pk PRIMARY KEY (id)
);

-- Table: EstudianteAsignatura
CREATE TABLE EstudianteAsignatura (
    Estudiante_id int  NOT NULL,
    Asignatura_codigo int  NOT NULL,
    CONSTRAINT EstudianteAsignatura_pk PRIMARY KEY (Estudiante_id,Asignatura_codigo)
);

-- Table: EstudianteProgramaAcademico
CREATE TABLE EstudianteProgramaAcademico (
    Estudiante_id int  NOT NULL,
    ProgramaAcademico_id int  NOT NULL,
    CONSTRAINT EstudianteProgramaAcademico_pk PRIMARY KEY (Estudiante_id,ProgramaAcademico_id)
);

-- Table: PlanDeEstudios
CREATE TABLE PlanDeEstudios (
    id int  NOT NULL,
    numero_materias int  NOT NULL,
    ProgramaAcademico_id int  NOT NULL,
    CONSTRAINT PlanDeEstudios_pk PRIMARY KEY (id)
);

-- Table: Profesor
CREATE TABLE Profesor (
    id int  NOT NULL,
    nombre varchar(25)  NULL,
    CONSTRAINT Profesor_pk PRIMARY KEY (id)
);

-- Table: ProgramaAcademico
CREATE TABLE ProgramaAcademico (
    id int  NOT NULL,
    nombre varchar(25)  NOT NULL,
    planEstudios int  NOT NULL,
    decano_id int  NOT NULL,
    numero_creditos int  NOT NULL,
    CONSTRAINT ProgramaAcademico_pk PRIMARY KEY (id)
);

-- Table: SolicitudCancelacion
CREATE TABLE SolicitudCancelacion (
    id int  NOT NULL,
    estudiante int  NOT NULL,
    asignatura int  NOT NULL,
    fecha date  NULL,
    estado varchar(30)  NOT NULL,
    decano_id int  NOT NULL,
    CONSTRAINT SolicitudCancelacion_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Asignatura_PlanDeEstudios (table: Asignatura)
ALTER TABLE Asignatura ADD CONSTRAINT Asignatura_PlanDeEstudios
    FOREIGN KEY (PlanDeEstudios_id)
    REFERENCES PlanDeEstudios (id)  

;

-- Reference: Asignatura_Profesor (table: Asignatura)
ALTER TABLE Asignatura ADD CONSTRAINT Asignatura_Profesor
    FOREIGN KEY (Profesor_id)
    REFERENCES Profesor (id)  

;

-- Reference: ConsejeroAcademico_Profesor (table: ConsejeroAcademico)
ALTER TABLE ConsejeroAcademico ADD CONSTRAINT ConsejeroAcademico_Profesor
    FOREIGN KEY (id)
    REFERENCES Profesor (id)  

;

-- Reference: Decano_Profesor (table: Decano)
ALTER TABLE Decano ADD CONSTRAINT Decano_Profesor
    FOREIGN KEY (id)
    REFERENCES Profesor (id)  

;

-- Reference: Decano_ProgramaAcademico (table: ProgramaAcademico)
ALTER TABLE ProgramaAcademico ADD CONSTRAINT Decano_ProgramaAcademico
    FOREIGN KEY (decano_id)
    REFERENCES Decano (id)  

;

-- Reference: EstudianteAsignatura_Asignatura (table: EstudianteAsignatura)
ALTER TABLE EstudianteAsignatura ADD CONSTRAINT EstudianteAsignatura_Asignatura
    FOREIGN KEY (Asignatura_codigo)
    REFERENCES Asignatura (codigo)  

;

-- Reference: EstudianteProgramaAcademico_Estudiante (table: EstudianteProgramaAcademico)
ALTER TABLE EstudianteProgramaAcademico ADD CONSTRAINT EstudianteProgramaAcademico_Estudiante
    FOREIGN KEY (ProgramaAcademico_id)
    REFERENCES Estudiante (id)  

;

-- Reference: EstudianteProgramaAcademico_ProgramaAcademico (table: EstudianteProgramaAcademico)
ALTER TABLE EstudianteProgramaAcademico ADD CONSTRAINT EstudianteProgramaAcademico_ProgramaAcademico
    FOREIGN KEY (ProgramaAcademico_id)
    REFERENCES ProgramaAcademico (id)  

;

-- Reference: Estudiante_Acudiente (table: Estudiante)
ALTER TABLE Estudiante ADD CONSTRAINT Estudiante_Acudiente
    FOREIGN KEY (Acudiente_id)
    REFERENCES Acudiente (cc)  

;

-- Reference: Estudiante_ConsejeroAcademico (table: Estudiante)
ALTER TABLE Estudiante ADD CONSTRAINT Estudiante_ConsejeroAcademico
    FOREIGN KEY (ConsejeroAcademico_id)
    REFERENCES ConsejeroAcademico (id)  

;

-- Reference: Estudiante_EstudianteAsignatura (table: EstudianteAsignatura)
ALTER TABLE EstudianteAsignatura ADD CONSTRAINT Estudiante_EstudianteAsignatura
    FOREIGN KEY (Estudiante_id)
    REFERENCES Estudiante (id)  

;

-- Reference: Estudiante_SolicitudCancelacion (table: SolicitudCancelacion)
ALTER TABLE SolicitudCancelacion ADD CONSTRAINT Estudiante_SolicitudCancelacion
    FOREIGN KEY (estudiante)
    REFERENCES Estudiante (id)  

;

-- Reference: PlanDeEstudios_ProgramaAcademico (table: PlanDeEstudios)
ALTER TABLE PlanDeEstudios ADD CONSTRAINT PlanDeEstudios_ProgramaAcademico
    FOREIGN KEY (ProgramaAcademico_id)
    REFERENCES ProgramaAcademico (id)  

;

-- Reference: SolicitudCancelacion_Decano (table: SolicitudCancelacion)
ALTER TABLE SolicitudCancelacion ADD CONSTRAINT SolicitudCancelacion_Decano
    FOREIGN KEY (decano_id)
    REFERENCES Decano (id)  

;


-- End of file.

