# Expresiones Lambda

- Representan funciones en Java que generalmente son anónimas y se definen en líneas donde se utilizan.
- Pueden recibir cero o mas argumentos y devolver uno o ningún valor.
- Tienen acceso a variables locales del ámbito al que pertenecen, pero se limita su capacidad de modificarlas, permitiendo solo lectura.

### Interfaces funcionales mas destacadas en java.util.function

- `Supplier` Para generar objetos sin necesidad de argumentos, par inicialización perezosa
- `Consumer` Acepta un objeto de tipo T sin devolver ningún valor
- `Funtion<T,R>` Define una función que acepta un parámetro de tipo T y devuelve un resultado de tipo T puede aplicar transformaciones u operaciones
- `BiFuntion<T,R,S>` Permite definir una función que acepta dos parámetros de tipo T y , devolviendo un resultado del tipo S. Generalmente, se utilizan para operaciones binarias como suma, resta, etc.
- `Predicate` Esta interfaz debe devolver un booleano dado un objeto de tipo T, comúnmente empleada para filtrar elementos de una colección.

## Consumer

Es una interfaz funcional que representa un operación que acepta un solo argumento de entrada y no devuelve nada

Se utiliza normalmente para realizar acciones o efectos secundarios sobre un objeto, como imprimirlo en la consola, agregarlo a una colección, o cualquier otra operación que no requiera devolver un valor.

```java
// Creación de un Consumer<String> usando una expresión lambda
Consumer<String> consumidor = saludo -> {
    // Se declara una variable local llamada lenguaje
    String lenguaje = "Java";
    
    // Se imprime el saludo concatenado con una cadena adicional
    System.out.println(saludo + " Bienvenid@ a " + lenguaje + "!");
};

// Se invoca el método accept del Consumer con un argumento "Hola Pepe"
consumidor.accept("Hola Pepe");
```

En este código se utiliza una expresión lambda para crear una instancia de la interfaz funcional Consumer<T> en Java. La interfaz Consumer tiene un único método llamado accept, que toma un argumento y realiza alguna acción sin devolver ningún resultado.
En este caso, se crea un Consumer de tipo String llamado consumidor. La expresión lambda asociada a este Consumer toma un String (llamado saludo en este contexto), realiza una operación que incluye concatenar este saludo con una cadena adicional y luego imprimir el resultado en la consola.
Cuando se llama a consumidor.accept("Hola Pepe");, la expresión lambda se ejecuta, imprimiendo en la consola el saludo personalizado, que en este caso sería "Hola Pepe Bienvenid@ a Java!".

Tambien se puede usar un Consumer que reciba dos parámetros con `BiConsumer`

```java
// Creación de un BiConsumer<String, String> usando una expresión lambda
BiConsumer<String, String> consumidor = (nombre, saludo) -> {
    // Se declara una variable local llamada lenguaje
    String lenguaje = "Java";

    // Se imprime el saludo, nombre y una cadena adicional
    System.out.println(saludo + " " + nombre + " Bienvenid@ a " + lenguaje + "!");
};

// Se invoca el método accept del BiConsumer con dos argumentos "Pepe" y "Hola"
consumidor.accept("Pepe", "Hola");
```

Puede usarse referencia de métodos en Java que proporcionan una forma mas concisa de expresar algunas expresiones lambda.  

### Referencias con métodos con Consumer

 

También es posible utilizar referencias de métodos en Java que proporcionan una forma más concisa de expresar ciertas expresiones lambda. En el caso de interfaces funcionales como Consumer, se pueden utilizar referencias de métodos para referenciar un método existente en lugar de proporcionar una implementación directa. Hay varios tipos de referencias de métodos, y uno de ellos es la referencia a un método de instancia.

```java
public class Saludador {
    public static void saludar(String mensaje) {
        System.out.println("Saludo: " + mensaje);
    }
}
```

```java
// Referencia de método a un método estático
Consumer<String> consumidor = Saludador::saludar;

// Uso del consumidor con la referencia de método
consumidor.accept("Hola, cómo estas?");
```

En este ejemplo, Saludador::saludar es una referencia al método estático saludar en
la clase Saludador. La interfaz funcional Consumer<String> espera un método
accept que toma un parámetro String, y la referencia de método proporciona esa
implementación.

```java
Consumer<String> consumidor = mensaje -> Saludador.saludar(mensaje);
```

## Supplier

Se usa para representar un proveedor de resultados.

No toma ningún argumento pero produce un resultado de tipo `T`

```java
// Supplier que suministra un número aleatorio entre 1 y 100
Supplier<Integer> generadorAleatorio = () -> new Random().nextInt(100) + 1;

// Obtener el resultado del Supplier
int numeroAleatorio = generadorAleatorio.get();

System.out.println("Número aleatorio: " + numeroAleatorio);
```

```java
// Supplier que suministra una cadena constante
Supplier<String> proveedorCadena = () -> "Hola, este es un ejemplo de Supplier.";

// Obtener el resultado del Supplier
String cadenaSuministrada = proveedorCadena.get();

System.out.println(cadenaSuministrada);
```

### Referencias con métodos

```java
public class GeneradorAleatorio {
    public static int generarNumero() {
        return new Random().nextInt(100) + 1;
    }
}
```

```java
// Referencia de metodo estatico
Supplier<Integer> generadorAleatorio = GeneradorAleatorio::generarNumero;

// Obtener el resultado del Supplier
int numeroAleatorio = generadorAleatorio.get();

System.out.println("Número aleatorio: " + numeroAleatorio);
```

# Funciones Lambda

- Reduce los literales asociados a cada opción
- Disminuye la cantidad de código

La sintaxis experimenta ciertos cambios con respecto al Java tradicional, ya que se evita escribir los tipos de las variables siempre que no surja ambigüedad.

```java
Function<String, Integer> sizeOf1 = (String s) -> {
    return s.length();
};

//O su equivalente más conciso:
Function<String, Integer> sizeOf2 = s -> s.length();
```

En ambos casos, se está definiendo una función que, dado un String, devolverá la longitud de la cadena de caracteres almacenada. Es notable que el tipo de la variable s se infiere automáticamente de los tipos utilizados en sizeOf, y la palabra reservada return no es necesaria, siempre y cuando no haya más de una sentencia en la función.
A pesar de la sintaxis compacta y peculiar, simplemente representa otra manera de expresar la siguiente clase; de hecho, esto es 10 que realmente genera el compilador:

Para usar tanto la función sizeOf como la clase SizeOf en un bloque de código, se haría de la siguiente manera:

```java
public class SizeOf implements Function<String, Integer> {
    public Integer apply(String s) {
        return s.length();
    }
}

public class Main {
    public static void main(String[] args) {
        SizeOf sizeOf = new SizeOf();
        Integer r1 = sizeOf.apply("hola java 8");
        // o
        Integer r2 = new SizeOf().apply("hola java 8");
    }
}
```

Esta última función lambda es del tipo BiFunction, que acepta dos objetos de tipo Persona y devuelve un int, típico de cualquier comparador de java.util.Comparator<T>. Tanto la función como el comparador son compatibles, por 10 que la función lambda anónima también se podría haber almacenado en una variable de tipo comparador para su uso posterior:

```java
public class Persona {
    String nombre;
    Persona(String nombre) {
        this.nombre = nombre;
    }
}

List<Persona> personas = new ArrayList<>();
personas.add(new Persona("Pepe"));
personas.add(new Persona("Andrés"));

personas.sort((l, r) -> l.nombre.compareTo(r.nombre));
```

```java
Comparator<Persona> comp = (l, r) -> l.nombre.compareTo(r.nombre);
personas.sort(comp);
```

## Predicate

Predicate es una interfaz funcional que representa una condición o predicado booleano. Esta interfaz tiene un único método llamado test que acepta un argumento y devuelve true o false según si la condición se cumple o no. Supongamos que se tiene una lista de números y se desea filtrar aquellos que son pares utilizando un Predicate.

```java
public static void main(String[] args) {
    // Lista de números
    List<Integer> numeros = new ArrayList<>();
    numeros.add(1);
    numeros.add(2);
    numeros.add(3);
    numeros.add(4);
    numeros.add(5);

    // Predicate para filtrar números pares
    Predicate<Integer> esPar = num -> num % 2 == 0;

    // Filtrar números pares
    List<Integer> numerosPares = filtrarNumeros(numeros, predicado:esPar);

    // Imprimir números pares
   System.out.println("Números Pares: " + numerosPares);
}
```

```java
private static List<Integer> filtrarNumeros(List<Integer> numeros, 
																						Predicate<Integer> predicado) {
    List<Integer> resultado = new ArrayList<>();
    for (Integer num : numeros) {
        if (predicado.test(num)) {
            resultado.add(num);
        }
    }
    return resultado;
}
```

- Definición de la Lista de Números: Se crea una lista de números del 1 al 5.
- Creación del Predicate para Números Pares: se crea un Predicate llamado esPar, que evalúa si un número es par.
- Filtrar Números Pares: Se llama a la función filtrarNumeros pasando la lista de números y el Predicate esPar. Esto crea una nueva lista llamada numerosPares que contiene solo los números pares.
- Método para Filtrar Números: EI método filtrarNumeros toma una lista de números y un Predicate, luego itera sobre los números y agrega aquellos que cumplen con la condición del Predicate a una nueva lista llamada resultado.
- Imprimir Números Pares: Se imprime la lista de números pares. En este caso,
la salida será: Números Pares: [2, 4].

## Expresiones Lambda propias

Para crear expresiones lambda propias se necesita crear una interfaz que sea funcional. Supongamos que se requiere crear una interfaz llamada Calculadora

La anotación @Functionallnterface es opcional, pero ayuda a señalar que esta
interfaz tiene exactamente un método abstracto, 10 cual es necesario para ser
considerada funcional.

```java
@FunctionalInterface
public interface Calculadora {
    int operacion(int a, int b);
}

//Se utiliza la expresion lambda para implementar la interfaz funcional
Calculadora suma = (a,b) -> a + b; 
```

1. Crear una interfaz que sea funcional`@FuntionalExecption` anotación que indica que la interfaz es funcional y, por lo tanto solo tiene un método abstracto 
2. Se utilizan expresiones lambda para implementar la interfaz funcional 
    1. Se crea una instancia de la interfaz funcional
3. Finalmente se crea las instancias en la clase principal 

```java
// Uso de la instancia 'suma'
System.out.println("Suma: " + suma.operacion(a:5, b:3));

// Uso de la instancia 'resta'
System.out.println("Resta: " + resta.operacion(a:5, b:3));
```