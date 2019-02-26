# pruebaalgarcia
Prueba
El aplicativo esta escrito usando springboot y fue desarrollado con eclipse. 

Se debe importar el proyecto en el workspace de eclipse y se debe construrir desde el pom.xml cuando se vaya ejecutar por primera vez. 
Para hacr la construcción es necesario dar clic derecho en el pom.xml y luego Run As para luego dar clic en 6 Maven Install

Una vez finaliza la construcción es necesario buscar la clase Application que se encuentra en src/main/java/pruebaalgarcia.com.algarcia.tree y dar clic derecho y luego Run As -> Java Application. 
SpringBoot cargará el servidor embebido y publicara los recursos rest que resuelven el problema. 

Se publicaron los recursos create para crear el el arbol y getCommon para obtener el ancestro comun. 

create lleva como parametro values al cual se le enviaran los valores a ser agregados en el arbol separados por comas. Cada vez que se ejecuta este request los valores son agregados al arbol 

getCommon tiene como parametros los valores nodo1 y nodo2 los cuales son el valor de cada nodo y devolvera el nodo comun. 

Los siguientes son ejemplos de los recursos usados para hacer las pruebas segun el documento que se adjuntó 

http://localhost:8080/create?values=70,84,85
http://localhost:8080/create?values=70,84,78,80
http://localhost:8080/create?values=70,84,78,76
http://localhost:8080/create?values=70,49,54,51
http://localhost:8080/create?values=70,49,37,40
http://localhost:8080/create?values=70,49,37,22

http://localhost:8080/getCommon?nodo1=40&nodo2=78 
