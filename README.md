**# Automatización de Pruebas**



**## Objetivo**



Implementar un flujo básico de integración continua para un proyecto Java, incorporando gestión de versiones con Git, gestión de dependencias con Maven y automatización de pruebas mediante JUnit 5 y Cucumber.



El proyecto permite ejecutar pruebas unitarias y pruebas BDD tanto localmente como mediante un pipeline de integración continua utilizando Jenkins.



**## Tecnologías**



\* Java 17

\* Apache Maven

\* JUnit 5

\* Cucumber

\* JUnit Platform

\* Maven Surefire

\* Git

\* GitHub

\* Jenkins

\* JMeter



**## Estructura del proyecto**



```text

automatizacion-pruebas/

│

├── src/

│   ├── main/java/

│   │   └── cl/iplacex/calculadora/

│   │       └── Calculadora.java

│   │

│   └── test/

│       ├── java/

│       │   └── cl/iplacex/

│       │       ├── calculadora/

│       │       │   └── CalculadoraTest.java

│       │       └── bdd/

│       │           ├── LoginSteps.java

│       │           └── RunCucumberTest.java

│       │

│       └── resources/

│           └── features/

│               └── login.feature

│

├── docs/

│   ├── Alertas.md

│   ├── Performance.md

│   └── Three-Amigos.md

│

├── performance/

│   └── login-performance.jmx

│

├── .gitignore

├── Jenkinsfile

├── pom.xml

└── README.md

```



**### Descripción de los archivos y carpetas**



\* `src/main/java`: contiene el código principal del proyecto.

\* `src/test/java`: contiene las pruebas unitarias y las clases Step Definitions de Cucumber.

\* `src/test/resources/features`: contiene los escenarios BDD escritos en Gherkin.

\* `docs`: contiene documentación complementaria sobre rendimiento, alertas y Three Amigos.

\* `performance`: contiene la plantilla de pruebas de rendimiento de JMeter.

\* `.gitignore`: excluye archivos generados o innecesarios para el control de versiones.

\* `pom.xml`: contiene la configuración y las dependencias de Maven.

\* `Jenkinsfile`: define el pipeline de integración continua.

\* `README.md`: contiene la documentación principal del proyecto.



El directorio `target/` es generado automáticamente por Maven y se encuentra excluido mediante `.gitignore`.



**## Dependencias y configuración Maven**



El proyecto utiliza Java 17 y Maven para administrar las dependencias, compilar el código y ejecutar las pruebas.



Las principales dependencias y herramientas utilizadas son:



\* \*\*JUnit 5:\*\* implementación de las pruebas unitarias.

\* \*\*Cucumber:\*\* implementación de pruebas BDD.

\* \*\*JUnit Platform:\*\* plataforma utilizada para ejecutar las pruebas.

\* \*\*Maven Surefire:\*\* ejecución de las pruebas y generación de resultados en formato XML.



**### Ejecución local**



Para limpiar y compilar el proyecto:



```bash

mvn clean compile

```



Para ejecutar las pruebas unitarias:



```bash

mvn test -Dtest=CalculadoraTest

```



Para ejecutar las pruebas BDD:



```bash

mvn test -Dtest=RunCucumberTest

```



Para ejecutar todas las pruebas:



```bash

mvn clean test

```



**## Pruebas unitarias**



El proyecto contiene dos pruebas unitarias independientes implementadas con JUnit 5:



\* `deberiaSumarDosNumeros`

\* `deberiaRestarDosNumeros`



Estas pruebas verifican las operaciones de suma y resta implementadas en la clase `Calculadora`.



La ejecución local validada obtuvo:



```text

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS

```



**## Pruebas BDD**



El proyecto incorpora pruebas BDD mediante Cucumber.



Los escenarios se encuentran definidos en:



```text

src/test/resources/features/login.feature

```



Las pruebas validan escenarios de inicio de sesión utilizando credenciales válidas e inválidas.



La ejecución validada obtuvo:



```text

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS

```



**## Pipeline CI con Jenkins**



El pipeline está definido en el archivo `Jenkinsfile` y contiene las siguientes etapas:



1\. \*\*Checkout:\*\* obtiene el código desde el repositorio Git.

2\. \*\*Build:\*\* limpia y compila el proyecto mediante Maven.

3\. \*\*Unit Tests:\*\* ejecuta las pruebas unitarias.

4\. \*\*BDD Tests:\*\* ejecuta las pruebas BDD mediante Cucumber.

5\. \*\*Reports:\*\* procesa los resultados de las pruebas mediante Jenkins.



El pipeline utiliza comandos `bat` debido a que Jenkins se ejecuta en un entorno Windows.



El disparador `GitHub hook trigger for GITScm polling` se encuentra habilitado en la configuración del job de Jenkins.



**## Reportes**



Los resultados de las pruebas son generados por Maven Surefire en:



```text

target/surefire-reports/

```



Jenkins procesa los archivos XML mediante:



```groovy

junit 'target/surefire-reports/\*.xml'

```



Esto permite consultar los resultados de las pruebas desde la interfaz de Jenkins mediante un reporte navegable.



\## Pruebas de rendimiento



El proyecto incluye una plantilla de prueba de rendimiento desarrollada con JMeter:



```text

performance/login-performance.jmx

```



La plantilla contiene un endpoint de ejemplo que debe ser reemplazado por un endpoint real antes de utilizarla contra un sistema real.



Los principales indicadores considerados son:



\* TPS (transacciones por segundo).

\* Latencia.

\* Porcentaje de errores.



**## Alertas**



Como propuesta de mejora, se consideran alertas ante:



\* pruebas automatizadas fallidas;

\* latencia superior al umbral definido;

\* porcentaje de errores superior al umbral definido.



**## Control de versiones**



El proyecto utiliza Git para el control de versiones y GitHub como repositorio remoto.



Los cambios relevantes se registran mediante commits con mensajes descriptivos, permitiendo mantener un historial de modificaciones del proyecto.



**## Resultado**



El pipeline de Jenkins fue ejecutado correctamente, obteniendo:



```text

Pruebas unitarias:

Tests run: 2

Failures: 0

Errors: 0

Skipped: 0



Pruebas BDD:

Tests run: 3

Failures: 0

Errors: 0

Skipped: 0



Pipeline:

Finished: SUCCESS

```



