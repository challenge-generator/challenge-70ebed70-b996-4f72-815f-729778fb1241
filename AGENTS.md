# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Normalización de Modelo de Datos para Sistema de Créditos**.

| | |
|---|---|
| Tema | Diseño e Implementación de un Modelo de Datos Normalizado |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar con separación de dominio e infraestructura |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.postgresql:postgresql 42.7.3
- org.projectlombok:lombok 1.18.30
- org.springframework.boot:spring-boot-starter-test n/a
- org.flywaydb:flyway-core n/a
- org.modelmapper:modelmapper 3.2.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Identificación de Entidades y Atributos**: Lista de entidades y atributos con relaciones identificadas.
- **Fase 2 — Aplicación de Formas Normales**: Modelo de datos normalizado siguiendo las formas normales 1NF, 2NF y 3NF.
- **Fase 3 — Modelo Entidad-Relación**: Diagrama Entidad-Relación (ERD) del modelo de datos normalizado.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (31)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/ClientJpaEntity.java` — `CreditRequestJpaEntity.setClient`
      Se invoca `setClient` sobre `CreditRequestJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/CreditRequestJpaEntity.java` — `RiskEvaluationJpaEntity.setCreditRequest`
      Se invoca `setCreditRequest` sobre `RiskEvaluationJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.clientId`
      Se invoca `clientId` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.id`
      Se invoca `id` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.amount`
      Se invoca `amount` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.termMonths`
      Se invoca `termMonths` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.purpose`
      Se invoca `purpose` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.requestDate`
      Se invoca `requestDate` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `CreditRequest.interestRate`
      Se invoca `interestRate` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/credits/application/CreditRequestService.java` — `Client.hasNegativeCreditHistory`
      Se invoca `hasNegativeCreditHistory` sobre `Client`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Client.id`
      Se invoca `id` sobre `Client`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequest.id`
      Se invoca `id` sobre `CreditRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.id`
      Se invoca `id` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.evaluateCreditRequest`
      Se invoca `evaluateCreditRequest` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.riskLevel`
      Se invoca `riskLevel` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.makeDecision`
      Se invoca `makeDecision` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.decisionType`
      Se invoca `decisionType` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.calculateMonthlyPayment`
      Se invoca `calculateMonthlyPayment` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.getCreditRequestById`
      Se invoca `getCreditRequestById` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.isPresent`
      Se invoca `isPresent` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.get`
      Se invoca `get` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `CreditRequestService.getCreditRequestsByClientId`
      Se invoca `getCreditRequestsByClientId` sobre `CreditRequestService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java` — `Decision.size`
      Se invoca `size` sobre `Decision`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.getDocumentNumber`
      Se invoca `getDocumentNumber` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.isPresent`
      Se invoca `isPresent` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.get`
      Se invoca `get` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.setDocumentNumber`
      Se invoca `setDocumentNumber` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaAdapter.findByDocumentNumber`
      Se invoca `findByDocumentNumber` sobre `ClientJpaAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaAdapter.existsByDocumentNumber`
      Se invoca `existsByDocumentNumber` sobre `ClientJpaAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.size`
      Se invoca `size` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java` — `ClientJpaEntity.setDocumentType`
      Se invoca `setDocumentType` sobre `ClientJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (24)

- `pom.xml`
- `src/main/java/com/pragma/credits/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/credits/domain/model/Client.java`
- `src/main/java/com/pragma/credits/domain/model/CreditRequest.java`
- `src/main/java/com/pragma/credits/domain/model/RiskEvaluation.java`
- `src/main/java/com/pragma/credits/domain/model/Decision.java`
- `src/main/java/com/pragma/credits/domain/ports/ClientRepository.java`
- `src/main/java/com/pragma/credits/domain/ports/CreditRequestRepository.java`
- `src/main/java/com/pragma/credits/domain/ports/RiskEvaluationRepository.java`
- `src/main/java/com/pragma/credits/domain/ports/DecisionRepository.java`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/ClientJpaEntity.java`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/CreditRequestJpaEntity.java`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/RiskEvaluationJpaEntity.java`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities/DecisionJpaEntity.java`
- `src/main/java/com/pragma/credits/application/CreditRequestService.java`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapter.java`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/CreditRequestJpaAdapter.java`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/RiskEvaluationJpaAdapter.java`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/DecisionJpaAdapter.java`
- `src/main/java/com/pragma/credits/infrastructure/config/ModelMapperConfig.java`
- `src/main/resources/db/migration/V1__initial_schema.sql`
- `src/test/java/com/pragma/credits/application/CreditRequestServiceTest.java`
- `src/test/java/com/pragma/credits/infrastructure/adapters/jpa/ClientJpaAdapterTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/credits`
- `src/main/java/com/pragma/credits/domain/model`
- `src/main/java/com/pragma/credits/domain/ports`
- `src/main/java/com/pragma/credits/application`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa`
- `src/main/java/com/pragma/credits/infrastructure/adapters/jpa/entities`
- `src/main/java/com/pragma/credits/infrastructure/config`
- `src/main/resources`
- `src/test/java/com/pragma/credits`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar con separación de dominio e infraestructura**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior
- Brecha que el reto ataca: Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación
- Mision: Candidato con experiencia en Backend Java a nivel Senior.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
