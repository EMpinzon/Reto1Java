# Casteo (Conversion de tipos de datos)

```java
double num = 1.67;

//Casteo a entero
int numInt = (int) num;//1

//Casteo a long
long numLong = (long) numInt;//1

String cantidad = "15";
String precio = "150.27";

//Casteo a entero
int canEntero = Integer.parsInt(cantidad);
//Casteo a double
double precioDouble = Double.parseInt(precio);

int edad = 20;
double estatura = 1.75;

//Casteo a String
String edadString = String.valueOf(edad);
String estaturaString = String.valueOf(estatura);
```

El casteo, también conocido como "casting" en inglés, es el proceso de convertir un tipo de dato en otro en Java. El casteo puede ser implícito o explícito, y se utiliza para asegurar la compatibilidad de tipos en diferentes operaciones. Aquí, exploraremos los distintos tipos de casteo en Java.

## Casteo Implícito

El casteo implícito se produce cuando el compilador de Java realiza automáticamente la conversión de un tipo de dato a otro sin requerir una intervención explícita por parte del programador. Este tipo de casteo ocurre en situaciones donde no hay pérdida de datos y la conversión es segura.

### Ejemplo de Casteo Implícito

```java
int entero = 5;
double decimal = entero; // Casteo implícito de int a double
```

## Casteo Explícito

El casteo explícito se lleva a cabo cuando el programador indica directamente al compilador que realice la conversión de un tipo de dato a otro. Este tipo de casteo puede llevar a la pérdida de datos si la conversión no es segura.

### Ejemplo de Casteo Explícito

```java
double decimal = 3.14;
int entero = (int) decimal; // Casteo explícito de double a int
```

## Casteo entre Tipos Primitivos

### Casteo entre Tipos Numéricos

En Java, se pueden realizar casteos entre tipos numéricos, ya sea implícita o explícitamente. La siguiente lista muestra algunos de los posibles casteos:

- **Widening (Promoción):** Ocurre cuando se va de tipos de menor tamaño a tipos de mayor tamaño sin pérdida de datos.
    
    ```java
    byte b = 5;
    int i = b; // Casteo implícito de byte a int (promoción)
    ```
    
- **Narrowing (Reducción):** Se realiza de tipos de mayor tamaño a tipos de menor tamaño. Puede haber pérdida de datos.
    
    ```java
    double d = 3.14;
    int i = (int) d; // Casteo explícito de double a int (reducción)
    ```
    

### Casteo entre Tipos de Caracteres

- **Casteo entre char y numéricos:** Se puede realizar directamente entre `char` y tipos numéricos.
    
    ```java
    char c = 'A';
    int asciiValue = c; // Casteo implícito de char a int
    ```
    

## Casteo entre Tipos de Referencia

### Casteo entre Clases y Subclases

Cuando se trabaja con clases y subclases, es posible realizar casteo entre ellas.

```java
class Animal { }
class Perro extends Animal { }

Animal animal = new Perro();
Perro perro = (Perro) animal; // Casteo explícito de Animal a Perro
```

### Casteo entre Interfaces e Implementaciones

En el caso de interfaces y sus implementaciones, también es posible realizar casteo.

```java
interface Forma { }
class Circulo implements Forma { }

Forma forma = new Circulo();
Circulo circulo = (Circulo) forma; // Casteo explícito de Forma a Circulo
```

Es importante tener cuidado al realizar casteo entre tipos de referencia para evitar excepciones en tiempo de ejecución, como `ClassCastException`.

En Java, se puede realizar el casteo de un `enum` de una manera similar a otros tipos de datos. Sin embargo, hay algunas consideraciones específicas cuando se trata de casteo de enums.

Supongamos que tienes el siguiente enum:

```java
public enum Estado {
    ACTIVO, INACTIVO, PENDIENTE;
}
```

Aquí hay algunas formas comunes de trabajar con el casteo de enums:

### Casteo Implícito

Si deseas asignar un valor de un `enum` a una variable de otro tipo, puedes hacerlo de manera implícita siempre que ambos tipos sean compatibles.

```java
Estado estado = Estado.ACTIVO;
String estadoString = estado.name(); // Obtener el nombre del enum como String
```

### Casteo Explícito

Puedes realizar un casteo explícito si necesitas convertir el valor de un `enum` a otro tipo específico.

```java
Estado estado = Estado.ACTIVO;
int valorEntero = estado.ordinal(); // Obtener el índice del enum como int
```

En este ejemplo, `ordinal()` devuelve el índice del elemento en la enumeración. Ten en cuenta que el uso de `ordinal()` puede no ser la mejor opción si el orden de los elementos en el enum cambia, ya que eso afectaría el valor devuelto.

### Casteo desde un String

Si tienes un `String` y deseas convertirlo a un valor del `enum`, puedes usar el método `valueOf()` proporcionado por la clase del enum.

```java
String estadoString = "ACTIVO";
Estado estado = Estado.valueOf(estadoString); // Casteo desde String a enum
```

Ten en cuenta que `valueOf()` arrojará una excepción `IllegalArgumentException` si el nombre proporcionado no coincide con ninguno de los elementos del enum. Es importante manejar esta excepción para evitar errores inesperados.