# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/ClientJpaEntity.java` — `CreditRequestJpaEntity.setClient`: Se invoca `setClient` sobre `CreditRequestJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/CreditRequestJpaEntity.java` — `RiskEvaluationJpaEntity.setCreditRequest`: Se invoca `setCreditRequest` sobre `RiskEvaluationJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.clientId`: Se invoca `clientId` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.id`: Se invoca `id` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.amount`: Se invoca `amount` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.termMonths`: Se invoca `termMonths` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.purpose`: Se invoca `purpose` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.requestDate`: Se invoca `requestDate` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.interestRate`: Se invoca `interestRate` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `Client.hasNegativeCreditHistory`: Se invoca `hasNegativeCreditHistory` sobre `Client`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Client.id`: Se invoca `id` sobre `Client`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequest.id`: Se invoca `id` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.id`: Se invoca `id` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.evaluateCreditRequest`: Se invoca `evaluateCreditRequest` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.riskLevel`: Se invoca `riskLevel` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.makeDecision`: Se invoca `makeDecision` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.decisionType`: Se invoca `decisionType` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.calculateMonthlyPayment`: Se invoca `calculateMonthlyPayment` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.getCreditRequestById`: Se invoca `getCreditRequestById` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.isPresent`: Se invoca `isPresent` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.get`: Se invoca `get` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.getCreditRequestsByClientId`: Se invoca `getCreditRequestsByClientId` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.size`: Se invoca `size` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.getDocumentNumber`: Se invoca `getDocumentNumber` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.isPresent`: Se invoca `isPresent` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.get`: Se invoca `get` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.setDocumentNumber`: Se invoca `setDocumentNumber` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaAdapter.findByDocumentNumber`: Se invoca `findByDocumentNumber` sobre `ClientJpaAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaAdapter.existsByDocumentNumber`: Se invoca `existsByDocumentNumber` sobre `ClientJpaAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.size`: Se invoca `size` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.setDocumentType`: Se invoca `setDocumentType` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior

### Brecha de conocimiento
Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación

### Misión / candidato
Candidato con experiencia en Backend Java a nivel Senior.

### Reto
- Tema: Diseño e Implementación de un Modelo de Datos Normalizado
- Seniority: senior-l2
- Tipo: practical
- Título: Normalización de Modelo de Datos para Sistema de Créditos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Identificación de Entidades y Atributos — objetivo: Identificar las entidades principales y sus atributos en el dominio de créditos. — entregable (NO resolver): Lista de entidades y atributos con relaciones identificadas.
- Fase 2: Aplicación de Formas Normales — objetivo: Aplicar las formas normales al modelo de datos para eliminar redundancias y asegurar la integridad. — entregable (NO resolver): Modelo de datos normalizado siguiendo las formas normales 1NF, 2NF y 3NF.
- Fase 3: Modelo Entidad-Relación — objetivo: Crear un modelo Entidad-Relación que represente las relaciones entre las entidades normalizadas. — entregable (NO resolver): Diagrama Entidad-Relación (ERD) del modelo de datos normalizado.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>credits</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>credits</name>
    <description>Sistema de gestión de créditos con modelo de datos normalizado</description>

    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-core</artifactId>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>

        <!-- ModelMapper -->
        <dependency>
            <groupId>org.modelmapper</groupId>
            <artifactId>modelmapper</artifactId>
            <version>3.2.0</version>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/credits/Application.java ===
package com.pragma.credits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pragma.credits"})
@EnableConfigurationProperties
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
              .setFieldMatchingEnabled(true)
              .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        return mapper;
    }

    @Bean
    public String applicationInfo() {
        return "Sistema de Gestión de Créditos - Versión 1.0.0";
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: credits

  datasource:
    url: jdbc:postgresql://localhost:5432/credits_db
    username: credits_user
    password: credits_password
    driver-class-name: org.postgresql.Driver
    hikari:
      connection-timeout: 30000
      maximum-pool-size: 10
      minimum-idle: 5
      idle-timeout: 600000
      max-lifetime: 1800000

  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect

  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true
    validate-on-migrate: true

server:
  port: 8080
  servlet:
    context-path: /api/credits

logging:
  level:
    root: INFO
    com.pragma.credits: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: always

// === ARCHIVO: src/main/java/com/pragma/credits/domain/model/Client.java ===
package com.pragma.credits.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad de dominio que representa a un cliente.
 * Contiene atributos normalizados y validaciones de negocio.
 */
public record Client(
    @NotNull(message = "El ID del cliente no puede ser nulo")
    UUID id,

    @NotBlank(message = "El nombre completo no puede estar vacío")
    @Size(max = 100, message = "El nombre completo no puede exceder los 100 caracteres")
    String fullName,

    @NotBlank(message = "El número de identificación no puede estar vacío")
    @Pattern(regexp = "^[0-9]{6,20}$", message = "El número de identificación debe ser numérico y tener entre 6 y 20 dígitos")
    String identificationNumber,

    @NotBlank(message = "El tipo de identificación no puede estar vacío")
    @Size(min = 2, max = 10, message = "El tipo de identificación debe tener entre 2 y 10 caracteres")
    String identificationType,

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    LocalDate birthDate,

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El formato del correo electrónico es inválido")
    String email,

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 200, message = "La dirección no puede exceder los 200 caracteres")
    String address,

    @NotBlank(message = "El número de teléfono no puede estar vacío")
    @Pattern(regexp = "^\\+[0-9]{10,15}$", message = "El número de teléfono debe incluir código de país y tener entre 10 y 15 dígitos")
    String phoneNumber,

    @NotBlank(message = "El estado civil no puede estar vacío")
    @Size(max = 20, message = "El estado civil no puede exceder los 20 caracteres")
    String maritalStatus
) {
    /**
     * Valida las invariantes del cliente.
     * @throws IllegalArgumentException si alguna validación falla.
     */
    public void validate() {
        if (birthDate != null && birthDate.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("El cliente debe ser mayor de 18 años");
        }
        if (identificationNumber != null && !identificationNumber.matches("^[0-9]{6,20}$")) {
            throw new IllegalArgumentException("El número de identificación debe ser numérico y tener entre 6 y 20 dígitos");
        }
        if (email != null && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("El formato del correo electrónico es inválido");
        }
    }

    /**
     * Calcula la edad del cliente basada en su fecha de nacimiento.
     * @return la edad en años.
     */
    public int calculateAge() {
        if (birthDate == null) {
            throw new IllegalStateException("La fecha de nacimiento no puede ser nula");
        }
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/domain/model/CreditRequest.java ===
package com.pragma.credits.domain.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad de dominio que representa una solicitud de crédito.
 * Contiene atributos normalizados y validaciones de negocio.
 */
public record CreditRequest(
    @NotNull(message = "El ID de la solicitud no puede ser nulo")
    UUID id,

    @NotNull(message = "El ID del cliente no puede ser nulo")
    UUID clientId,

    @NotNull(message = "El monto solicitado no puede ser nulo")
    @DecimalMin(value = "100.00", message = "El monto solicitado debe ser al menos 100")
    BigDecimal requestedAmount,

    @NotNull(message = "El plazo en meses no puede ser nulo")
    @Positive(message = "El plazo en meses debe ser positivo")
    Integer termMonths,

    @NotBlank(message = "El propósito del crédito no puede estar vacío")
    @Size(max = 100, message = "El propósito del crédito no puede exceder los 100 caracteres")
    String purpose,

    @NotBlank(message = "El estado de la solicitud no puede estar vacío")
    @Size(max = 20, message = "El estado de la solicitud no puede exceder los 20 caracteres")
    String status,

    @NotNull(message = "La fecha de solicitud no puede ser nula")
    @PastOrPresent(message = "La fecha de solicitud no puede ser futura")
    LocalDate requestDate,

    @NotNull(message = "La fecha de decisión no puede ser nula si el estado es aprobado o rechazado")
    LocalDate decisionDate
) {
    /**
     * Valida las invariantes de la solicitud de crédito.
     * @throws IllegalArgumentException si alguna validación falla.
     */
    public void validate() {
        if (requestedAmount != null && requestedAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto solicitado debe ser positivo");
        }
        if (termMonths != null && termMonths <= 0) {
            throw new IllegalArgumentException("El plazo en meses debe ser positivo");
        }
        if (status != null && !status.matches("^(PENDIENTE|EN_EVALUACION|APROBADO|RECHAZADO)$")) {
            throw new IllegalArgumentException("El estado de la solicitud debe ser uno de: PENDIENTE, EN_EVALUACION, APROBADO, RECHAZADO");
        }
        if ((status != null && (status.equals("APROBADO") || status.equals("RECHAZADO"))) && decisionDate == null) {
            throw new IllegalArgumentException("La fecha de decisión es obligatoria si el estado es APROBADO o RECHAZADO");
        }
    }

    /**
     * Calcula el monto de la cuota mensual basado en el monto solicitado y el plazo.
     * @param interestRate tasa de interés anual.
     * @return el monto de la cuota mensual.
     */
    public BigDecimal calculateMonthlyPayment(BigDecimal interestRate) {
        if (requestedAmount == null || termMonths == null) {
            throw new IllegalStateException("El monto solicitado y el plazo en meses no pueden ser nulos");
        }
        if (interestRate == null || interestRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La tasa de interés debe ser positiva");
        }
        BigDecimal monthlyRate = interestRate.divide(BigDecimal.valueOf(12), 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal denominator = BigDecimal.ONE.subtract(BigDecimal.ONE.divide(
            BigDecimal.ONE.add(monthlyRate).pow(termMonths), 10, BigDecimal.ROUND_HALF_UP
        ));
        return requestedAmount.multiply(monthlyRate).divide(denominator, 2, BigDecimal.ROUND_HALF_UP);
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/domain/model/RiskEvaluation.java ===
package com.pragma.credits.domain.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad de dominio que representa una evaluación de riesgo para una solicitud de crédito.
 * Contiene atributos normalizados y validaciones de negocio.
 */
public record RiskEvaluation(
    @NotNull(message = "El ID de la evaluación de riesgo no puede ser nulo")
    UUID id,

    @NotNull(message = "El ID de la solicitud de crédito no puede ser nulo")
    UUID creditRequestId,

    @NotNull(message = "La puntuación de riesgo no puede ser nula")
    @DecimalMin(value = "0.0", message = "La puntuación de riesgo debe ser al menos 0")
    @DecimalMax(value = "100.0", message = "La puntuación de riesgo no puede exceder 100")
    BigDecimal riskScore,

    @NotBlank(message = "El nivel de riesgo no puede estar vacío")
    @Size(max = 20, message = "El nivel de riesgo no puede exceder los 20 caracteres")
    String riskLevel,

    @NotBlank(message = "El detalle de la evaluación no puede estar vacío")
    @Size(max = 500, message = "El detalle de la evaluación no puede exceder los 500 caracteres")
    String evaluationDetails,

    @NotNull(message = "La fecha de evaluación no puede ser nula")
    @PastOrPresent(message = "La fecha de evaluación no puede ser futura")
    LocalDate evaluationDate,

    @NotBlank(message = "El método de evaluación no puede estar vacío")
    @Size(max = 50, message = "El método de evaluación no puede exceder los 50 caracteres")
    String evaluationMethod
) {
    /**
     * Valida las invariantes de la evaluación de riesgo.
     * @throws IllegalArgumentException si alguna validación falla.
     */
    public void validate() {
        if (riskScore != null && (riskScore.compareTo(BigDecimal.ZERO) < 0 || riskScore.compareTo(BigDecimal.valueOf(100)) > 0)) {
            throw new IllegalArgumentException("La puntuación de riesgo debe estar entre 0 y 100");
        }
        if (riskLevel != null && !riskLevel.matches("^(BAJO|MEDIO|ALTO|CRITICO)$")) {
            throw new IllegalArgumentException("El nivel de riesgo debe ser uno de: BAJO, MEDIO, ALTO, CRITICO");
        }
        if (evaluationMethod != null && !evaluationMethod.matches("^(AUTOMATICO|MANUAL|HIBRIDO)$")) {
            throw new IllegalArgumentException("El método de evaluación debe ser uno de: AUTOMATICO, MANUAL, HIBRIDO");
        }
    }

    /**
     * Determina si la evaluación de riesgo aprueba la solicitud.
     * @return true si la solicitud es aprobada, false en caso contrario.
     */
    public boolean isApproved() {
        if (riskScore == null || riskLevel == null) {
            throw new IllegalStateException("La puntuación y el nivel de riesgo no pueden ser nulos");
        }
        return riskScore.compareTo(BigDecimal.valueOf(50)) >= 0 && !riskLevel.equals("ALTO") && !riskLevel.equals("CRITICO");
    }

    /**
     * Genera un resumen de la evaluación de riesgo.
     * @return un string con el resumen de la evaluación.
     */
    public String generateEvaluationSummary() {
        return String.format("Evaluación de riesgo para solicitud %s: puntuación %.2f (%s), método %s",
                creditRequestId, riskScore, riskLevel, evaluationMethod);
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/domain/model/Decision.java ===
package com.pragma.credits.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Decision(
    UUID id,
    UUID creditRequestId,
    String decisionType,
    String status,
    BigDecimal approvedAmount,
    BigDecimal interestRate,
    Integer termInMonths,
    String reason,
    LocalDateTime decidedAt,
    String decidedBy
) {
    public Decision {
        if (id == null) {
            throw new IllegalArgumentException("El identificador de la decisión no puede ser nulo");
        }
        if (creditRequestId == null) {
            throw new IllegalArgumentException("El identificador de la solicitud de crédito no puede ser nulo");
        }
        if (decisionType == null || decisionType.isBlank()) {
            throw new IllegalArgumentException("El tipo de decisión no puede estar vacío");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("El estado de la decisión no puede estar vacío");
        }
    }

    public void validate() {
        validateDecisionType();
        validateStatus();
        validateApprovedAmount();
        validateInterestRate();
        validateTermInMonths();
    }

    private void validateDecisionType() {
        if (!isValidDecisionType(decisionType)) {
            throw new IllegalArgumentException(
                "Tipo de decisión inválido. Valores permitidos: APPROVED, REJECTED, CONDITIONAL"
            );
        }
    }

    private boolean isValidDecisionType(String type) {
        return "APPROVED".equals(type) || "REJECTED".equals(type) || "CONDITIONAL".equals(type);
    }

    private void validateStatus() {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException(
                "Estado inválido. Valores permitidos: PENDING, FINAL, APPEALED"
            );
        }
    }

    private boolean isValidStatus(String statusValue) {
        return "PENDING".equals(statusValue) || "FINAL".equals(statusValue) || "APPEALED".equals(statusValue);
    }

    private void validateApprovedAmount() {
        if ("APPROVED".equals(decisionType) || "CONDITIONAL".equals(decisionType)) {
            if (approvedAmount == null) {
                throw new IllegalArgumentException("El monto aprobado es obligatorio para decisiones aprobadas o condicionales");
            }
            if (approvedAmount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("El monto aprobado debe ser mayor que cero");
            }
            if (approvedAmount.compareTo(new BigDecimal("1000000")) > 0) {
                throw new IllegalArgumentException("El monto aprobado no puede exceder el límite máximo permitido");
            }
        }
    }

    private void validateInterestRate() {
        if ("APPROVED".equals(decisionType) || "CONDITIONAL".equals(decisionType)) {
            if (interestRate == null) {
                throw new IllegalArgumentException("La tasa de interés es obligatoria para decisiones aprobadas o condicionales");
            }
            if (interestRate.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("La tasa de interés debe ser mayor que cero");
            }
            if (interestRate.compareTo(new BigDecimal("1.0")) > 0) {
                throw new IllegalArgumentException("La tasa de interés no puede exceder el 100%");
            }
        }
    }

    private void validateTermInMonths() {
        if ("APPROVED".equals(decisionType) || "CONDITIONAL".equals(decisionType)) {
            if (termInMonths == null) {
                throw new IllegalArgumentException("El plazo en meses es obligatorio para decisiones aprobadas o condicionales");
            }
            if (termInMonths <= 0) {
                throw new IllegalArgumentException("El plazo en meses debe ser mayor que cero");
            }
            if (termInMonths > 360) {
                throw new IllegalArgumentException("El plazo no puede exceder 360 meses (30 años)");
            }
        }
    }

    public boolean isApproved() {
        return "APPROVED".equals(decisionType) && "FINAL".equals(status);
    }

    public boolean isRejected() {
        return "REJECTED".equals(decisionType);
    }

    public boolean isConditional() {
        return "CONDITIONAL".equals(decisionType);
    }

    public boolean isPending() {
        return "PENDING".equals(status);
    }

    public boolean isFinal() {
        return "FINAL".equals(status);
    }

    public BigDecimal calculateMonthlyPayment() {
        if (!isApproved() && !isConditional()) {
            throw new IllegalStateException("Solo se puede calcular cuota para decisiones aprobadas o condicionales");
        }
        if (approvedAmount == null || interestRate == null || termInMonths == null) {
            throw new IllegalStateException("Faltan datos para calcular la cuota mensual");
        }
        BigDecimal monthlyRate = interestRate.divide(new BigDecimal("12"), 10, java.math.RoundingMode.HALF_UP);
        BigDecimal factor = monthlyRate.add(BigDecimal.ONE).pow(termInMonths);
        BigDecimal numerator = monthlyRate.multiply(factor);
        BigDecimal denominator = factor.subtract(BigDecimal.ONE);
        return approvedAmount.multiply(numerator).divide(denominator, 2, java.math.RoundingMode.HALF_UP);
    }

    public String generateDecisionSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Decisión: ").append(decisionType).append("\n");
        summary.append("Estado: ").append(status).append("\n");
        if (approvedAmount != null) {
            summary.append("Monto aprobado: $").append(approvedAmount).append("\n");
        }
        if (interestRate != null) {
            summary.append("Tasa de interés: ").append(interestRate.multiply(new BigDecimal("100"))).append("%\n");
        }
        if (termInMonths != null) {
            summary.append("Plazo: ").append(termInMonths).append(" meses\n");
        }
        if (reason != null && !reason.isBlank()) {
            summary.append("Motivo: ").append(reason).append("\n");
        }
        if (decidedAt != null) {
            summary.append("Fecha: ").append(decidedAt).append("\n");
        }
        if (decidedBy != null && !decidedBy.isBlank()) {
            summary.append("Decidido por: ").append(decidedBy).append("\n");
        }
        return summary.toString();
    }

    public Decision withStatus(String newStatus) {
        return new Decision(
            this.id,
            this.creditRequestId,
            this.decisionType,
            newStatus,
            this.approvedAmount,
            this.interestRate,
            this.termInMonths,
            this.reason,
            this.decidedAt,
            this.decidedBy
        );
    }

    public Decision withApprovedAmount(BigDecimal newAmount) {
        return new Decision(
            this.id,
            this.creditRequestId,
            this.decisionType,
            this.status,
            newAmount,
            this.interestRate,
            this.termInMonths,
            this.reason,
            this.decidedAt,
            this.decidedBy
        );
    }

    public static Decision createPendingDecision(UUID creditRequestId) {
        return new Decision(
            UUID.randomUUID(),
            creditRequestId,
            "PENDING",
            "PENDING",
            null,
            null,
            null,
            "Awaiting revisión",
            null,
            null
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/domain/ports/ClientRepository.java ===
package com.pragma.credits.domain.ports;

import com.pragma.credits.domain.model.Client;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    
    Optional<Client> findById(UUID id);
    
    Optional<Client> findByIdentificationNumber(String identificationNumber);
    
    List<Client> findAll();
    
    List<Client> findByStatus(String status);
    
    List<Client> findByAgeBetween(int minAge, int maxAge);
    
    List<Client> findByIncomeGreaterThanEqual(java.math.BigDecimal minimumIncome);
    
    boolean existsByIdentificationNumber(String identificationNumber);
    
    boolean existsByEmail(String email);
    
    Client save(Client client);
    
    void deleteById(UUID id);
    
    long count();
    
    long countByStatus(String status);
}

// === ARCHIVO: src/main/java/com/pragma/credits/domain/ports/CreditRequestRepository.java ===
package com.pragma.credits.domain.ports;

import com.pragma.credits.domain.model.CreditRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CreditRequestRepository {
    
    Optional<CreditRequest> findById(UUID id);
    
    List<CreditRequest> findAll();
    
    List<CreditRequest> findByClientId(UUID clientId);
    
    List<CreditRequest> findByStatus(String status);
    
    List<CreditRequest> findByStatusAndCreatedAtAfter(String status, LocalDateTime date);
    
    List<CreditRequest> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount);
    
    List<CreditRequest> findByClientIdAndStatus(UUID clientId, String status);
    
    boolean existsByClientIdAndStatus(UUID clientId, String status);
    
    boolean existsByClientIdAndStatusIn(UUID clientId, List<String> statuses);
    
    CreditRequest save(CreditRequest creditRequest);
    
    void deleteById(UUID id);
    
    long count();
    
    long countByStatus(String status);
    
    long countByClientId(UUID clientId);
}

// === ARCHIVO: src/main/java/com/pragma/credits/domain/ports/RiskEvaluationRepository.java ===
package com.pragma.credits.domain.ports;

import com.pragma.credits.domain.model.RiskEvaluation;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RiskEvaluationRepository {
    
    RiskEvaluation save(RiskEvaluation riskEvaluation);
    
    Optional<RiskEvaluation> findById(UUID id);
    
    List<RiskEvaluation> findAll();
    
    List<RiskEvaluation> findByCreditRequestId(UUID creditRequestId);
    
    void deleteById(UUID id);
    
    boolean existsById(UUID id);
}

// === ARCHIVO: src/main/java/com/pragma/credits/domain/ports/DecisionRepository.java ===
package com.pragma.credits.domain.ports;

import com.pragma.credits.domain.model.Decision;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DecisionRepository {
    
    Decision save(Decision decision);
    
    Optional<Decision> findById(UUID id);
    
    List<Decision> findAll();
    
    List<Decision> findByCreditRequestId(UUID creditRequestId);
    
    Optional<Decision> findTopByCreditRequestIdOrderByDecisionDateDesc(UUID creditRequestId);
    
    void deleteById(UUID id);
    
    boolean existsById(UUID id);
    
    long countByCreditRequestId(UUID creditRequestId);
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/ClientJpaEntity.java ===
package com.pragma.credits.infrastructure.adapters.jpa.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients", indexes = {
    @Index(name = "idx_client_identification", columnList = "identification_number", unique = true),
    @Index(name = "idx_client_email", columnList = "email", unique = true)
})
public class ClientJpaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "identification_number", nullable = false, unique = true, length = 50)
    private String identificationNumber;
    
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    
    @Column(name = "monthly_income", nullable = false, precision = 15, scale = 2)
    private BigDecimal monthlyIncome;
    
    @Column(name = "credit_score", nullable = false)
    private Integer creditScore;
    
    @Column(name = "employment_type", length = 50)
    private String employmentType;
    
    @Column(name = "employer_name", length = 200)
    private String employerName;
    
    @Column(name = "years_at_job", precision = 5, scale = 2)
    private BigDecimal yearsAtJob;
    
    @Column(name = "total_debt", precision = 15, scale = 2)
    private BigDecimal totalDebt;
    
    @Column(name = "has_foreclosures", nullable = false)
    private Boolean hasForeclosures;
    
    @Column(name = "has_bankruptcy", nullable = false)
    private Boolean hasBankruptcy;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @Version
    @Column(name = "version")
    private Long version;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CreditRequestJpaEntity> creditRequests = new ArrayList<>();
    
    public ClientJpaEntity() {
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getIdentificationNumber() {
        return identificationNumber;
    }
    
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }
    
    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    
    public Integer getCreditScore() {
        return creditScore;
    }
    
    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }
    
    public String getEmploymentType() {
        return employmentType;
    }
    
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }
    
    public String getEmployerName() {
        return employerName;
    }
    
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    public BigDecimal getYearsAtJob() {
        return yearsAtJob;
    }
    
    public void setYearsAtJob(BigDecimal yearsAtJob) {
        this.yearsAtJob = yearsAtJob;
    }
    
    public BigDecimal getTotalDebt() {
        return totalDebt;
    }
    
    public void setTotalDebt(BigDecimal totalDebt) {
        this.totalDebt = totalDebt;
    }
    
    public Boolean getHasForeclosures() {
        return hasForeclosures;
    }
    
    public void setHasForeclosures(Boolean hasForeclosures) {
        this.hasForeclosures = hasForeclosures;
    }
    
    public Boolean getHasBankruptcy() {
        return hasBankruptcy;
    }
    
    public void setHasBankruptcy(Boolean hasBankruptcy) {
        this.hasBankruptcy = hasBankruptcy;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    public List<CreditRequestJpaEntity> getCreditRequests() {
        return creditRequests;
    }
    
    public void setCreditRequests(List<CreditRequestJpaEntity> creditRequests) {
        this.creditRequests = creditRequests;
    }
    
    public void addCreditRequest(CreditRequestJpaEntity creditRequest) {
        creditRequests.add(creditRequest);
        creditRequest.setClient(this);
    }
    
    public void removeCreditRequest(CreditRequestJpaEntity creditRequest) {
        creditRequests.remove(creditRequest);
        creditRequest.setClient(null);
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/CreditRequestJpaEntity.java ===
package com.pragma.credits.infrastructure.adapters.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "credit_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditRequestJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private ClientJpaEntity client;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false, length = 3)
    @Builder.Default
    private String currency = "USD";

    @Column(name = "term_months", nullable = false)
    private Integer termMonths;

    @Column(name = "interest_rate", nullable = false, precision = 5, scale = 4)
    private BigDecimal interestRate;

    @Column(name = "purpose", length = 500)
    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    @Builder.Default
    private CreditRequestStatus status = CreditRequestStatus.PENDING;

    @Column(name = "requested_at", nullable = false)
    @Builder.Default
    private LocalDate requestedAt = LocalDate.now();

    @Column(name = "processed_at")
    private LocalDate processedAt;

    @Column(name = "monthly_payment", precision = 19, scale = 4)
    private BigDecimal monthlyPayment;

    @OneToMany(mappedBy = "creditRequest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<RiskEvaluationJpaEntity> riskEvaluations = new ArrayList<>();

    @OneToOne(mappedBy = "creditRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DecisionJpaEntity decision;

    public void addRiskEvaluation(RiskEvaluationJpaEntity evaluation) {
        riskEvaluations.add(evaluation);
        evaluation.setCreditRequest(this);
    }

    public void removeRiskEvaluation(RiskEvaluationJpaEntity evaluation) {
        riskEvaluations.remove(evaluation);
        evaluation.setCreditRequest(null);
    }

    public void calculateMonthlyPayment() {
        if (amount != null && interestRate != null && termMonths != null && termMonths > 0) {
            BigDecimal monthlyRate = interestRate.divide(BigDecimal.valueOf(12), 8, java.math.RoundingMode.HALF_UP);
            BigDecimal factor = monthlyRate.add(BigDecimal.ONE).pow(termMonths);
            BigDecimal factorMinusOne = factor.subtract(BigDecimal.ONE);
            monthlyPayment = amount.multiply(monthlyRate).multiply(factor).divide(factorMinusOne, 4, java.math.RoundingMode.HALF_UP);
        }
    }

    public enum CreditRequestStatus {
        PENDING,
        UNDER_REVIEW,
        APPROVED,
        REJECTED,
        CANCELLED
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/RiskEvaluationJpaEntity.java ===
package com.pragma.credits.infrastructure.adapters.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "risk_evaluations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskEvaluationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "credit_request_id", nullable = false)
    private UUID creditRequestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_request_id", insertable = false, updatable = false)
    private CreditRequestJpaEntity creditRequest;

    @Column(name = "evaluation_date", nullable = false)
    @Builder.Default
    private LocalDate evaluationDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "evaluation_type", nullable = false, length = 50)
    private EvaluationType evaluationType;

    @Column(name = "score", precision = 5, scale = 2)
    private BigDecimal score;

    @Enumerated(EnumType.STRING)
    @Column(name = "risk_level", nullable = false, length = 20)
    private RiskLevel riskLevel;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "evaluated_by", length = 100)
    private String evaluatedBy;

    @Column(name = "model_version", length = 50)
    private String modelVersion;

    @Column(name = "confidence_score", precision = 5, scale = 2)
    private BigDecimal confidenceScore;

    @Column(name = "recommendation", length = 500)
    private String recommendation;

    public boolean isApproved() {
        return Boolean.TRUE.equals(isApproved);
    }

    public String generateEvaluationSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Evaluación de Riesgo - ").append(evaluationDate).append("\n");
        summary.append("Tipo: ").append(evaluationType).append("\n");
        summary.append("Nivel de Riesgo: ").append(riskLevel).append("\n");
        if (score != null) {
            summary.append("Puntuación: ").append(score).append("\n");
        }
        if (recommendation != null) {
            summary.append("Recomendación: ").append(recommendation).append("\n");
        }
        return summary.toString();
    }

    public enum EvaluationType {
        CREDIT_HISTORY,
        INCOME_VERIFICATION,
        DEBT_TO_INCOME,
        EMPLOYMENT_VERIFICATION,
        COLLATERAL,
        OVERALL_RISK
    }

    public enum RiskLevel {
        LOW,
        MEDIUM,
        HIGH,
        VERY_HIGH,
        UNKNOWN
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/DecisionJpaEntity.java ===
package com.pragma.credits.infrastructure.adapters.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "decisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DecisionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "credit_request_id", nullable = false, unique = true)
    private UUID creditRequestId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_request_id", insertable = false, updatable = false)
    private CreditRequestJpaEntity creditRequest;

    @Column(name = "decision_date", nullable = false)
    @Builder.Default
    private LocalDate decisionDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "decision_type", nullable = false, length = 20)
    private DecisionType decisionType;

    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved;

    @Column(name = "amount_approved", precision = 19, scale = 4)
    private BigDecimal amountApproved;

    @Column(name = "interest_rate_approved", precision = 5, scale = 4)
    private BigDecimal interestRateApproved;

    @Column(name = "term_months_approved")
    private Integer termMonthsApproved;

    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;

    @Column(name = "reviewer_id", length = 100)
    private String reviewerId;

    @Column(name = "reviewer_name", length = 200)
    private String reviewerName;

    @Column(name = "approved_at")
    private LocalDate approvedAt;

    @Column(name = "rejected_at")
    private LocalDate rejectedAt;

    @Column(name = "conditions", columnDefinition = "TEXT")
    private String conditions;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    public enum DecisionType {
        AUTO_APPROVED,
        MANUAL_APPROVED,
        AUTO_REJECTED,
        MANUAL_REJECTED,
        PENDING_REVIEW,
        CONDITIONAL_APPROVAL
    }

    public boolean isApproved() {
        return Boolean.TRUE.equals(isApproved);
    }

    public boolean isRejected() {
        return Boolean.FALSE.equals(isApproved);
    }

    public boolean isConditional() {
        return DecisionType.CONDITIONAL_APPROVAL.equals(decisionType);
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/application/CreditRequestService.java ===
package com.pragma.credits.application;

import com.pragma.credits.domain.model.Client;
import com.pragma.credits.domain.model.CreditRequest;
import com.pragma.credits.domain.model.RiskEvaluation;
import com.pragma.credits.domain.model.Decision;
import com.pragma.credits.domain.ports.ClientRepository;
import com.pragma.credits.domain.ports.CreditRequestRepository;
import com.pragma.credits.domain.ports.RiskEvaluationRepository;
import com.pragma.credits.domain.ports.DecisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CreditRequestService {

    private final ClientRepository clientRepository;
    private final CreditRequestRepository creditRequestRepository;
    private final RiskEvaluationRepository riskEvaluationRepository;
    private final DecisionRepository decisionRepository;

    public CreditRequestService(
            ClientRepository clientRepository,
            CreditRequestRepository creditRequestRepository,
            RiskEvaluationRepository riskEvaluationRepository,
            DecisionRepository decisionRepository) {
        this.clientRepository = clientRepository;
        this.creditRequestRepository = creditRequestRepository;
        this.riskEvaluationRepository = riskEvaluationRepository;
        this.decisionRepository = decisionRepository;
    }

    public CreditRequest createCreditRequest(CreditRequest creditRequest) {
        creditRequest.validate();
        
        Optional<Client> existingClient = clientRepository.findById(creditRequest.clientId());
        if (existingClient.isEmpty()) {
            throw new IllegalArgumentException("El cliente no existe en el sistema");
        }
        
        Client client = existingClient.get();
        if (!isClientEligible(client)) {
            throw new IllegalStateException("El cliente no cumple los requisitos para solicitar un crédito");
        }
        
        CreditRequest savedRequest = creditRequestRepository.save(creditRequest);
        
        RiskEvaluation initialEvaluation = createInitialRiskEvaluation(savedRequest.id(), client);
        riskEvaluationRepository.save(initialEvaluation);
        
        return savedRequest;
    }

    public Optional<CreditRequest> findCreditRequestById(UUID id) {
        return creditRequestRepository.findById(id);
    }

    public List<CreditRequest> findCreditRequestsByClientId(UUID clientId) {
        return creditRequestRepository.findByClientId(clientId);
    }

    public List<CreditRequest> findAllCreditRequests() {
        return creditRequestRepository.findAll();
    }

    public CreditRequest updateCreditRequestStatus(UUID requestId, String newStatus) {
        Optional<CreditRequest> existingRequest = creditRequestRepository.findById(requestId);
        if (existingRequest.isEmpty()) {
            throw new IllegalArgumentException("Solicitud de crédito no encontrada");
        }
        
        CreditRequest currentRequest = existingRequest.get();
        CreditRequest updatedRequest = new CreditRequest(
            currentRequest.id(),
            currentRequest.clientId(),
            currentRequest.amount(),
            currentRequest.termMonths(),
            currentRequest.purpose(),
            newStatus,
            currentRequest.requestDate(),
            currentRequest.interestRate()
        );
        
        return creditRequestRepository.save(updatedRequest);
    }

    public RiskEvaluation evaluateRisk(UUID creditRequestId, BigDecimal income, BigDecimal expenses) {
        Optional<CreditRequest> requestOpt = creditRequestRepository.findById(creditRequestId);
        if (requestOpt.isEmpty()) {
            throw new IllegalArgumentException("Solicitud de crédito no encontrada");
        }
        
        CreditRequest request = requestOpt.get();
        Optional<Client> clientOpt = clientRepository.findById(request.clientId());
        if (clientOpt.isEmpty()) {
            throw new IllegalStateException("Cliente asociado no encontrado");
        }
        
        Client client = clientOpt.get();
        BigDecimal requestedAmount = request.amount();
        int termMonths = request.termMonths();
        
        BigDecimal debtToIncomeRatio = calculateDebtToIncomeRatio(requestedAmount, termMonths, income);
        boolean hasNegativeHistory = client.hasNegativeCreditHistory();
        boolean incomeSufficient = income.compareTo(requestedAmount.multiply(BigDecimal.valueOf(0.3))) > 0;
        
        boolean approved = debtToIncomeRatio.compareTo(BigDecimal.valueOf(0.4)) < 0
                && !hasNegativeHistory
                && incomeSufficient;
        
        String evaluationDetails = String.format(
            "DTI: %.2f, Historial negativo: %s, Ingreso suficiente: %s",
            debtToIncomeRatio,
            hasNegativeHistory ? "Sí" : "No",
            incomeSufficient ? "Sí" : "No"
        );
        
        RiskEvaluation evaluation = new RiskEvaluation(
            UUID.randomUUID(),
            creditRequestId,
            approved,
            evaluationDetails,
            LocalDate.now(),
            debtToIncomeRatio,
            hasNegativeHistory
        );
        
        evaluation.validate();
        return riskEvaluationRepository.save(evaluation);
    }

    public Decision processDecision(UUID creditRequestId, String decisionType, String comments) {
        Optional<CreditRequest> requestOpt = creditRequestRepository.findById(creditRequestId);
        if (requestOpt.isEmpty()) {
            throw new IllegalArgumentException("Solicitud de crédito no encontrada");
        }
        
        Optional<RiskEvaluation> evaluationOpt = riskEvaluationRepository.findByCreditRequestId(creditRequestId);
        if (evaluationOpt.isEmpty()) {
            throw new IllegalStateException("No existe evaluación de riesgo para esta solicitud");
        }
        
        RiskEvaluation evaluation = evaluationOpt.get();
        if (!evaluation.isApproved()) {
            decisionType = "REJECTED";
        }
        
        Decision decision = new Decision(
            UUID.randomUUID(),
            creditRequestId,
            decisionType,
            comments,
            LocalDate.now(),
            "SYSTEM"
        );
        
        decision.validate();
        Decision savedDecision = decisionRepository.save(decision);
        
        String newStatus = "APPROVED".equals(decisionType) ? "APROBADA" : 
                          "REJECTED".equals(decisionType) ? "RECHAZADA" : "EN_REVISION";
        updateCreditRequestStatus(creditRequestId, newStatus);
        
        return savedDecision;
    }

    private boolean isClientEligible(Client client) {
        int age = client.calculateAge();
        return age >= 18 && age <= 70;
    }

    private BigDecimal calculateDebtToIncomeRatio(BigDecimal amount, int months, BigDecimal monthlyIncome) {
        BigDecimal monthlyPayment = amount.calculateMonthlyPayment(BigDecimal.valueOf(0.15));
        return monthlyPayment.divide(monthlyIncome, 4, java.math.RoundingMode.HALF_UP);
    }

    private RiskEvaluation createInitialRiskEvaluation(UUID creditRequestId, Client client) {
        return new RiskEvaluation(
            UUID.randomUUID(),
            creditRequestId,
            false,
            "Evaluación inicial pendiente",
            LocalDate.now(),
            BigDecimal.ZERO,
            client.hasNegativeCreditHistory()
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapter.java ===
package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.domain.model.Client;
import com.pragma.credits.domain.ports.ClientRepository;
import com.pragma.credits.infrastructure.adapters.jpa.entities.ClientJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ClientJpaAdapter implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientMapper clientMapper;

    public ClientJpaAdapter(ClientJpaRepository clientJpaRepository, ClientMapper clientMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client save(Client client) {
        client.validate();
        ClientJpaEntity entity = clientMapper.toEntity(client);
        ClientJpaEntity savedEntity = clientJpaRepository.save(entity);
        return clientMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return clientJpaRepository.findById(id)
                .map(clientMapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return clientJpaRepository.findAll().stream()
                .map(clientMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (clientJpaRepository.existsById(id)) {
            clientJpaRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        return clientJpaRepository.existsById(id);
    }

    @Override
    public List<Client> findByIdentificationNumber(String identificationNumber) {
        return clientJpaRepository.findByIdentificationNumber(identificationNumber).stream()
                .map(clientMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> findByEmail(String email) {
        return clientJpaRepository.findByEmail(email).stream()
                .map(clientMapper::toDomain)
                .collect(Collectors.toList());
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/adapters/jpa/CreditRequestJpaAdapter.java ===
package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.domain.model.CreditRequest;
import com.pragma.credits.domain.ports.CreditRequestRepository;
import com.pragma.credits.infrastructure.adapters.jpa.entities.CreditRequestJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CreditRequestJpaAdapter implements CreditRequestRepository {

    private final CreditRequestJpaRepository creditRequestJpaRepository;
    private final CreditRequestMapper creditRequestMapper;

    public CreditRequestJpaAdapter(
            CreditRequestJpaRepository creditRequestJpaRepository,
            CreditRequestMapper creditRequestMapper) {
        this.creditRequestJpaRepository = creditRequestJpaRepository;
        this.creditRequestMapper = creditRequestMapper;
    }

    @Override
    public CreditRequest save(CreditRequest creditRequest) {
        creditRequest.validate();
        CreditRequestJpaEntity entity = creditRequestMapper.toEntity(creditRequest);
        CreditRequestJpaEntity savedEntity = creditRequestJpaRepository.save(entity);
        return creditRequestMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<CreditRequest> findById(UUID id) {
        return creditRequestJpaRepository.findById(id)
                .map(creditRequestMapper::toDomain);
    }

    @Override
    public List<CreditRequest> findAll() {
        return creditRequestJpaRepository.findAll().stream()
                .map(creditRequestMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (creditRequestJpaRepository.existsById(id)) {
            creditRequestJpaRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        return creditRequestJpaRepository.existsById(id);
    }

    @Override
    public List<CreditRequest> findByClientId(UUID clientId) {
        return creditRequestJpaRepository.findByClientId(clientId).stream()
                .map(creditRequestMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditRequest> findByStatus(String status) {
        return creditRequestJpaRepository.findByStatus(status).stream()
                .map(creditRequestMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditRequest> findByStatusAndClientId(String status, UUID clientId) {
        return creditRequestJpaRepository.findByStatusAndClientId(status, clientId).stream()
                .map(creditRequestMapper::toDomain)
                .collect(Collectors.toList());
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/adapters/jpa/RiskEvaluationJpaAdapter.java ===
package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.domain.model.RiskEvaluation;
import com.pragma.credits.domain.ports.RiskEvaluationRepository;
import com.pragma.credits.infrastructure.adapters.jpa.entities.RiskEvaluationJpaEntity;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RiskEvaluationJpaAdapter implements RiskEvaluationRepository {

    private final RiskEvaluationJpaRepository jpaRepository;
    private final ModelMapper modelMapper;

    public RiskEvaluationJpaAdapter(RiskEvaluationJpaRepository jpaRepository, ModelMapper modelMapper) {
        this.jpaRepository = jpaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RiskEvaluation save(RiskEvaluation riskEvaluation) {
        riskEvaluation.validate();
        RiskEvaluationJpaEntity entity = toEntity(riskEvaluation);
        RiskEvaluationJpaEntity savedEntity = jpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<RiskEvaluation> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<RiskEvaluation> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RiskEvaluation> findByCreditRequestId(Long creditRequestId) {
        return jpaRepository.findByCreditRequestId(creditRequestId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    private RiskEvaluationJpaEntity toEntity(RiskEvaluation domain) {
        return modelMapper.map(domain, RiskEvaluationJpaEntity.class);
    }

    private RiskEvaluation toDomain(RiskEvaluationJpaEntity entity) {
        return modelMapper.map(entity, RiskEvaluation.class);
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/adapters/jpa/DecisionJpaAdapter.java ===
package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.domain.model.Decision;
import com.pragma.credits.domain.ports.DecisionRepository;
import com.pragma.credits.infrastructure.adapters.jpa.entities.DecisionJpaEntity;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DecisionJpaAdapter implements DecisionRepository {

    private final DecisionJpaRepository jpaRepository;
    private final ModelMapper modelMapper;

    public DecisionJpaAdapter(DecisionJpaRepository jpaRepository, ModelMapper modelMapper) {
        this.jpaRepository = jpaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Decision save(Decision decision) {
        DecisionJpaEntity entity = toEntity(decision);
        DecisionJpaEntity savedEntity = jpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Decision> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Decision> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Decision> findByCreditRequestId(Long creditRequestId) {
        return jpaRepository.findByCreditRequestId(creditRequestId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Decision> findLatestByCreditRequestId(Long creditRequestId) {
        return jpaRepository.findTopByCreditRequestIdOrderByDecisionDateDesc(creditRequestId)
                .map(this::toDomain);
    }

    @Override
    public List<Decision> findByStatus(String status) {
        return jpaRepository.findByStatus(status).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Decision> findByDecisionDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return jpaRepository.findByDecisionDateBetween(startDate, endDate).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    private DecisionJpaEntity toEntity(Decision domain) {
        return modelMapper.map(domain, DecisionJpaEntity.class);
    }

    private Decision toDomain(DecisionJpaEntity entity) {
        return modelMapper.map(entity, Decision.class);
    }
}

// === ARCHIVO: src/main/java/com/pragma/credits/infrastructure/config/ModelMapperConfig.java ===
package com.pragma.credits.infrastructure.config;

import com.pragma.credits.domain.model.Client;
import com.pragma.credits.domain.model.CreditRequest;
import com.pragma.credits.domain.model.RiskEvaluation;
import com.pragma.credits.domain.model.Decision;
import com.pragma.credits.infrastructure.adapters.jpa.entities.ClientJpaEntity;
import com.pragma.credits.infrastructure.adapters.jpa.entities.CreditRequestJpaEntity;
import com.pragma.credits.infrastructure.adapters.jpa.entities.RiskEvaluationJpaEntity;
import com.pragma.credits.infrastructure.adapters.jpa.entities.DecisionJpaEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true)
                .setAmbiguityIgnored(false);

        configureClientMappings(modelMapper);
        configureCreditRequestMappings(modelMapper);
        configureRiskEvaluationMappings(modelMapper);
        configureDecisionMappings(modelMapper);

        return modelMapper;
    }

    private void configureClientMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(Client.class, ClientJpaEntity.class).addMappings(mapper -> {
            mapper.map(Client::name, ClientJpaEntity::setName);
            mapper.map(Client::lastName, ClientJpaEntity::setLastName);
            mapper.map(Client::documentType, ClientJpaEntity::setDocumentType);
            mapper.map(Client::documentNumber, ClientJpaEntity::setDocumentNumber);
            mapper.map(Client::email, ClientJpaEntity::setEmail);
            mapper.map(Client::phone, ClientJpaEntity::setPhone);
            mapper.map(Client::birthDate, ClientJpaEntity::setBirthDate);
            mapper.map(Client::monthlyIncome, ClientJpaEntity::setMonthlyIncome);
            mapper.map(Client::status, ClientJpaEntity::setStatus);
        });

        modelMapper.typeMap(ClientJpaEntity.class, Client.class).addMappings(mapper -> {
            mapper.map(ClientJpaEntity::getName, Client::setName);
            mapper.map(ClientJpaEntity::getLastName, Client::setLastName);
            mapper.map(ClientJpaEntity::getDocumentType, Client::setDocumentType);
            mapper.map(ClientJpaEntity::getDocumentNumber, Client::setDocumentNumber);
            mapper.map(ClientJpaEntity::getEmail, Client::setEmail);
            mapper.map(ClientJpaEntity::getPhone, Client::setPhone);
            mapper.map(ClientJpaEntity::getBirthDate, Client::setBirthDate);
            mapper.map(ClientJpaEntity::getMonthlyIncome, Client::setMonthlyIncome);
            mapper.map(ClientJpaEntity::getStatus, Client::setStatus);
        });
    }

    private void configureCreditRequestMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(CreditRequest.class, CreditRequestJpaEntity.class).addMappings(mapper -> {
            mapper.map(CreditRequest::requestedAmount, CreditRequestJpaEntity::setRequestedAmount);
            mapper.map(CreditRequest::termMonths, CreditRequestJpaEntity::setTermMonths);
            mapper.map(CreditRequest::purpose, CreditRequestJpaEntity::setPurpose);
            mapper.map(CreditRequest::interestRate, CreditRequestJpaEntity::setInterestRate);
            mapper.map(CreditRequest::status, CreditRequestJpaEntity::setStatus);
            mapper.map(CreditRequest::requestDate, CreditRequestJpaEntity::setRequestDate);
        });

        modelMapper.typeMap(CreditRequestJpaEntity.class, CreditRequest.class).addMappings(mapper -> {
            mapper.map(CreditRequestJpaEntity::getRequestedAmount, CreditRequest::setRequestedAmount);
            mapper.map(CreditRequestJpaEntity::getTermMonths, CreditRequest::setTermMonths);
            mapper.map(CreditRequestJpaEntity::getPurpose, CreditRequest::setPurpose);
            mapper.map(CreditRequestJpaEntity::getInterestRate, CreditRequest::setInterestRate);
            mapper.map(CreditRequestJpaEntity::getStatus, CreditRequest::setStatus);
            mapper.map(CreditRequestJpaEntity::getRequestDate, CreditRequest::setRequestDate);
        });
    }

    private void configureRiskEvaluationMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(RiskEvaluation.class, RiskEvaluationJpaEntity.class).addMappings(mapper -> {
            mapper.map(RiskEvaluation::creditRequestId, RiskEvaluationJpaEntity::setCreditRequestId);
            mapper.map(RiskEvaluation::score, RiskEvaluationJpaEntity::setScore);
            mapper.map(RiskEvaluation::riskLevel, RiskEvaluationJpaEntity::setRiskLevel);
            mapper.map(RiskEvaluation::maxReccomendedAmount, RiskEvaluationJpaEntity::setMaxReccomendedAmount);
            mapper.map(RiskEvaluation::evaluationDate, RiskEvaluationJpaEntity::setEvaluationDate);
            mapper.map(RiskEvaluation::details, RiskEvaluationJpaEntity::setDetails);
        });

        modelMapper.typeMap(RiskEvaluationJpaEntity.class, RiskEvaluation.class).addMappings(mapper -> {
            mapper.map(RiskEvaluationJpaEntity::getCreditRequestId, RiskEvaluation::setCreditRequestId);
            mapper.map(RiskEvaluationJpaEntity::getScore, RiskEvaluation::setScore);
            mapper.map(RiskEvaluationJpaEntity::getRiskLevel, RiskEvaluation::setRiskLevel);
            mapper.map(RiskEvaluationJpaEntity::getMaxReccomendedAmount, RiskEvaluation::setMaxReccomendedAmount);
            mapper.map(RiskEvaluationJpaEntity::getEvaluationDate, RiskEvaluation::setEvaluationDate);
            mapper.map(RiskEvaluationJpaEntity::getDetails, RiskEvaluation::setDetails);
        });
    }

    private void configureDecisionMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(Decision.class, DecisionJpaEntity.class).addMappings(mapper -> {
            mapper.map(Decision::creditRequestId, DecisionJpaEntity::setCreditRequestId);
            mapper.map(Decision::approved, DecisionJpaEntity::setApproved);
            mapper.map(Decision::approvedAmount, DecisionJpaEntity::setApprovedAmount);
            mapper.map(Decision::interestRate, DecisionJpaEntity::setInterestRate);
            mapper.map(Decision::termMonths, DecisionJpaEntity::setTermMonths);
            mapper.map(Decision::status, DecisionJpaEntity::setStatus);
            mapper.map(Decision::decisionDate, DecisionJpaEntity::setDecisionDate);
            mapper.map(Decision::decisionMaker, DecisionJpaEntity::setDecisionMaker);
            mapper.map(Decision::observations, DecisionJpaEntity::setObservations);
        });

        modelMapper.typeMap(DecisionJpaEntity.class, Decision.class).addMappings(mapper -> {
            mapper.map(DecisionJpaEntity::getCreditRequestId, Decision::setCreditRequestId);
            mapper.map(DecisionJpaEntity::getApproved, Decision::setApproved);
            mapper.map(DecisionJpaEntity::getApprovedAmount, Decision::setApprovedAmount);
            mapper.map(DecisionJpaEntity::getInterestRate, Decision::setInterestRate);
            mapper.map(DecisionJpaEntity::getTermMonths, Decision::setTermMonths);
            mapper.map(DecisionJpaEntity::getStatus, Decision::setStatus);
            mapper.map(DecisionJpaEntity::getDecisionDate, Decision::setDecisionDate);
            mapper.map(DecisionJpaEntity::getDecisionMaker, Decision::setDecisionMaker);
            mapper.map(DecisionJpaEntity::getObservations, Decision::setObservations);
        });
    }
}

// === ARCHIVO: src/main/resources/db/migration/V1__initial_schema.sql ===
-- Script de migración Flyway para crear el esquema de base de datos normalizado
-- Sistema de gestión de créditos con modelo de datos en 3NF

-- Tabla de clientes
CREATE TABLE clients (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    document_type VARCHAR(20) NOT NULL,
    document_number VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(20),
    birth_date DATE NOT NULL,
    monthly_income DECIMAL(15, 2) NOT NULL,
    credit_score INTEGER DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_clients_document_number ON clients(document_number);
CREATE INDEX idx_clients_email ON clients(email);

-- Tabla de solicitudes de crédito
CREATE TABLE credit_requests (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    client_id UUID NOT NULL REFERENCES clients(id) ON DELETE RESTRICT,
    requested_amount DECIMAL(15, 2) NOT NULL,
    term_months INTEGER NOT NULL CHECK (term_months > 0),
    purpose VARCHAR(255) NOT NULL,
    interest_rate DECIMAL(5, 4) NOT NULL,
    monthly_payment DECIMAL(15, 2),
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING',
    rejection_reason TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_requested_amount_positive CHECK (requested_amount > 0)
);

CREATE INDEX idx_credit_requests_client_id ON credit_requests(client_id);
CREATE INDEX idx_credit_requests_status ON credit_requests(status);

-- Tabla de evaluaciones de riesgo
CREATE TABLE risk_evaluations (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    credit_request_id UUID NOT NULL UNIQUE REFERENCES credit_requests(id) ON DELETE CASCADE,
    evaluation_date DATE NOT NULL,
    monthly_debt_ratio DECIMAL(5, 4) NOT NULL,
    employment_stability_score INTEGER NOT NULL CHECK (employment_stability_score BETWEEN 0 AND 100),
    credit_history_score INTEGER NOT NULL CHECK (credit_history_score BETWEEN 0 AND 100),
    collateral_value DECIMAL(15, 2) DEFAULT 0,
    risk_level VARCHAR(20) NOT NULL,
    recommendation VARCHAR(20) NOT NULL,
    evaluator_notes TEXT,
    is_approved BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_risk_evaluations_credit_request_id ON risk_evaluations(credit_request_id);
CREATE INDEX idx_risk_evaluations_risk_level ON risk_evaluations(risk_level);

-- Tabla de decisiones
CREATE TABLE decisions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    credit_request_id UUID NOT NULL REFERENCES credit_requests(id) ON DELETE CASCADE,
    decision_type VARCHAR(20) NOT NULL,
    decision_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    approver_name VARCHAR(100) NOT NULL,
    approver_role VARCHAR(50) NOT NULL,
    decision_reason TEXT NOT NULL,
    conditions TEXT,
    interest_rate_final DECIMAL(5, 4),
    monthly_payment_final DECIMAL(15, 2),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_decisions_credit_request_id ON decisions(credit_request_id);
CREATE INDEX idx_decisions_decision_type ON decisions(decision_type);

-- Tabla de cuotas (para seguimiento de pagos)
CREATE TABLE installments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    credit_request_id UUID NOT NULL REFERENCES credit_requests(id) ON DELETE CASCADE,
    installment_number INTEGER NOT NULL CHECK (installment_number > 0),
    due_date DATE NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    principal_amount DECIMAL(15, 2) NOT NULL,
    interest_amount DECIMAL(15, 2) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    paid_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_installments_credit_request_id ON installments(credit_request_id);
CREATE INDEX idx_installments_due_date ON installments(due_date);
CREATE INDEX idx_installments_status ON installments(status);

-- Función para actualizar timestamps automáticamente
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

-- Triggers para actualizar updated_at
CREATE TRIGGER update_clients_updated_at
    BEFORE UPDATE ON clients
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_credit_requests_updated_at
    BEFORE UPDATE ON credit_requests
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

// === ARCHIVO: src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java ===
package com.pragma.credits.application;

import com.pragma.credits.domain.model.Client;
import com.pragma.credits.domain.model.CreditRequest;
import com.pragma.credits.domain.model.RiskEvaluation;
import com.pragma.credits.domain.model.Decision;
import com.pragma.credits.domain.ports.ClientRepository;
import com.pragma.credits.domain.ports.CreditRequestRepository;
import com.pragma.credits.domain.ports.RiskEvaluationRepository;
import com.pragma.credits.domain.ports.DecisionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreditRequestServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private CreditRequestRepository creditRequestRepository;

    @Mock
    private RiskEvaluationRepository riskEvaluationRepository;

    @Mock
    private DecisionRepository decisionRepository;

    @InjectMocks
    private CreditRequestService creditRequestService;

    private Client testClient;
    private CreditRequest testCreditRequest;
    private RiskEvaluation testRiskEvaluation;
    private Decision testDecision;

    @BeforeEach
    void setUp() {
        testClient = new Client(
            UUID.randomUUID(),
            "Juan",
            "Pérez",
            "DNI",
            "12345678",
            "juan@example.com",
            "+5491112345678",
            LocalDate.of(1985, 5, 15),
            new BigDecimal("5000.00"),
            750
        );

        testCreditRequest = new CreditRequest(
            UUID.randomUUID(),
            testClient.id(),
            new BigDecimal("50000.00"),
            24,
            "CONSUMO",
            new BigDecimal("0.15"),
            null,
            "PENDING",
            null
        );

        testRiskEvaluation = new RiskEvaluation(
            UUID.randomUUID(),
            testCreditRequest.id(),
            LocalDate.now(),
            new BigDecimal("0.30"),
            80,
            85,
            new BigDecimal("10000.00"),
            "MEDIUM",
            "APPROVE",
            "Perfil adecuado para el monto solicitado",
            true
        );

        testDecision = new Decision(
            UUID.randomUUID(),
            testCreditRequest.id(),
            "APPROVED",
            "María García",
            "Analista de Crédito",
            "Evaluación de riesgo favorable",
            null,
            new BigDecimal("0.12"),
            new BigDecimal("2350.00")
        );
    }

    @Test
    void createCreditRequest_shouldSaveRequest_whenClientExistsAndDataIsValid() {
        when(clientRepository.findById(testClient.id())).thenReturn(Optional.of(testClient));
        when(creditRequestRepository.save(any(CreditRequest.class))).thenReturn(testCreditRequest);

        CreditRequest result = creditRequestService.createCreditRequest(testCreditRequest);

        assertNotNull(result);
        assertEquals(testCreditRequest.id(), result.id());
        verify(creditRequestRepository).save(any(CreditRequest.class));
    }

    @Test
    void createCreditRequest_shouldThrowException_whenClientDoesNotExist() {
        UUID nonExistentClientId = UUID.randomUUID();
        when(clientRepository.findById(nonExistentClientId)).thenReturn(Optional.empty());

        CreditRequest invalidRequest = new CreditRequest(
            UUID.randomUUID(),
            nonExistentClientId,
            new BigDecimal("30000.00"),
            12,
            "CONSUMO",
            new BigDecimal("0.15"),
            null,
            "PENDING",
            null
        );

        assertThrows(IllegalArgumentException.class, 
            () -> creditRequestService.createCreditRequest(invalidRequest));
        verify(creditRequestRepository, never()).save(any());
    }

    @Test
    void evaluateCreditRequest_shouldCreateRiskEvaluation_whenRequestIsValid() {
        when(creditRequestRepository.findById(testCreditRequest.id()))
            .thenReturn(Optional.of(testCreditRequest));
        when(riskEvaluationRepository.save(any(RiskEvaluation.class)))
            .thenReturn(testRiskEvaluation);

        RiskEvaluation result = creditRequestService.evaluateCreditRequest(
            testCreditRequest.id(), testRiskEvaluation);

        assertNotNull(result);
        assertTrue(result.isApproved());
        assertEquals("MEDIUM", result.riskLevel());
        verify(riskEvaluationRepository).save(any(RiskEvaluation.class));
    }

    @Test
    void makeDecision_shouldApproveRequest_whenRiskEvaluationIsApproved() {
        when(creditRequestRepository.findById(testCreditRequest.id()))
            .thenReturn(Optional.of(testCreditRequest));
        when(riskEvaluationRepository.findByCreditRequestId(testCreditRequest.id()))
            .thenReturn(Optional.of(testRiskEvaluation));
        when(decisionRepository.save(any(Decision.class))).thenReturn(testDecision);

        Decision result = creditRequestService.makeDecision(
            testCreditRequest.id(), testDecision);

        assertNotNull(result);
        assertEquals("APPROVED", result.decisionType());
        verify(decisionRepository).save(any(Decision.class));
    }

    @Test
    void calculateMonthlyPayment_shouldComputeCorrectly() {
        BigDecimal amount = new BigDecimal("50000.00");
        BigDecimal annualRate = new BigDecimal("0.15");
        int termMonths = 24;

        BigDecimal monthlyPayment = creditRequestService.calculateMonthlyPayment(
            amount, annualRate, termMonths);

        assertNotNull(monthlyPayment);
        assertTrue(monthlyPayment.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void getCreditRequestById_shouldReturnRequest_whenExists() {
        when(creditRequestRepository.findById(testCreditRequest.id()))
            .thenReturn(Optional.of(testCreditRequest));

        Optional<CreditRequest> result = creditRequestService.getCreditRequestById(
            testCreditRequest.id());

        assertTrue(result.isPresent());
        assertEquals(testCreditRequest.id(), result.get().id());
    }

    @Test
    void getCreditRequestById_shouldReturnEmpty_whenNotExists() {
        UUID nonExistentId = UUID.randomUUID();
        when(creditRequestRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        Optional<CreditRequest> result = creditRequestService.getCreditRequestById(nonExistentId);

        assertFalse(result.isPresent());
    }

    @Test
    void getCreditRequestsByClientId_shouldReturnClientRequests() {
        when(creditRequestRepository.findByClientId(testClient.id()))
            .thenReturn(java.util.List.of(testCreditRequest));

        var result = creditRequestService.getCreditRequestsByClientId(testClient.id());

        assertEquals(1, result.size());
        assertEquals(testClient.id(), result.get(0).clientId());
    }
}

// === ARCHIVO: src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java ===
package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.infrastructure.adapters.jpa.entities.ClientJpaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientJpaAdapterTest {

    @Mock
    private ClientJpaRepository clientJpaRepository;

    private ClientJpaAdapter clientJpaAdapter;

    @BeforeEach
    void setUp() {
        clientJpaAdapter = new ClientJpaAdapter(clientJpaRepository);
        ReflectionTestUtils.setField(clientJpaAdapter, "modelMapper", new org.modelmapper.ModelMapper());
    }

    @Test
    void save_shouldPersistClientEntity() {
        ClientJpaEntity entity = createTestEntity();
        when(clientJpaRepository.save(any(ClientJpaEntity.class))).thenReturn(entity);

        ClientJpaEntity result = clientJpaAdapter.save(entity);

        assertNotNull(result);
        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getDocumentNumber(), result.getDocumentNumber());
        verify(clientJpaRepository).save(any(ClientJpaEntity.class));
    }

    @Test
    void findById_shouldReturnClient_whenExists() {
        UUID clientId = UUID.randomUUID();
        ClientJpaEntity entity = createTestEntity();
        entity.setId(clientId);
        when(clientJpaRepository.findById(clientId)).thenReturn(java.util.Optional.of(entity));

        java.util.Optional<ClientJpaEntity> result = clientJpaAdapter.findById(clientId);

        assertTrue(result.isPresent());
        assertEquals(clientId, result.get().getId());
    }

    @Test
    void findById_shouldReturnEmpty_whenNotExists() {
        UUID nonExistentId = UUID.randomUUID();
        when(clientJpaRepository.findById(nonExistentId)).thenReturn(java.util.Optional.empty());

        java.util.Optional<ClientJpaEntity> result = clientJpaAdapter.findById(nonExistentId);

        assertFalse(result.isPresent());
    }

    @Test
    void findByDocumentNumber_shouldReturnClient_whenDocumentExists() {
        String documentNumber = "12345678";
        ClientJpaEntity entity = createTestEntity();
        entity.setDocumentNumber(documentNumber);
        when(clientJpaRepository.findByDocumentNumber(documentNumber))
            .thenReturn(java.util.Optional.of(entity));

        java.util.Optional<ClientJpaEntity> result = 
            clientJpaAdapter.findByDocumentNumber(documentNumber);

        assertTrue(result.isPresent());
        assertEquals(documentNumber, result.get().getDocumentNumber());
    }

    @Test
    void findByEmail_shouldReturnClient_whenEmailExists() {
        String email = "test@example.com";
        ClientJpaEntity entity = createTestEntity();
        entity.setEmail(email);
        when(clientJpaRepository.findByEmail(email))
            .thenReturn(java.util.Optional.of(entity));

        java.util.Optional<ClientJpaEntity> result = clientJpaAdapter.findByEmail(email);

        assertTrue(result.isPresent());
        assertEquals(email, result.get().getEmail());
    }

    @Test
    void existsByDocumentNumber_shouldReturnTrue_whenDocumentExists() {
        String documentNumber = "12345678";
        when(clientJpaRepository.existsByDocumentNumber(documentNumber)).thenReturn(true);

        boolean result = clientJpaAdapter.existsByDocumentNumber(documentNumber);

        assertTrue(result);
    }

    @Test
    void existsByDocumentNumber_shouldReturnFalse_whenDocumentNotExists() {
        String nonExistentDocument = "00000000";
        when(clientJpaRepository.existsByDocumentNumber(nonExistentDocument)).thenReturn(false);

        boolean result = clientJpaAdapter.existsByDocumentNumber(nonExistentDocument);

        assertFalse(result);
    }

    @Test
    void deleteById_shouldCallRepository() {
        UUID clientId = UUID.randomUUID();
        doNothing().when(clientJpaRepository).deleteById(clientId);

        clientJpaAdapter.deleteById(clientId);

        verify(clientJpaRepository).deleteById(clientId);
    }

    @Test
    void findAll_shouldReturnAllClients() {
        ClientJpaEntity entity1 = createTestEntity();
        entity1.setId(UUID.randomUUID());
        ClientJpaEntity entity2 = createTestEntity();
        entity2.setId(UUID.randomUUID());
        entity2.setDocumentNumber("87654321");
        
        when(clientJpaRepository.findAll()).thenReturn(java.util.List.of(entity1, entity2));

        var result = clientJpaAdapter.findAll();

        assertEquals(2, result.size());
    }

    private ClientJpaEntity createTestEntity() {
        ClientJpaEntity entity = new ClientJpaEntity();
        entity.setId(UUID.randomUUID());
        entity.setFirstName("Juan");
        entity.setLastName("Pérez");
        entity.setDocumentType("DNI");
        entity.setDocumentNumber("12345678");
        entity.setEmail("juan@example.com");
        entity.setPhone("+5491112345678");
        entity.setBirthDate(LocalDate.of(1985, 5, 15));
        entity.setMonthlyIncome(new BigDecimal("5000.00"));
        entity.setCreditScore(750);
        return entity;
    }
}
```
