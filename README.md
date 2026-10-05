# Normalización de Modelo de Datos para Sistema de Créditos

El equipo de desarrollo de un sistema de gestión de créditos necesita un modelo de datos normalizado que asegure la integridad y eficiencia de la información almacenada. El sistema gestiona datos de clientes, solicitudes de crédito, evaluaciones de riesgo y decisiones finales. Los clientes pueden tener múltiples solicitudes y cada solicitud pasa por varias etapas de evaluación. El objetivo es diseñar un modelo de datos que siga las formas normales y utilice un modelo Entidad-Relación para representar las relaciones entre las entidades.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Diseño e Implementación de un Modelo de Datos Normalizado |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Identificación de Entidades y Atributos

**Objetivo:** Identificar las entidades principales y sus atributos en el dominio de créditos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Enumera las entidades clave en el sistema de gestión de créditos.
- Identifica los atributos relevantes para cada entidad.
- Describe las relaciones entre las entidades.

**Entregable:** Lista de entidades y atributos con relaciones identificadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la cardinalidad de las relaciones.
- Piensa en los atributos que deben ser únicos o compuestos.

</details>

### Fase 2: Aplicación de Formas Normales

**Objetivo:** Aplicar las formas normales al modelo de datos para eliminar redundancias y asegurar la integridad.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Aplica la primera forma normal (1NF) al modelo de datos.
- Aplica la segunda forma normal (2NF) para eliminar dependencias parciales.
- Aplica la tercera forma normal (3NF) para eliminar dependencias transitivas.

**Entregable:** Modelo de datos normalizado siguiendo las formas normales 1NF, 2NF y 3NF.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que en 1NF cada columna debe contener un solo valor.
- En 2NF, asegúrate de que cada columna no clave sea completamente dependiente de la clave primaria.
- En 3NF, elimina las dependencias transitivas.

</details>

### Fase 3: Modelo Entidad-Relación

**Objetivo:** Crear un modelo Entidad-Relación que represente las relaciones entre las entidades normalizadas.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Crea un diagrama Entidad-Relación (ERD) que muestre las relaciones entre las entidades normalizadas.
- Identifica las claves primarias y extranjeras en el modelo.
- Asegura que el modelo refleje las formas normales aplicadas en la fase anterior.

**Entregable:** Diagrama Entidad-Relación (ERD) del modelo de datos normalizado.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza herramientas de modelado de datos para crear el ERD.
- Asegúrate de que las relaciones estén correctamente representadas con cardinalidad y participación.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son las formas normales y cómo se aplican en un modelo de datos?
- **paraQueSirve**: ¿Cuál es el propósito de normalizar un modelo de datos?
- **comoSeUsa**: ¿Cómo aplicas la primera, segunda y tercera forma normal a un modelo de datos?
- **erroresComunes**: ¿Cuáles son los errores comunes al normalizar un modelo de datos?
- **queDecisionesImplica**: ¿Qué decisiones implica la normalización de un modelo de datos en términos de integridad y eficiencia?

## Criterios de Evaluacion

- Identificación correcta de entidades y atributos en el dominio de créditos.
- Aplicación adecuada de las formas normales 1NF, 2NF y 3NF.
- Creación de un diagrama Entidad-Relación que refleje las relaciones y formas normales aplicadas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
