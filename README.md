# LogiTrack SV - Sistema de Gestión Logística

## Descripción

LogiTrack SV es un sistema backend desarrollado con Spring Boot que permite la gestión de operaciones logísticas, incluyendo vehículos, conductores, clientes, rutas y alertas. El sistema está diseñado bajo una arquitectura NoSQL utilizando MongoDB, optimizada para escalabilidad y flexibilidad en el manejo de datos.

---

## Arquitectura

El proyecto sigue una arquitectura en capas:

* Controller: Exposición de endpoints REST
* Service: Lógica de negocio y transformación de datos
* Repository: Acceso a datos con Spring Data MongoDB
* DTO: Objetos de transferencia de datos (Request/Response)
* Mapper: Conversión entre entidades y DTOs
* Entity: Representación de las colecciones en MongoDB

---

## Tecnologías utilizadas

* Java 17
* Spring Boot 3.5.x
* Spring Data MongoDB
* MongoDB
* Lombok
* SpringDoc OpenAPI (Swagger)
* Maven

---

## Base de Datos

Se utiliza MongoDB como base de datos NoSQL.

Nombre de la base:

```text
logitracksv
```

Colecciones principales:

* vehiculos
* conductores
* clientes
* rutas
* alertas

---

### Cassandra

Cassandra se utiliza para almacenar información de telemetría, debido a su capacidad para manejar grandes volúmenes de escritura y datos distribuidos.

Keyspace:

```text
logitracksv
```

Tabla principal:

* telemetria

Nodos Cassandra utilizados:

* cassandra-seed
* cassandra-node2

---

## Configuración

### application.properties

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/logitracksv

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

---

## Ejecución del proyecto

1. Asegurar que MongoDB esté corriendo en el puerto 27017
2. Clonar el repositorio
3. Ejecutar el proyecto con Maven:

```
mvn spring-boot:run
```

4. Acceder a Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

## Verificación de Cassandra

Para verificar que los contenedores de Cassandra estén activos:

```bash
docker ps
```

Para verificar el estado del clúster:

```bash
docker exec -it cassandra-seed nodetool status
```

El estado esperado para los nodos es:

```text
UN
```

Donde:

* U = Up
* N = Normal

---

## Consultar datos en Cassandra

Para ingresar a Cassandra:

```bash
docker exec -it cassandra-seed cqlsh
```

Seleccionar el keyspace:

```sql
USE logitracksv;
```

Mostrar tablas:

```sql
DESCRIBE TABLES;
```

Consultar registros de telemetría:

```sql
SELECT * FROM telemetria LIMIT 10;
```

Consultar registros por vehículo:

```sql
SELECT * FROM telemetria
WHERE vehiculo_id = 'CAM-001'
LIMIT 10;
```

Consulta directa desde Docker:

```bash
docker exec -it cassandra-seed cqlsh -e "USE logitracksv; SELECT * FROM telemetria LIMIT 10;"
```

---

---

## Endpoints principales

### Vehículos

* POST /api/vehiculos
* GET /api/vehiculos
* GET /api/vehiculos/{id}
* PUT /api/vehiculos/{id}
* DELETE /api/vehiculos/{id}

### Clientes

* POST /api/clientes
* GET /api/clientes
* GET /api/clientes/{id}
* PUT /api/clientes/{id}
* DELETE /api/clientes/{id}
* GET /api/clientes/estado/{estado}
* GET /api/clientes/buscar?nombre=

### Rutas

* POST /api/rutas
* GET /api/rutas
* GET /api/rutas/{id}
* PUT /api/rutas/{id}
* DELETE /api/rutas/{id}
* GET /api/rutas/estado/{estado}
* GET /api/rutas/cliente/{clienteId}
* GET /api/rutas/vehiculo/{vehiculoId}
* GET /api/rutas/conductor/{conductorId}

### Alertas

* POST /api/alertas
* GET /api/alertas
* GET /api/alertas/{id}
* PUT /api/alertas/{id}
* DELETE /api/alertas/{id}
* GET /api/alertas/vehiculo/{vehiculoId}
* GET /api/alertas/estado/{estado}
* GET /api/alertas/tipo/{tipo}

---

### Telemetría Cassandra

* POST /api/telemetria
* GET /api/telemetria/{vehiculoId}
* GET /api/telemetria/{vehiculoId}/rango

## Endpoints y JSON de prueba

---

## Vehículos

### POST /api/vehiculos

```json
{
  "placa": "P123-456",
  "modelo": "Freightliner Cascadia",
  "anio": 2022,
  "estado": "ACTIVO",
  "conductorAsignado": {
    "conductorId": "U001",
    "nombre": "Juan Pérez",
    "licencia": "LIC123"
  },
  "sensoresInstalados": [
    {
      "tipo": "GPS",
      "activo": true
    }
  ],
  "ultimaMantenimiento": "2026-02-15"
}
```

---

### PUT /api/vehiculos/{id}

```json
{
  "placa": "P123-999",
  "modelo": "Freightliner Updated",
  "anio": 2023,
  "estado": "ACTIVO",
  "conductorAsignado": {
    "conductorId": "U002",
    "nombre": "Carlos López",
    "licencia": "LIC999"
  },
  "sensoresInstalados": [
    {
      "tipo": "GPS",
      "activo": true
    },
    {
      "tipo": "TEMP_CARGA",
      "activo": true,
      "rangoMax": 8
    }
  ],
  "ultimaMantenimiento": "2026-03-01"
}
```

---

### GET /api/vehiculos

```
/api/vehiculos?page=0&size=5&sort=placa,asc
```

---

## Clientes

### POST /api/clientes

```json
{
  "nombre": "Super Selectos",
  "direccion": "San Salvador",
  "telefono": "2222-3333",
  "email": "contacto@selectos.com",
  "estado": "ACTIVO"
}
```

---

### PUT /api/clientes/{id}

```json
{
  "nombre": "Super Selectos Actualizado",
  "direccion": "Santa Tecla",
  "telefono": "7777-8888",
  "email": "nuevo@selectos.com",
  "estado": "ACTIVO"
}
```

---

### GET /api/clientes

```
/api/clientes?page=0&size=5
```

---

### GET /api/clientes/estado/{estado}

```
/api/clientes/estado/ACTIVO?page=0&size=5
```

---

### GET /api/clientes/buscar

```
/api/clientes/buscar?nombre=super&page=0&size=5
```

---

## Rutas

### POST /api/rutas

```json
{
  "cliente": {
    "clienteId": "CLI001",
    "nombre": "Super Selectos"
  },
  "vehiculo": {
    "vehiculoId": "CAM-001",
    "placa": "P123-456",
    "modelo": "Freightliner Cascadia"
  },
  "conductor": {
    "conductorId": "U001",
    "nombre": "Juan Pérez",
    "licencia": "LIC123"
  },
  "origen": "San Salvador",
  "destino": "Santa Ana",
  "fechaSalida": "2026-04-10T08:00:00",
  "fechaLlegadaEstimada": "2026-04-10T12:00:00",
  "estado": "EN_CURSO"
}
```

---

### PUT /api/rutas/{id}

```json
{
  "cliente": {
    "clienteId": "CLI001",
    "nombre": "Super Selectos"
  },
  "vehiculo": {
    "vehiculoId": "CAM-002",
    "placa": "P999-888",
    "modelo": "Volvo Truck"
  },
  "conductor": {
    "conductorId": "U002",
    "nombre": "Carlos López",
    "licencia": "LIC999"
  },
  "origen": "San Salvador",
  "destino": "Sonsonate",
  "fechaSalida": "2026-04-11T08:00:00",
  "fechaLlegadaEstimada": "2026-04-11T12:00:00",
  "estado": "EN_CURSO"
}
```

---

### GET /api/rutas

```
/api/rutas?page=0&size=5
```

---

### Filtros

```
/api/rutas/estado/EN_CURSO?page=0&size=5
/api/rutas/cliente/CLI001?page=0&size=5
/api/rutas/vehiculo/CAM-001?page=0&size=5
/api/rutas/conductor/U001?page=0&size=5
```

---

## Alertas

### POST /api/alertas

```json
{
  "vehiculoId": "CAM-001",
  "tipoAlerta": "TEMPERATURA_ALTA",
  "valor": 15.5,
  "limite": 10.0,
  "fecha": "2026-04-10T10:30:00",
  "estado": "ACTIVA"
}
```

---

### PUT /api/alertas/{id}

```json
{
  "vehiculoId": "CAM-001",
  "tipoAlerta": "TEMPERATURA_ALTA",
  "valor": 9.0,
  "limite": 10.0,
  "fecha": "2026-04-10T11:00:00",
  "estado": "RESUELTA"
}
```

---

### GET /api/alertas

```
/api/alertas?page=0&size=5
```

---

## Telemetría

### POST /api/telemetria

```json
{
  "vehiculoId": "CAM-001",
  "fecha": "2026-05-24T10:30:00Z",
  "latitud": 13.6929,
  "longitud": -89.2182,
  "velocidad": 65.5,
  "combustible": 78.0,
  "temperaturaMotor": 86.4
}
```

### GET /api/telemetria/{vehiculoId}

```text
/api/telemetria/CAM-001
```

### GET /api/telemetria/{vehiculoId}/rango

```text
/api/telemetria/vehiculo/6a1347c6a33fd2659a3a2689/rango?desde=2026-05-21T18%3A52%3A31.715Z&hasta=2026-05-24T18%3A52%3A31.715Z
```

---

## Paginación

Todos los endpoints soportan:

```text
?page=0&size=10&sort=campo,asc
```

Ejemplo:

```text
GET /api/vehiculos?page=0&size=5&sort=placa,asc
```

---

## Backups de MongoDB

Para MongoDB se utilizó la herramienta oficial `mongodump`.

### Verificar instalación

```bash
mongodump --version
```

### Crear backup manual

```bash
mongodump --db logitracksv --out C:\backup-mongo
```

El backup queda almacenado en:

```text
C:\backup-mongo\logitracksv
```

### Restaurar backup

```bash
mongorestore --db logitracksv C:\backup-mongo\logitracksv
```

### Script de backup

También se creó un script `.bat` para ejecutar el backup de forma rápida:

```bat
@echo off
mongodump --db logitracksv --out C:\backup-mongo
echo Backup completado
pause
```

---

## Backups de Cassandra

Para Cassandra se utilizó `nodetool snapshot`, ejecutado dentro del contenedor `cassandra-seed`.

### Crear snapshot del keyspace

```bash
docker exec -it cassandra-seed nodetool snapshot logitracksv
```

### Buscar ubicación de snapshots

```bash
docker exec -it cassandra-seed find /var/lib/cassandra/data -name snapshots
```

### Copiar backup a la computadora local

```bash
docker cp cassandra-seed:/var/lib/cassandra/data C:\backup-cassandra
```

### Limpiar snapshots antiguos

```bash
docker exec -it cassandra-seed nodetool clearsnapshot
```

---

## Software de terceros para backups de Cassandra

Se investigó e instaló Medusa como herramienta externa de respaldo para Cassandra.

### Crear entorno virtual con Python 3.11

```bash
py -3.11 -m venv medusa-env
```

### Activar entorno virtual

```bash
medusa-env\Scripts\activate
```

### Actualizar herramientas base

```bash
python -m pip install --upgrade pip setuptools wheel
```

### Instalar Medusa

```bash
pip install cassandra-medusa
```

### Verificar instalación

```bash
medusa --help
```

### Configuración básica de Medusa

Ejemplo de archivo `medusa.ini`:

```ini
[storage]
storage_provider = local

[storage.local]
base_path = C:\medusa-backups

[cassandra]
config_file = C:\medusa-backups\cassandra.yaml
```

### Nota sobre Medusa en este proyecto

Medusa está diseñado principalmente para instalaciones de Cassandra en Linux con acceso directo al sistema de archivos de Cassandra. En este proyecto, Cassandra se ejecuta dentro de contenedores Docker sobre Windows, por lo que el backup físico funcional se realiza con `nodetool snapshot` y se extrae al host mediante `docker cp`.

Medusa se mantiene como herramienta externa investigada, instalada y configurada para escenarios productivos.

---

## Diseño de Datos

El sistema utiliza un enfoque de desnormalización controlada en MongoDB:

* Referencias mediante IDs
* Datos embebidos (snapshot) para optimizar lecturas
* Eliminación de joins para mejorar rendimiento

Ejemplo:
Las rutas contienen información del cliente, vehículo y conductor embebida.

---

## Buenas prácticas implementadas

* Uso de DTOs para no exponer entidades
* Separación clara de capas
* Uso de mappers para transformación de datos
* Paginación en consultas
* Filtros por campos clave
* Arquitectura escalable y mantenible

---

## Documentación de API

Swagger está disponible en:

```
http://localhost:8080/swagger-ui/index.html
```

Permite:

* Visualizar endpoints
* Probar peticiones
* Ver modelos de datos

---

## Integrantes

* Diego Enrique Arguera Canjura
* Irvin Alejandro Arguera Canjura
* Elisa Gabriela Giron Nolasco
* Rodrigo Ernesto Guerrero Bonilla
