# Alertas

## Reglas propuestas

### Fallos funcionales
Si existen pruebas fallidas:
- marcar el pipeline como fallido;
- notificar al equipo.

### Latencia
Si latencia > 500 ms:
- generar alerta;
- revisar la ejecución.

### Errores
Si errores > 5%:
- generar alerta;
- detener la promoción del cambio.

## Flujo
Pruebas -> Métricas -> Evaluación de umbral -> Alerta
