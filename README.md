# Automatización de Pruebas

## Objetivo
Implementar un flujo de integración continua para un proyecto Java,
incorporando Git, Maven, JUnit, BDD con Cucumber y Jenkins.

## Tecnologías
- Java 17
- Maven
- JUnit 5
- Cucumber
- Git
- Jenkins
- JMeter (propuesta de performance)

## Estructura
- `src/main/java`: código principal.
- `src/test/java`: pruebas unitarias y Step Definitions.
- `src/test/resources/features`: escenarios Gherkin.
- `Jenkinsfile`: pipeline CI.
- `pom.xml`: dependencias y configuración Maven.

## Ejecución local
```bash
mvn clean test
```

Solo BDD:
```bash
mvn test -Dtest=RunCucumberTest
```

## Reportes
- JUnit/Surefire: `target/surefire-reports/`
- Cucumber HTML: `target/cucumber-report.html`
- Cucumber JSON: `target/cucumber.json`

## Pipeline
1. Checkout
2. Build
3. Unit Tests
4. BDD Tests
5. Reports

## Performance
Se incluye una plantilla JMeter en `performance/login-performance.jmx`.
Antes de ejecutarla, reemplazar el endpoint de ejemplo por uno real.

Indicadores:
- TPS
- Latencia
- Errores

## Alertas
Se propone alertar ante:
- pruebas fallidas;
- latencia sobre el umbral definido;
- porcentaje de errores sobre el umbral definido.

## Evidencias
Agregar capturas reales de Git, ejecución Maven, Jenkins, BDD,
reporte Cucumber, JMeter, métricas/dashboard y alertas.
