### Calidad de Software
## Principios SOLID
Integrantes:
  - Joe Cordero
  - Ariel Raura
  - Juan Javier Miño
# SRP

## Problemas Iniciales

El diseño inicial del sistema violaba el **Principio de Responsabilidad Única (SRP)**:
- La clase `UserManager` tenía múltiples responsabilidades:
  - Validación de correos electrónicos y contraseñas.
  - Persistencia de datos en la base de datos.
  - Envío de notificaciones de bienvenida.
- Este diseño hacía que la clase fuera difícil de mantener y propensa a errores:
  - Cualquier cambio en la lógica de validación, persistencia o notificaciones requería modificar `UserManager`.
  - Las pruebas unitarias eran más complicadas porque los métodos estaban acoplados.

## Cambios Realizados

1. **Dividimos la clase `UserManager` en varias clases independientes:**
   - `UserValidator`: Responsable de validar correos electrónicos y contraseñas.
   - `UserRepository`: Responsable de guardar los datos en una base de datos.
   - `NotificationService`: Responsable de enviar notificaciones.
2. **La clase `UserManager` ahora actúa como un "orquestador"**, coordinando las interacciones entre estas clases.
## Beneficios de la Refactorización
**Separación de responsabilidades:**
Cada clase tiene un propósito único, lo que reduce el acoplamiento y aumenta la cohesión.
**Facilidad de mantenimiento:**
Los cambios en la lógica de validación, persistencia o notificaciones no afectan las otras partes del sistema.
**Pruebas unitarias más simples:**
Cada clase puede probarse de forma independiente.
**Reutilización de código:**
Clases como UserValidator y NotificationService pueden reutilizarse en otros contextos.

## Cómo Probar
**Ejecuta el programa principal para verificar que los usuarios se agregan correctamente:**
mvn exec:java -Dexec.mainClass="SRP.Main"
**Ejecuta las pruebas unitarias:**
mvn test

Resultado con una entrada válida
![image](https://github.com/user-attachments/assets/8903c20e-8efa-4836-ad14-8401e7724409)

Resultado con una entrada vacía
![image](https://github.com/user-attachments/assets/7fd57c44-2613-4fa3-b36a-5d33b37aba91)

Resultado de la ejecución de pruebas
![image](https://github.com/user-attachments/assets/ac9adbdc-99e3-4dd7-bf25-106004b576f2)

# ISP

El diseño inicial del sistema violaba el Principio de Segregación de Interfaces (ISP):
- La interfaz `Device` incluía métodos que no eran aplicables a todos los dispositivos, como `charge()` para dispositivos no recargables.
- La clase `DisposableCamera` se veía obligada a implementar el método `charge()`, lo que causaba una excepción.
1. Dividimos la interfaz `Device` en dos interfaces más específicas:
   - `Switchable`: Para dispositivos que pueden encenderse y apagarse.
   - `Rechargeable`: Para dispositivos que pueden recargarse.
2. Ajustamos las clases para implementar solo las interfaces que necesitaban:
   - `Phone` implementa `Switchable` y `Rechargeable`.
   - `DisposableCamera` solo implementa `Switchable`.

## Beneficios de la Refactorización
- Cada clase implementa únicamente los métodos que necesita, reduciendo la complejidad.
- Eliminamos la necesidad de lanzar excepciones en métodos no aplicables.
- El diseño es más flexible y fácil de mantener.

## Cómo Probar
1. Ejecuta el programa.
2. Observa que los dispositivos recargables y no recargables funcionan correctamente, sin excepciones.



Resultado
![image](https://github.com/user-attachments/assets/6838c1ce-2b44-4282-b266-d3c2ac4b4014)


Resultado de la ejecución de pruebas
![image](https://github.com/user-attachments/assets/10980f9a-1a55-4ad6-a4d5-88b4d14c3b37)
