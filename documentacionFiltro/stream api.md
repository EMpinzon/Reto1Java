# Stream API

EI API Stream de Java proporciona una forma concisa y funcional de realizar
operaciones en secuencias de elementos, como colecciones. Los streams permiten
encadenar operaciones para realizar tareas de procesamiento de datos de manera
más eficiente y legible. Un Stream consiste en una secuencia de elementos que
pueden ser procesados en paralelo o de manera secuencial.

Permite crear flujos de datos continuos que contiene operadores para procesar
secuencias de elementos.
Los operadores reducen notablemente las tareas de transformaciones.
Transforma y compone flujos con los operadores map, filter, concat, distinct(),
flatmap, sorted, foreach, reduce, etc.
Pueden ser creados desde listas, arreglos, rangos.
Son inmutables, es decir, que las instancias de los streams no se pueden
modificar.

### Conversión de List a Stream

Puedes convertir una `List` a un `Stream` utilizando el método `stream()` de la interfaz `List`:

```java
List<String> lista = Arrays.asList("manzana", "banana", "cereza");

Stream<String> streamDeLista = lista.stream();

```

### Crear un Stream con `Stream.of()`

Puedes crear un `Stream` directamente utilizando el método estático `of()` de la clase `Stream`:

```java
Stream<String> streamDirecto = Stream.of("manzana", "banana", "cereza");

```

### Crear un Stream a partir de un arreglo

Puedes convertir un arreglo en un `Stream` usando el método estático `stream()` de la clase `Arrays`:

```java
String[] frutasArray = {"manzana", "banana", "cereza"};

Stream<String> streamDeArreglo = Arrays.stream(frutasArray);

```

### Crear un Stream con `Stream.builder()`

Puedes utilizar un `Stream.Builder` para construir un `Stream` de manera más dinámica:

```java
Stream.Builder<String> builder = Stream.builder();

builder.add("manzana")
       .add("banana")
       .add("cereza");

Stream<String> streamConBuilder = builder.build();

```

### Crear un Stream a partir de una colección

Si ya tienes una colección, como un `Set` o un `List`, puedes obtener un `Stream` a partir de ella llamando al método `stream()` de la interfaz `Collection`:

```java
Set<String> frutasSet = new HashSet<>(Arrays.asList("manzana", "banana", "cereza"));

Stream<String> streamDeColeccion = frutasSet.stream();
```

Estos ejemplos cubren diferentes maneras de crear y trabajar con Streams en Java. Recuerda que una vez que tienes un `Stream`, puedes aplicar una variedad de operadores para realizar transformaciones y operaciones en los elementos del Stream.

```java
Stream<String> animales = Stream.of(values: "Pato", values: "Gato", values: "Perro");
animales.forEach(e -> System.out.println(e));
```

Este código utiliza el API Stream de Java para crear un stream de strings que
representa una secuencia de nombres de animales y luego imprime cada elemento
del stream en la consola.

1. Creación del Stream: Aquí se utiliza el método estático of de la interfaz Stream
para crear un stream de strings con los valores "Pato", "Gato" y "Perro".
2. Operación terminal forEcah: La operación terminal forEach realiza una acción
para cada elemento del stream. En este caso, se utiliza una expresión lambda
(e -> System.out.println(e)) que imprime cada elemento del stream en la
consola.

### Crear un Stream a partir de un arreglo

1. Creación del arreglo de strings: Se crea un arreglo de strings llamado
miArreglo con tres elementos: "Patol', "Gato" y "Perro".
2. Creación del stream a partir del arreglo: Utiliza Arrays.stream() para convertir
el arreglo miArreglo

Stream de strings llamado animales. Un Stream una secuencia de elementos que permite operaciones en colecciones de manera funcional.

```java
String[] miArreglo = {"Pato", "Gato", "Perro"};
Stream<String> animales = Arrays.stream(miArreglo);
animales.forEach(e -> System.out.println(e));
```

### Crear un Stream  - Stream.<>builder()

Este Código utiliza la clase Stream.Builder para construir un Stream de strings y luego imprime cada elemento del stream.

1. Creación del Stream.Builder:  Se utiliza para crear un constructor de streams que construirá un Stream después de Stream. es una inferencia de tipo que especifica el tipo de elementos en el stream. 
2. Añadir elementos al builder: Se añaden elementos al builder utilizando el método
add. En este caso, se añaden los strings "Pato", "Gato" y "Perro" al builder.
3. Construcción del Stream: Se llama al método build() para finalizar la construcción del
Stream. En este punto, el Stream contiene los elementos añadidos al builder.
4. Iteración sobre los elementos del stream: Utiliza el método forEach del Stream para
iterar sobre cada elemento del stream. La expresión lambda (e -> System.out.println(e))
se aplica a cada elemento, imprimiéndolo en la consola.
    - e es el parámetro de la expresión lambda que representa cada elemento del stream.
    - System.out.println(e) imprime cada elemento en una nueva línea.

```java
Stream<String> animales = Stream.<String>builder()
    .add("Pato")
    .add("Gato")
    .add("Perro")
    .build();

animales.forEach(e -> System.out.println(e));
```

### Crear un Stream a partir de una colección

```java
List<String> lista = new ArrayList<>();
lista.add("Pato");
lista.add("Gato");
lista.add("Perro");
Stream<String> animales = lista.stream();
animales.forEach(e -> System.out.println(e));
```

Este código utiliza Java Streams para convertir una lista de strings en un stream y luego
imprimir cada elemento del stream.
Creación de una lista de strings: Se crea una instancia de la clase ArrayList que
contendrá elementos de tipo String. Luego, se añaden tres strings ("Pato", "Gato",
"Perro") a la lista usando el método add().

Creación de un Stream a partir de la lista: Utilizando el método stream() de la interfaz
Collection (implementada por ArrayList), se obtiene un Stream que representa la
secuencia de elementos en la lista. En este caso, se obtiene un Stream de strings.
Iteración sobre los elementos del stream:Se utiliza el método forEach del Stream para
iterar sobre cada elemento del stream. La expresión lambda (e -> System.out.println(e))
se aplica a cada elemento, imprimiéndolo en la consola.

- e es el parámetro de la expresión lambda que representa cada elemento del stream.
- System.out.println(e) imprime cada elemento en una nueva línea.

## Operadores

### map

Es un operados intermedio en Java Stream API que se utiliza para transformar cada elemento de un stream aplicando una función dada. 

→ Toma una función como argumento y devuelve un nuevo stream que contiene los resultados de aplicar esta función a cada elemento del Stream original

```java

```

Impresión con  forEach: 

# Operaciones

Las operaciones en Stream API de Java se pueden clasificar en dos categorías principales: operaciones intermedias y operaciones terminales.

### Operaciones Intermedias:

1. **Características**:
    - Las operaciones intermedias son aquellas que se aplican a un flujo y devuelven otro flujo.
    - Estas operaciones no inician la ejecución de la transmisión. Se realizan de manera perezosa (lazy), lo que significa que la evaluación se posterga hasta que se invoca una operación terminal.
    - Pueden ser encadenadas para formar una secuencia de operaciones que se aplicarán secuencialmente al flujo de datos.
2. **Ejemplos**:
    - `filter(Predicate<T> predicate)`
    - `map(Function<T, R> mapper)`
    - `sorted()`
    - `distinct()`

### Operaciones Terminales:

1. **Características**:
    - Las operaciones terminales son aquellas que cierran el flujo y producen un resultado final o un efecto secundario.
    - Inician la ejecución de la transmisión y consumen los elementos del flujo.
    - Después de la aplicación de una operación terminal, no se puede seguir operando en el mismo flujo.
2. **Ejemplos**:
    - `forEach(Consumer<T> action)`
    - `collect(Collector<T, A, R> collector)`
    - `reduce(BinaryOperator<T> accumulator)`
    - `count()`
    - `anyMatch(Predicate<T> predicate)`

### Cuándo usar cada tipo:

- **Operaciones Intermedias**:
    - Se utilizan para realizar transformaciones o filtrados en los datos sin afectar al flujo original.
    - Son ideales cuando deseas aplicar múltiples transformaciones o filtros antes de realizar una acción final.
- **Operaciones Terminales**:
    - Se utilizan para producir un resultado final o realizar una acción final en el flujo, como imprimir, contar o recolectar los elementos.
    - Después de una operación terminal, el flujo original ya no se puede utilizar para aplicar más operaciones intermedias.

### Operaciones intermedias:

1. **`filter(Predicate<T> predicate)`**: Filtra elementos según el predicado dado.
    
    ```java
    stream.filter(x -> x > 5)
    ```
    
2. **`map(Function<T, R> mapper)`**: Transforma cada elemento de la secuencia utilizando la función dada.
    
    ```java
    stream.map(x -> x * 2)
    ```
    
3. **`flatMap(Function<T, Stream<R>> mapper)`**: Transforma cada elemento en una secuencia de cero o más elementos y luego aplana las secuencias resultantes en una sola secuencia.
    
    ```java
    stream.flatMap(str -> Stream.of(str.split("")))
    ```
    
4. **`distinct()`**: Elimina elementos duplicados de la secuencia.
    
    ```java
    stream.distinct()
    ```
    
5. **`sorted()`** o **`sorted(Comparator<T> comparator)`**: Ordena los elementos de la secuencia, opcionalmente utilizando el comparador proporcionado.
    
    ```java
    stream.sorted()
    ```
    
6. **`peek(Consumer<T> action)`**: Realiza una acción para cada elemento de la secuencia sin modificarla.
    
    ```java
    stream.peek(System.out::println)
    ```
    

### Operaciones terminales:

1. **`forEach(Consumer<T> action)`**: Ejecuta una acción para cada elemento de la secuencia.
    
    ```java
    stream.forEach(System.out::println)
    ```
    
2. **`collect(Collector<T, A, R> collector)`**: Realiza una reducción mutable en los elementos de la secuencia utilizando el colector especificado.
    
    ```java
    List<String> collectedList = stream.collect(Collectors.toList())
    ```
    
3. **`reduce(BinaryOperator<T> accumulator)`**: Combina los elementos de la secuencia en un solo resultado aplicando repetidamente el operador proporcionado.
    
    ```java
    Optional<Integer> sum = stream.reduce(Integer::sum)
    ```
    
4. **`count()`**: Devuelve el número de elementos en la secuencia.
    
    ```java
    long count = stream.count()
    ```
    
5. **`anyMatch(Predicate<T> predicate)`**, **`allMatch(Predicate<T> predicate)`**, **`noneMatch(Predicate<T> predicate)`**: Verifica si algún, todos o ninguno de los elementos cumplen con el predicado dado.
    
    ```java
    boolean anyMatch = stream.anyMatch(x -> x > 5)
    ```
    
6. **`findFirst()`**, **`findAny()`**: Devuelve el primer elemento de la secuencia o cualquier elemento de la secuencia.
    
    ```java
    Optional<String> firstElement = stream.findFirst()
    ```
    

# Operadores

La Stream API en Java proporciona una forma más concisa y funcional de realizar operaciones en colecciones de datos. Los operadores de Stream son métodos que se pueden encadenar para realizar operaciones en los elementos de un Stream. Aquí hay una guía básica de algunos operadores comunes en la Stream API de Java, junto con ejemplos prácticos.

### 1. `filter`

El operador `filter` se utiliza para seleccionar elementos que cumplan con cierta condición.

```java
List<String> lista = Arrays.asList("manzana", "banana", "cereza", "uva");

List<String> frutasFiltradas = lista.stream()
                                    .filter(f -> f.startsWith("b"))
                                    .collect(Collectors.toList());

System.out.println(frutasFiltradas); // Salida: [banana]
```

### 2. `map`

El operador `map` se utiliza para transformar cada elemento del Stream aplicando una función.

```java
List<String> lista = Arrays.asList("manzana", "banana", "cereza");

List<Integer> longitudes = lista.stream()
                               .map(String::length)
                               .collect(Collectors.toList());

System.out.println(longitudes); // Salida: [7, 6, 6]
```

### 3. `forEach`

El operador `forEach` ejecuta una acción para cada elemento del Stream.

```java
List<String> lista = Arrays.asList("manzana", "banana", "cereza");

lista.stream()
     .forEach(f -> System.out.println(f.toUpperCase()));
// Salida:
// MANZANA
// BANANA
// CEREZA
```

### 4. `sorted`

El operador `sorted` se utiliza para ordenar los elementos del Stream.

```java
List<String> lista = Arrays.asList("manzana", "banana", "cereza");

List<String> listaOrdenada = lista.stream()
                                 .sorted()
                                 .collect(Collectors.toList());

System.out.println(listaOrdenada); // Salida: [banana, cereza, manzana]
```

### 5. `collect`

El operador `collect` se utiliza para convertir el Stream de nuevo en una colección o valor concreto.

```java
List<String> lista = Arrays.asList("manzana", "banana", "cereza");

String resultado = lista.stream()
                       .collect(Collectors.joining(", "));

System.out.println(resultado); // Salida: manzana, banana, cereza
```

### 6. `reduce`

El operador `reduce` realiza una reducción en los elementos del Stream utilizando una operación asociativa y produce un resultado opcional.

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

Optional<Integer> suma = numeros.stream()
                               .reduce((a, b) -> a + b);

System.out.println(suma.orElse(0)); // Salida: 15
```

### 7. `anyMatch`

El operador `anyMatch` se utiliza para verificar si al menos un elemento del Stream cumple con una condición.

```java
List<String> lista = Arrays.asList("manzana", "banana", "cereza");

boolean contieneA = lista.stream()
                        .anyMatch(f -> f.contains("a"));

System.out.println(contieneA); // Salida: true
```

Este ejemplo verifica si al menos una de las frutas en la lista contiene la letra 'a'. En este caso, devuelve `true` porque tanto "manzana" como "banana" contienen la letra 'a'.

### 8. `peek`

El operador `peek` se utiliza para realizar operaciones intermedias en los elementos del Stream sin modificarlos. Es útil para realizar acciones de depuración o para observar el flujo de elementos en el Stream sin afectar el resultado final. `peek` toma un `Consumer` como argumento y aplica esa operación a cada elemento del Stream.

```java
List<String> frutas = Arrays.asList("manzana", "banana", "cereza");

List<String> resultado = frutas.stream()
                              .peek(f -> System.out.println("Procesando: " + f))
                              .map(String::toUpperCase)
                              .collect(Collectors.toList());

System.out.println(resultado);

```

En este ejemplo, `peek` se utiliza para imprimir cada elemento antes de que la operación `map` transforme las letras a mayúsculas. La salida de este código sería:

```
Procesando: manzana
Procesando: banana
Procesando: cereza
[MELÓN, BANANA, CEREZA]

```

Observa que el uso de `peek` no afecta el resultado final del Stream y solo se utiliza con fines de observación o depuración.

## Métodos comunes de los operadores

### Métodos para `map`:

- **`map`**:
    - **`<R> Stream<R> map(Function<? super T, ? extends R> mapper)`**: Transforma cada elemento del Stream aplicando la función proporcionada.
- **`flatMap`**:
    - **`<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`**: Transforma cada elemento del Stream aplicando la función y luego aplana los resultados en un solo Stream.

### Métodos para `filter`:

- **`filter`**:
    - **`Stream<T> filter(Predicate<? super T> predicate)`**: Selecciona elementos que cumplan con la condición especificada por el predicado.

### Métodos para `peek`:

- **`peek`**:
    - **`Stream<T> peek(Consumer<? super T> action)`**: Realiza operaciones intermedias en los elementos del Stream sin modificarlos.

### Métodos para `forEach`:

- **`forEach`**:
    - **`void forEach(Consumer<? super T> action)`**: Ejecuta una acción para cada elemento del Stream.
- **`forEachOrdered`**:
    - **`void forEachOrdered(Consumer<? super T> action)`**: Ejecuta una acción para cada elemento del Stream manteniendo el orden.

### Métodos para `sorted`:

- **`sorted`**:
    - **`Stream<T> sorted()`**: Ordena los elementos del Stream de acuerdo con el orden natural.
- **`sorted`**:
    - **`Stream<T> sorted(Comparator<? super T> comparator)`**: Ordena los elementos del Stream utilizando el comparador proporcionado.

### Métodos para `collect`:

- **`collect`**:
    - **`<R, A> R collect(Collector<? super T, A, R> collector)`**: Convierte el Stream en una colección o realiza alguna operación específica utilizando el colector proporcionado.

### Métodos para `reduce`:

- **`reduce`**:
    - **`Optional<T> reduce(BinaryOperator<T> accumulator)`**: Realiza una reducción en los elementos del Stream utilizando el operador binario proporcionado.
- **`reduce`**:
    - **`T reduce(T identity, BinaryOperator<T> accumulator)`**: Realiza una reducción en los elementos del Stream con un valor de identidad y un operador binario.

### Métodos para `anyMatch`:

- **`anyMatch`**:
    - **`boolean anyMatch(Predicate<? super T> predicate)`**: Verifica si al menos un elemento del Stream cumple con la condición especificada por el predicado.

¡Entendido! Aquí tienes ejemplos específicos para cada operador de la Stream API junto con sus respectivos métodos:

### `map`:

```java
List<String> frutas = Arrays.asList("manzana", "banana", "cereza");

// Transformar cada elemento a su longitud
List<Integer> longitudes = frutas.stream()
                               .map(String::length)
                               .collect(Collectors.toList());

System.out.println(longitudes); // Salida: [7, 6, 6]

```

### `filter`:

```java
List<String> frutas = Arrays.asList("manzana", "banana", "cereza");

// Filtrar frutas que empiezan con "b"
List<String> frutasFiltradas = frutas.stream()
                                    .filter(f -> f.startsWith("b"))
                                    .collect(Collectors.toList());

System.out.println(frutasFiltradas); // Salida: [banana]

```

### `peek`:

```java
List<String> frutas = Arrays.asList("manzana", "banana", "cereza");

// Realizar operaciones intermedias sin modificar los elementos
List<String> resultado = frutas.stream()
                              .peek(f -> System.out.println("Procesando: " + f))
                              .map(String::toUpperCase)
                              .collect(Collectors.toList());

System.out.println(resultado);

```

### `forEach`:

```java
List<String> frutas = Arrays.asList("manzana", "banana", "cereza");

// Imprimir cada fruta en mayúsculas
frutas.stream()
     .forEach(f -> System.out.println(f.toUpperCase()));
// Salida:
// MANZANA
// BANANA
// CEREZA

```

### `sorted`:

```java
List<String> frutas = Arrays.asList("manzana", "banana", "cereza");

// Ordenar frutas alfabéticamente
List<String> frutasOrdenadas = frutas.stream()
                                    .sorted()
                                    .collect(Collectors.toList());

System.out.println(frutasOrdenadas); // Salida: [banana, cereza, manzana]

```

### `collect`:

```java
List<String> frutas = Arrays.asList("manzana", "banana", "cereza");

// Unir las frutas en una cadena separada por comas
String resultado = frutas.stream()
                       .collect(Collectors.joining(", "));

System.out.println(resultado); // Salida: manzana, banana, cereza

```

### `reduce`:

```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// Calcular la suma de los números
Optional<Integer> suma = numeros.stream()
                               .reduce(Integer::sum);

System.out.println(suma.orElse(0)); // Salida: 15

```

### `anyMatch`:

```java
List<String> frutas = Arrays.asList("manzana", "banana", "cereza");

// Verificar si al menos una fruta contiene la letra 'a'
boolean contieneA = frutas.stream()
                        .anyMatch(f -> f.contains("a"));

System.out.println(contieneA); // Salida: true

```