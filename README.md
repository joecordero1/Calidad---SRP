### Calidad de Software
## Principios SOLID
# SRP

El cambio de tener una sola clase UserManager a dividirla en varias clases individuales siguiendo el Principio de Responsabilidad Única (SRP) mejora considerablemente la calidad y mantenibilidad del código. Antes, UserManager manejaba varias responsabilidades: validación de datos, persistencia en la base de datos y envío de notificaciones. Esto violaba el SRP porque un cambio en cualquiera de estas responsabilidades requeriría modificar la misma clase, lo que aumentaba el riesgo de introducir errores y dificultaba la prueba y la evolución del sistema.

Con la refactorización, cada responsabilidad está encapsulada en su propia clase:

UserValidator se encarga únicamente de validar correos electrónicos y contraseñas.
UserRepository se ocupa de la persistencia de los usuarios en la base de datos.
NotificationService gestiona el envío de notificaciones, como los correos electrónicos de bienvenida.

Resultado con una entrada válida
![image](https://github.com/user-attachments/assets/8903c20e-8efa-4836-ad14-8401e7724409)

Resultado con una entrada vacía
![image](https://github.com/user-attachments/assets/7fd57c44-2613-4fa3-b36a-5d33b37aba91)
