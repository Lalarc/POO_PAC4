******* Ejercicio 1 *******

* Employee.java el comentario javadoc del atributo "name" cambia de 70 chars por 50 chars.

* EmployeeTest.java corregido testToString para que sea:

assertEquals("Name: Lorem Ipsum\nAge: 39\nEmail: lorem@uoc.edu\nEducation level: UNDEFINED",employee.toString());


******* Ejercicio 2 *******

* Actualizado UML: 

  - Se ha quitado el m�todo eat() de SalariedEmployee porque no es del problema.

  - Se ha a�adido el tipo de retorno String al m�todo presentation(showSalary:boolean).

  - Se ha a�adido el par�metro "level" al constructor con par�metros de Employee.


******* Ejercicio 3 *******

* IntegrationCheck.java se ha a�adido la anotaci�n @Test al m�todo testIntegration3 para que se ejecute.

* IntegrationCheck.java se han cambiado las invocaciones a getEmmployees() por getEmployees().