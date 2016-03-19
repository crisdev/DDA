## Práctica DDA2015

Ejercicios prácticos realizados en la clase de *Desarrollo de Algoritmos*,
segundo cuatrimestre del año 2015.

Los objetivos de cada ejercicio se indican en los comentarios. La versión
indica la fecha de creación.

Se utilizó JAVA como lenguaje de implementación.

Profesor a cargo: Luis Reynoso.

## Indice

### Trabajo Práctico 0: Repaso

* [Ejercicio 1](/src/trabajoPracticoN0/Ejercicio1.java)
> Implementar en Java el algoritmo indicado en el TP.
    
* [Ejercicio 6](/src/trabajoPracticoN0/Ejercicio6.java)
> En un evento realizado por la empresa de turismo Argentar se hizo una encuesta
> a algunas de las personas que asistieron.
>
> Se les preguntó: nombre, apellido, edad, cantidad de países visitados y
> estado civil.
> Las personas solteras con edad entre 45 y 62 años podían participar del sorteo
> de un viaje a Cataratas.
>
> En base a la información relevada se desea mostrar:
>
> 1. El promedio de edad de los asistentes encuestado.
> 2. El nombre y apellido de las personas que más países visitó.
> 3. Por cada persona indicar si podía o no participar del sorteo.

* [Ejercicio 7](/src/trabajoPracticoN0/Ejercicio7.java)
> En una exposición de vehículos se administra la información de los autos
> que están exhibidos. Para cada auto se desea conocer: patente, marca,
> de fabricación, color y capacidad (cantidad de personas sentadas y cinturón
> de seguridad disponible). En base a la información relevada se desea mostrar:
>
> 1. La cantidad de vehículos rojos.
> 2. La capacidad promedio de los autos exhibidos.
> 3. La marca de vehículos que más autos exhibe en la exposición.

### Trabajo Práctico 1: Modularización y Strings

* [Ejercicio 4](/src/trabajoPracticoN1/Ejercicio4.java)
> Resolver el siguiente problema aplicando modularización
> y conceptos de Strings:
> Solicitar al usuario un número binario y almacenar en
> un String de longitud n. Definir operaciones para:
> 
> 1. Obtener el valor del binario ingresado en decimal.
> 2. Obtener el complemento a uno del número binario.
> 3. Obtener el complemento a dos del número binario.

* [Ejercicio 5](/src/trabajoPracticoN1/Ejercicio5.java)
> Solicitar al usuario los elementos de dos conjuntos A y B de cardinalidad
> fija (digamos n). Cada conjunto estará compuesto por caracteres. Su solución
> deberá verificar que los conjuntos son válidos (no tienen elementos repetidos)
> y permitirá realizar operaciones entre conjuntos:
>
> - mostrar los elementos que lo componen
> - unión de conjuntos
> - diferencia entre conjuntos
> - intersección entre conjuntos

* [Ejercicio 6](/src/trabajoPracticoN1/Ejercicio6.java)
> Un multiconjunto permite que los elementos de un conjunto estén repetidos.
> Por ejemplo, el multiconjunto {a, a, b, b, b, c} tiene dos ocurrencias de
> "a", tres de "b", y una de "c". Defina adicionalmente una operación para
> determinar la multiplicidad de un elemento. Cada elemento de un multiconjunto
> tiene asociado una multiplicidad (un número natural), el cual indica cuántas
> veces el elemento es miembro del conjunto.
>
> Su solución deberá verificar que un multiconjunto es válido (puede contener
> elementos repetidos) y permitirá realizar operaciones entre multiconjuntos:
>
> - unión de conjuntos.
> - diferencia entre conjuntos (elimine múltiples ocurrencias).
> - intersección entre conjuntos.

* [Ejercicio 7](/src/trabajoPracticoN1/Ejercicio7.java)
> Solicitar al usuario los elementos de un conjunto A, compuesto por letras del
> abecedario. Definir operaciones para:
>
> - listar los elementos del conjunto
> - verificar que un elemento determinado por el usuario pertenece al conjunto
> - ordenar los elementos del conjunto utilizando el método del dibujo

### Trabajo Práctico 2: Arreglos unidimensionales

* [Ejercicio 1](/src/trabajoPracticoN2/Ejercicio1.java)
> Declare, cree e inicialice arreglos para cada uno de los siguientes casos:
> 1. Un arreglo de vocales.
> 2. Un arreglo de enteros consecutivos del 1 al 1000.
> 3. Un arreglo de los enteros impares consecutivos entre 10000 y 50000
> 4. Un arreglo de letras del abecedario (ordenadas alfabéticamente).
>    Considere que las letras del abecedario aparece en orden correlativo en la
>    tabla unicode.
> 5. Un arreglo de 50 números enteros aleatorios entre 0 y 100.
> 6. Un arreglo de 15 palabras.
> 7. Un arreglo de 15 temperaturas.
> 8. Un arreglo de 14 alturas de personas.

* [Ejercicio 2](/src/trabajoPracticoN2/Ejercicio2.java)
> Para cada arreglo de tipos de datos enteros o reales del ejercicio anterior
> calcule el valor promedio.

* [Ejercicio 3](/src/trabajoPracticoN2/Ejercicio3.java)
> Para los arreglos de los incisos e y f,
> definir métodos que permitan consultar si un número o una palabra
> (según corresponda) es parte del arreglo.

* [Ejercicio 4_4](/src/trabajoPracticoN2/Ejercicio4_4.java)
> Resolver el siguiente problema aplicando modularización
> y arreglos:
>
> Solicitar al usuario un número binario y almacenar en
> un String de longitud n. Definir operaciones para:
> 1. Obtener el valor del binario ingresado en decimal.
> 2. Obtener el complemento a uno del número binario.
> 3. Obtener el complemento a dos del número binario.

* [Ejercicio 4_5](/src/trabajoPracticoN2/Ejercicio4_5.java)
> Solicitar al usuario los elementos de dos conjuntos A y B de cardinalidad
> fija (digamos n). Cada conjunto estará compuesto por caracteres. Su solución
> deberá verificar que los conjuntos son válidos (no tienen elementos repetidos)
> y permitirá realizar operaciones entre conjuntos:
> - mostrar los elementos que lo componen
> - unión de conjuntos
> - diferencia entre conjuntos
> - intersección entre conjuntos

* [Ejercicio 6](/src/trabajoPracticoN2/Ejercicio6.java)
> Implementar en java el algoritmo selection sort.

* [Ejercicio 7](/src/trabajoPracticoN2/Ejercicio7.java)
> Implementar el algoritmo de búsqueda binaria.

* [Ejercicio 12](/src/trabajoPracticoN2/Ejercicio12.java)
> Implementar bubble sort e insertion sort y verificar la implementación con ejemplos.

### Trabajo Práctico 3: Arreglos bidimensionales

* [Ejercicio 1](/src/trabajoPracticoN3/Ejercicio1.java)
> Implementar las siguientes operaciones para matrices:
>
> 1. Mostrar los elementos de una matriz.
> 2. Verificar si una matriz es cuadrada.
> 3. Verificar si una matriz es triangular superior.
> 4. Verificar si una matriz es matriz diagonal.
> 5. Suma de matrices.
> 6. Producto por un escalar.
> 7. Transponer una matriz.
> 8. Sumar los elementos de una fila determinada.
> 9. Sumar los elementos de una columna.
> 10. Multiplicación de matrices.

* [Ejercicio 4](/src/trabajoPracticoN3/Ejercicio4.java)
> Supongamos que almacenamos en una matriz la cantidad de expedientes que
> un organismo del estado procesa por mes desde el año 2000.
> La matriz representará en sus filas los 12 meses y en columnas
> los años 2000, 2001, hasta el 2014 inclusive.
> Modularizando correctamente y haciendo reuso de módulos, definir módulos para:
>
> 1. Calcular la cantidad de expedientes procesados en un año determinado.
> 2. Calcular el promedioPorAño de expedientes procesador para un año determinado.
> 3. Obtener el mes en el cual se procesó la mayor cantidad de expedientes en el período 2000-2014.
> 4. Obtener el mes en el cual se procesó la menor cantidad de expedientes en el período 2000-2014.
> 5. Para un año determinado, digamos X, obtener un arreglo unidimensional ordenado
>    de sus producciones mensuales.
> 6. Obtener la mediana estadística de los expedientes procesados para un año X.
> 7. Determinar la varianza de expedientes para un año determinado.
> 8. Determinar los años en los cuales el desvío es superior a un valor M.
> 9. Calcular el promedio de expedientes procesados para igual mes en el periodo 2000-2014.
> 10. Calcular el promedio de expedientes procesados en un período de dos años X e Y.
> 11. Contar la cantidad de meses en que se han procesado más de X cantidad de
>    de expedientes para un determinado año Z.
> 12. Determinar la cantidad de meses (cualquiera sea el año) en el cual se hayan
>    procesado más de Y cantidad de expedientes.
> 13. Determinar si para algún mes de un año X, se han procesado más de Y cantidad
>    de expedientes.

### Trabajo Práctico 4: Tipo de dato abstracto (TDA)

#### Clases

* [Ejercicio 1](/src/trabajoPracticoN4/clases/Especie.java)
> Implementación TDA especie.

* [Ejercicio 2](/src/trabajoPracticoN4/clases/Racional.java)
> Implementar el TDA Racional respetando la definición dada en la guía.

* [Ejercicio 3](/src/trabajoPracticoN4/clases/Auto.java)
> Una empresa de alquiler de autos almacena la información de los autos que
> tiene para alquilar de la siguiente manera: cada auto está identificado
> por su patente (String de 6 caracteres), número registrado en el odómetro,
> modelo y si está disponible o no. Aplicando los conceptos vistos en teoría,
> implementar en Java la clase Auto de acuerdo a la especificación.

* [Ejercicio 4](/src/trabajoPracticoN4/clases/Conjunto.java)
> Construir el TDA para tratar la abstracción matemática Conjunto a partir
> de las operaciones detalladas más abajo, haciendo la correcta clasificación
> de las mismas: Constructoras, Observadoras, Modificadoras y Propias del tipo,
> que manejen conjuntos de números naturales del 1 al 100. Armar la caja UML
> de la clase Conjunto. (Ayuda: Usar un arreglo booleano).

* [Ejercicio 5](/src/trabajoPracticoN4/clases/Matriz.java)
> Especificar el esquema UML para una Matriz que posea una estructura capaz de
> almacenar una matriz de enteros de una dimensión definida por el usuario y
> permita realizar las operaciones matemáticas básicas de matrices (suma,
> resta, etc.).
> - Implementar el TDA Matriz
> - Implementar la clase testMatriz que permita probar toda la funcionalidad
>   del TDA

#### Tests

* [Ejercicio 1](/src/trabajoPracticoN4/clases/TestEspecie.java)
> Implementar la clase TestEspecie que permita probar la funcionalidad
> del TDA Especie. Es decir, cargar los datos de una o más especies, consultarlas,
> modificarlas y aplicar las operaciones propias del tipo.
>
> La especie rinoceronte tiene una población de 100 y una tasa de crecimiento de 15%
> y la especie elefante tiene una población de 10 y una tasa de crecimiento de 35%.
> ¿Cuántos años le llevará a la población elefante superar a la especie rinoceronte?

* [Ejercicio 2](/src/trabajoPracticoN4/clases/TestRacional.java)

* [Ejercicio 3](/src/trabajoPracticoN4/clases/TestAuto.java)
> Proveer al usuario un menú con las siguientes opciones:
> 1. Ingresar un auto: Permitir al usuario realizar la carga de uno o más autos.
> El usuario puede ingresar a esta opción de menú reiteradas veces.

* [Ejercicio 4](/src/trabajoPracticoN4/clases/TestConjunto.java)
> Escribir en Java una clase TestConjunto para probar todos los métodos implementados.

* [Ejercicio 5](/src/trabajoPracticoN4/clases/TestMatriz.java)
> Implementar la clase TestMatriz.

### Simulacro primer parcial

* [Matriz Diagonal](/src/simulacros/primerParcial/MatrizDiagonal.java)
> Implementar un módulo en Java que dada una matriz de NxN de caracteres
> verifique si todos los caracteres en las celdas ubicadas en la diagonal
> secundaria son iguales.

* [Numero Telefono](/src/simulacros/primerParcial/NumeroTelefono.java)
> En una provincia se están cambiando los números de teléfonos celulares de
> 8 dígitos de la siguiente manera: luego del 15 se agrega un 4, los 3 números
> sucesivos se invierten y se colocan al final. Por ejemplo el número 15560432
> queda 154432065. Implementar en pseudocódigo un algoritmo que dado un número
> de teléfono almacenado como cadena de caracteres genere el nuevo número.
> Resolver el ejercicio recorriendo en la cadena caracter por caracter.
>
> IMPORTANTE: La cadena de caracteres de entrada siempre tendrá una secuencia de
> dígitos que representa un número de celular, es decir que no posee espacios en
> blanco, ni caracteres especiales, y la longitud de la cadena de entrada es
> siempre 8.
* [Patinador](/src/simulacros/primerParcial/Patinador.java)
> En un club de patín artístico se ha organizado una exhibición que incluye a
> las siguientes categorías: A, B, C, I (intermedia) y P (principiante).
> Los datos de los patinadores están almacenados en un arreglo de Patinador.
> Se debe implementar la clase Patinador especificada en el UML y un programa
> que permita implementar el TDA Patinador con la definición de los atributos y
> la implementación de los siguientes métodos: constructores, una operación
> observadora a elección, el método toString, una operación modificadora a
> elección y las operaciones propias del tipo.

* [TestPatinador](/src/simulacros/primerParcial/TestPatinador.java)
> Implementar la clase TestPatinador que a través de un menú de opciones permita:
> 1. Carga los datos de los patinadores. El arreglo será dimensionado con un
>    valor ingresado por el usuario, ya que la cantidad de participantes del
>    evento es conocida.
> 2. Mostrar por pantalla los datos de todos los patinadores que pertenecen a
>    una categoría dada.
> 3. Dado el documento de un patinador, cambiar su categoría de la siguiente manera:
>    iniciando en categoría P: P -> I -> C -> B -> A. Un patinador de categoría A
>    no puede aumentar su categoría, por lo tanto mantiene la categoría A. Este
>    método debe usar asciendeCategoria() de Patinador.

### Trabajo Práctico 6: Métodos de Ordenación y Búsqueda

* [Ejercicio 1](/src/trabajoPracticoN6/Ejercicio1.java)
> Realizar el pseudocódigo y la implementación en Java de un método que
> reciba un arreglo de números enteros y verifique si los elementos del
> arreglo respetan un orden creciente o no.
> Calcular su tiempo de ejecución.

* [Ejercicio 2](/src/trabajoPracticoN6/Ejercicio2.java)
> Realizar el pseudocódigo y la implementación Java de un método que reciba
> un arreglo ordenado (en forma creciente) de números enteros y un valor n,
> y verifique si n está en el arreglo, utilizando los métodos de búsqueda:
> - Secuencial
> - Búsqueda binaria
>
> Indicar la técnica algorítmica utilizada. Calcular el tiempo de ejecución de
> cada algoritmo.

* [Ejercicio 3](/src/trabajoPracticoN6/Ejercicio3.java)
> Realizar el pseudocódigo y la implementación en java de un método de ordenación
> para cada esquema algorítmico que se lista a continuación:
>
> 1. Fuerza bruta
> 2. Disminuye y vencerás
>
> El algoritmo recibe un arreglo de números enteros y los ordena de menor a mayor
> (orden creciente). Calcular el tiempo de ejecución de cada algoritmo.
>
> En cada método, ¿qué sentencias deben cambiar para ordenar el arreglo en orden decreciente?

* [Ejercicio 4](/src/trabajoPracticoN6/Ejercicio4.java)
> Realizar el pseudocódigo y la implementación en java de un método que reciba
> como datos de entrada dos arreglos de enteros ordenados en forma creciente,
> de dimensiones n y m respectivamente, y obtenga un tercer arreglo,
> también ordenado en forma creciente, de dimensión n+m.
>
> Ejemplo, si A = [3,7,10,15] y B = [5,6,7] entonces C = [3,5,6,7,7,10,15].
> Calcular su tiempo de ejecución.

* [Ejercicio 5](/src/trabajoPracticoN6/Ejercicio5.java)
> Realizar el pseudocódigo y la implementación en java del método de la burbuja
> mejorado, que consiste en finalizar las iteraciones del método burbuja,
> cuando en el último recorrido no se han realizado cambios.

### Trabajo Práctico 7: Recursividad

* [Ejercicio 3](/src/trabajoPracticoN7/Ejercicio3.java)
> Escribir un planteo recursivo, desarrollar su implementación en java y realizar
> la traza indicada para:
>
> 1. Contar la cantidad de dígitos de un número entero positivo n. Realizar la traza para n = 32154.
> 2. Dado un número entero positivo n y un dígito t, contar la cantidad de veces que aparece el
> dígito t en el número n. Por ejemplo si n = 13234 y t = 3, el resultado debe ser 2.
>
> Realizar la traza para los valores del ejemplo.

* [Ejercicio 4](/src/trabajoPracticoN7/Ejercicio4.java)
> Escribir las siguientes rutinas recursivas en java, realizando las respectivas
> trazas sobre el siguiente arreglo unidimensional:
> v = {12, 7, 0, -1, 8, 10}
>
> 1. Dado un número entero n, devolver verdadero si n se encuentra en v y falso
> en caso contrario. Traza para n = 8 y n = 6.
> 2. Devolver el valor de verdad en una función que determine si los elementos
> del arreglo respetan un orden creciente o no.

* [Ejercicio 5](/src/trabajoPracticoN7/Ejercicio5.java)
> Dada una secuencia S de números enteros positivos (finalizada en 0, que no se
> considera parte de la secuencia) ingresados por teclado, escribir planteos
> recursivos, sus correspondientes métodos, y realizar la traza para la secuencia
> 2 5 3 6 12 3 0 en los siguientes incisos:
>
> 1. Calcular cuántos enteros múltiplos de 4 hay en la secuencia.
> 2. Determinar el máximo entero perteneciente a la secuencia.

* [Ejercicio 6](/src/trabajoPracticoN7/Ejercicio6.java)
> Dada una secuencia de caracteres (finalizada en ".") ingresada por teclado,
> escribir planteos recursivos, desarrollar sus correspondientes métodos y
> realizar la traza de cada inciso.
>
> 1. Mostrar en orden inverso todos los caracteres de la secuencia distintos
> a un caracter dado.
> 2. Determinar la cantidad de veces que aparece un carácter dado en la secuencia.

### Trabajo final de promoción

* [Aleatorio](/src/trabajo/Aleatorio.java)
> Generador de elementos aleatorios.

* [CuitCuil](/src/trabajo/CuitCuil.java)
> Tanto el CUIT (Clave Única de Identificación Tributaria) como la CUIL
> (Clave Única de Identificación Laboral) constan de tres partes:
> El tipo, el número y el dígito verificador separados por guión.
> En el siguiente ejemplo se toma como CUIT el número ##-12345678-X donde
> ## es el tipo, 12345678 es el número de DNI o número de sociedad y X es
> el dígito verificador.
>
> El tipo puede ser 20, 23 y 27 para personas físicas sin importar el género o
> identidad; o 30, 33 para empresas o personas jurídicas.

* [Ordenamiento](/src/trabajo/Ordenamiento.java)
> Esta clase incluye los métodos de ordenamiento implementados
> sobre la clase TestPersona: INSERTION, SELECTION, BUBBLE, MERGE, QUICK y HEAP.

* [Persona](/src/trabajo/Persona.java)
> Implementar un TDA Persona que modelará tanto a personas física o jurídicas
> con los siguientes atributos:
> 1. CUIT-CUIL de la cuitcuil (haga uso del TDA definido anteriormente)
> 2. Nombre o razón social, contendrá el apellido e identificacion de la persona o la razón social de la empresa.
> 3. Calle del domicilio fiscal.
> 4. Número del domicilio fiscal.
> 5. Código postal del domicilio fiscal.
> 6. Provincia del domicilio fiscal.

* [TestPersona](/src/trabajo/TestPersona.java)
> Implementar un TDA TestPersona, que permita cargar un conjunto de personas
> (física y jurídicas).
> Implementar los siguientes métodos:
> - Método para recuperar aquellas personas físicas cuyo nombre contenga la cadena "SUAREZ"
> - Método de OrdenamientoIsertionSort() para ordenar el arreglo de personas según su CUIT-CUIL
> - Método de OrdenamientoSelectionSort() para ordenar el arreglo de personas según su CUIT-CUIL
> - Método de OrdenamientoBurbujaSort() para ordenar el arreglo de personas según el CUIT-CUIL
> - Método de busquedaSecuencial() para buscar un elemento en un arreglo ordenado de CUIT-CUIL
> - Método de busquedaBinaria() para buscar un elemento en un arreglo ordenado de CUIT-CUIL
> - Método para recuperar las personas físicas de una localidad determinada (dado su código postal)
> - Método para recuperar las personas jurídicas de una localidad determinada (dado su código postal)
>   y calle determinada