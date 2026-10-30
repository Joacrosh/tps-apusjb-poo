
-- TP6 - Persistencia de Ajedrez en BD
-- Punto 1.c: cambios al modelo de datos de la cátedra (base `ajedrez`)
-- No borra columnas: el programa sigue usando Descripcion y Posicion.

USE ajedrez;

-- 1) Clave primaria de pieza: era (idPieza, idColor, idTipoPieza).
--    Alcanza con idPieza, que es autoincremental y único. Con la clave
--    compuesta, el mismo idPieza podía repetirse con otro color o tipo.
ALTER TABLE pieza DROP PRIMARY KEY, ADD PRIMARY KEY (idPieza);

-- 2) Posicion: era VARCHAR(45) y aceptaba cualquier texto.
--    Ahora guarda solo la coordenada del casillero ("A1" a "H8") y es
--    UNIQUE, para que dos piezas no puedan estar en el mismo casillero.
--    Puede ser NULL (pieza fuera del tablero).
ALTER TABLE pieza
  MODIFY Posicion CHAR(2) NULL,
  ADD UNIQUE KEY uq_Pieza_Posicion (Posicion);

-- 3) color: el índice UNIQUE sobre idColor sobra, porque idColor ya es
--    clave primaria (que siempre es única).
ALTER TABLE color DROP INDEX idColor_UNIQUE;

-- Verificación
DESCRIBE pieza;
DESCRIBE color;
