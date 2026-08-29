Feature: Inicio de sesión

  Scenario: Usuario inicia sesión con credenciales válidas
    Given que existe un usuario registrado
    When ingresa usuario "admin" y contraseña "123456"
    And selecciona iniciar sesión
    Then el resultado esperado es "acceso"

  Scenario Outline: Validación de credenciales
    Given que existe un usuario registrado
    When ingresa usuario "<usuario>" y contraseña "<password>"
    And selecciona iniciar sesión
    Then el resultado esperado es "<resultado>"

    Examples:
      | usuario | password | resultado |
      | admin   | 123456   | acceso    |
      | admin   | 999999   | rechazo   |
