******* Ejercicio 1 *******

* Employee.java el comentario javadoc del atributo "name" cambia de 70 chars por 50 chars.

* EmployeeTest.java corregido testToString para que sea:

assertEquals("Name: Lorem Ipsum\nAge: 39\nEmail: lorem@uoc.edu\nEducation level: UNDEFINED",employee.toString());


******* Ejercicio 2 *******

* Actualizado UML: 

  - Se ha quitado el método eat() de SalariedEmployee porque no es del problema.

  - Se ha añadido el tipo de retorno String al método presentation(showSalary:boolean).

  - Se ha añadido el parámetro "level" al constructor con parámetros de Employee.


******* Ejercicio 3 *******

* IntegrationCheck.java se ha añadido la anotación @Test al método testIntegration3 para que se ejecute.

* IntegrationCheck.java se han cambiado las invocaciones a getEmmployees() por getEmployees().