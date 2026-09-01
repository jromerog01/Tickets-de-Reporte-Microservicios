-- Tabla Areas
CREATE TABLE unidades_organizacionales(
    id_unidad SERIAL,
    id_unidad_padre INT,
    area VARCHAR(100),
    tipo_area VARCHAR(50)
);

-- Llaves primarias y foraneas
ALTER TABLE unidades_organizacionales ADD CONSTRAINT pk_unidades_organizacionales PRIMARY KEY(id_unidad);
ALTER TABLE unidades_organizacionales ADD CONSTRAINT fk_unidades_padre FOREIGN KEY(id_unidad_padre) REFERENCES unidades_organizacionales(id_unidad) ON DELETE RESTRICT;

-- No nulos
ALTER TABLE unidades_organizacionales ALTER COLUMN id_unidad SET NOT NULL;
ALTER TABLE unidades_organizacionales ALTER COLUMN area SET NOT NULL;
ALTER TABLE unidades_organizacionales ALTER COLUMN tipo_area SET NOT NULL;


-- Tabla empleados
CREATE TABLE empleados(
    id_empleado SERIAL,
    id_unidad INT,
    id_jefe INT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    username VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    rol VARCHAR(50),
    disponibilidad BOOLEAN DEFAULT TRUE,
    activo BOOLEAN DEFAULT TRUE
);

-- Llaves primarias y foraneas
ALTER TABLE empleados ADD CONSTRAINT pk_empleados PRIMARY KEY(id_empleado);
ALTER TABLE empleados ADD CONSTRAINT fk_empleados_unidad FOREIGN KEY(id_unidad) REFERENCES unidades_organizacionales(id_unidad);
ALTER TABLE empleados ADD CONSTRAINT fk_empleados_jefe FOREIGN KEY(id_jefe) REFERENCES empleados(id_empleado) ON DELETE RESTRICT;

-- No nulos
ALTER TABLE empleados ALTER COLUMN id_empleado SET NOT NULL;
ALTER TABLE empleados ALTER COLUMN id_unidad SET NOT NULL;
ALTER TABLE empleados ALTER COLUMN nombre SET NOT NULL;
ALTER TABLE empleados ALTER COLUMN apellido SET NOT NULL;
ALTER TABLE empleados ALTER COLUMN username SET NOT NULL;
ALTER TABLE empleados ALTER COLUMN email SET NOT NULL;
ALTER TABLE empleados ALTER COLUMN rol SET NOT NULL;
ALTER TABLE empleados ALTER COLUMN disponibilidad SET NOT NULL;
ALTER TABLE empleados ALTER COLUMN activo SET NOT NULL;

-- Restricciones de cada columna

ALTER TABLE empleados ADD CONSTRAINT chk_email_format CHECK (email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$');
ALTER TABLE empleados ADD CONSTRAINT chk_rol CHECK ( rol IN ('DIRECTOR', 'GERENTE', 'EMPLEADO') );


-- Tabla contrasenas
CREATE TABLE historial_contrasenas(
    id_contrasena SERIAL,
    id_empleado INT,
    contrasena VARCHAR(255),
    activa BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP
);

-- Llaves primarias y foraneas
ALTER TABLE historial_contrasenas ADD CONSTRAINT pk_contrasenas PRIMARY KEY(id_contrasena);
ALTER TABLE historial_contrasenas ADD CONSTRAINT fk_contrasenas_empleados FOREIGN KEY(id_empleado) REFERENCES empleados(id_empleado);

-- No nulos
ALTER TABLE historial_contrasenas ALTER COLUMN id_contrasena SET NOT NULL;
ALTER TABLE historial_contrasenas ALTER COLUMN id_empleado SET NOT NULL;
ALTER TABLE historial_contrasenas ALTER COLUMN contrasena SET NOT NULL;
ALTER TABLE historial_contrasenas ALTER COLUMN activa SET NOT NULL;
ALTER TABLE historial_contrasenas ALTER COLUMN fecha_creacion SET NOT NULL;
