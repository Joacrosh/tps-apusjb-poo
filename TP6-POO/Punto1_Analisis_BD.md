# TP6 - Punto 1: Análisis del modelo de datos

## 1.a) ¿El modelo de la cátedra sirve para guardar las instancias de la aplicación?

La aplicación del TP4 crea:

- **32 piezas** (16 por color). Cada una tiene **tipo** (Torre, Caballo, Alfil, Reina, Rey, Peón), **color**, y tres atributos tomados del poema de Borges: **velocidad, comportamiento y movimiento**. Cada pieza está ubicada en un casillero (por ejemplo, la torre blanca en A1).
- **64 casilleros**, cada uno con su **coordenada** y su **color**.

Comparación con el modelo anterior (`color`, `tipopieza`, `pieza`):

| Dato de la aplicación | Dónde se guarda |
|---|---|
| Tipo de pieza | `pieza.idTipoPieza` → tabla `tipopieza` |
| Color de la pieza | `pieza.idColor` → tabla `color` |
| Velocidad, comportamiento, movimiento | `pieza.Velocidad`, `pieza.Comportamiento`, `pieza.Movimiento` |
| Casillero donde está la pieza | `pieza.Posicion` (coordenada, por ejemplo "A1") |
| Casilleros (coordenada y color) | No se guardan (ver la decisión más abajo) |

**Conclusión:** el modelo **sirve para guardar las piezas**, porque tiene una columna para cada atributo de la clase `Pieza`. Pero tiene algunos problemas para corregir:

1. **La clave primaria de `pieza` es compuesta** (`idPieza`, `idColor`, `idTipoPieza`). Alcanza con `idPieza`, que ya es autoincremental. Con la clave compuesta, el mismo `idPieza` podría repetirse con otro color o tipo.
2. **`Posicion` es `VARCHAR(45)` y acepta cualquier texto**, y nada impide que dos piezas estén en el mismo casillero.
3. **En `color`, el `UNIQUE` sobre `idColor` es redundante**, porque `idColor` ya es clave primaria.

**Decisión sobre los casilleros:** no se agrega una tabla de casilleros. El color de un casillero se deduce de su coordenada (A1 es negro y los colores se alternan), y la ubicación de cada pieza ya se guarda en `Posicion`. Con eso se puede reconstruir el tablero completo.

## 1.b) Modificaciones necesarias

| Tabla | Cambio | Motivo |
|---|---|---|
| `pieza` | Clave primaria solo `idPieza` | Es único y autoincremental: alcanza para identificar cada pieza |
| `pieza` | `Posicion` pasa a `CHAR(2)` con `UNIQUE` | Las coordenadas tienen 2 caracteres ("A1" a "H8"), y dos piezas no pueden ocupar el mismo casillero |
| `color` | Se quita el `UNIQUE` sobre `idColor` | Es redundante con la clave primaria |
| Base y tablas | `utf8mb3` → `utf8mb4` | `utf8mb3` está obsoleto; `utf8mb4` guarda bien los acentos |

Se mantienen las columnas `Descripcion` y `Posicion`, que usa el programa, y `Fecha_Creacion`, que ahora el programa completa con la fecha del día.

Además, como `Posicion` es única, el programa **borra las piezas guardadas antes de insertar** (`PiezaDAO.borrarPiezas`). Así se puede ejecutar más de una vez sin duplicar datos.

## 1.c) Cambios en la BD

Los cambios están en el script **`TP6_cambios_BD.sql`**.