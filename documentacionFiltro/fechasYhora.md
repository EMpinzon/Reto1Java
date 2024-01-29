# Fecha y hora en java

En Java, LocalDate y LocalTime son clases pertenecientes al paquete java.time que se introdujo en Java 8 para manejar fechas y horas de manera más eficiente y precisa.

## LocalDate


- LocalDate representa una fecha (año, mes y día) sin tener en cuenta la hora del día o la zona horaria.
- Es útil para representar fechas en aplicaciones donde la hora específica no es relevante. 

```java

LocalDate today = LocalDate.now(); // Obtiene la fecha actual
LocalDate specificDate = LocalDate.of(2024, 01, 25); // Crea una fecha específica (año, mes, día)

```

## LocalTime

- representa una hora del día, con precisión hasta nanosegundos, sin considerar la fecha ni la zona horaria.
- Útil cuando solo necesitas trabajar con la hora y no te importa la fecha.

```java
LocalTime currentTime = LocalTime.now(); // Obtiene la hora actual
LocalTime specificTime = LocalTime.of(12, 30, 45); // Crea una hora específica (hora, minuto, segundo)
```

## Operaciones con fechas y horas

1. Operaciones matemáticas
```java
LocalDate tomorrow = today.plusDays(1); // Obtener la fecha de mañana
LocalTime nextHour = currentTime.plusHours(1); // Obtener la hora de la próxima hora
```

2. Comparaciones

```java
boolean isAfter = specificDate.isAfter(today); // Verificar si una fecha es después de otra
```

3. Formateo y análisis de cadenas:

```java
String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); // Formatear la fecha como una cadena
LocalDate parsedDate = LocalDate.parse("25-01-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")); // Analizar una cadena en una fecha
```

4. Sumar y restar días a una fecha

```java
import java.time.LocalDate;

LocalDate currentDate = LocalDate.now();

// Sumar días
LocalDate futureDate = currentDate.plusDays(7);

// Restar días
LocalDate pastDate = currentDate.minusDays(3);
```

5. Sumar y restar horas a una hora del día 

```java
import java.time.LocalTime;

LocalTime currentTime = LocalTime.now();

// Sumar horas
LocalTime futureTime = currentTime.plusHours(2);

// Restar horas
LocalTime pastTime = currentTime.minusHours(1);
```

6. Sumar y restar días, horas y minutos a una fecha y hora

```java
import java.time.LocalDateTime;

LocalDateTime currentDateTime = LocalDateTime.now();

// Sumar días, horas y minutos
LocalDateTime futureDateTime = currentDateTime.plusDays(5).plusHours(3).plusMinutes(30);

// Restar días, horas y minutos
LocalDateTime pastDateTime = currentDateTime.minusDays(2).minusHours(1).minusMinutes(15);
```

7. Sumar dos objetos 

```java
import java.time.LocalDate;

LocalDate date1 = LocalDate.of(2022, 1, 25);
LocalDate date2 = LocalDate.of(2022, 2, 10);

// Sumar los dos objetos LocalDate
LocalDate resultDate = date1.plusDays(date2.toEpochDay() - date1.toEpochDay());

System.out.println("Fecha resultante: " + resultDate);
```

8. Sumar dos objetos localDate time 

```java
import java.time.LocalDateTime;

LocalDateTime dateTime1 = LocalDateTime.of(2022, 1, 25, 12, 30);
LocalDateTime dateTime2 = LocalDateTime.of(2022, 2, 10, 8, 45);

// Sumar los dos objetos LocalDateTime
LocalDateTime resultDateTime = dateTime1.plusDays(dateTime2.toLocalDate().toEpochDay() - dateTime1.toLocalDate().toEpochDay())
                                      .plusSeconds(dateTime2.toSecondOfDay() - dateTime1.toSecondOfDay());

System.out.println("Fecha y hora resultantes: " + resultDateTime);
```

9. Número de días o meses entre dos objetos LocalDate:

```java
import java.time.LocalDate;
import java.time.Period;

LocalDate date1 = LocalDate.of(2022, 1, 25);
LocalDate date2 = LocalDate.of(2022, 2, 10);

// Obtener la diferencia en días
long daysDifference = Math.abs(Period.between(date1, date2).getDays());

System.out.println("Diferencia en días: " + daysDifference);

// Obtener la diferencia en meses
long monthsDifference = Math.abs(Period.between(date1, date2).toTotalMonths());

System.out.println("Diferencia en meses: " + monthsDifference);
```

10. Número de horas o minutos entre dos objetos LocalTime:

```java
import java.time.LocalTime;
import java.time.Duration;

LocalTime time1 = LocalTime.of(12, 30);
LocalTime time2 = LocalTime.of(14, 45);

// Obtener la diferencia en horas
long hoursDifference = Math.abs(Duration.between(time1, time2).toHours());

System.out.println("Diferencia en horas: " + hoursDifference);

// Obtener la diferencia en minutos
long minutesDifference = Math.abs(Duration.between(time1, time2).toMinutes());

System.out.println("Diferencia en minutos: " + minutesDifference);

```

11. generar numero random 

```java
import java.util.Random;

// Crear un objeto de la clase Random
Random random = new Random();

// Generar un número entero aleatorio entre 0 (inclusive) y 100 (exclusive)
int randomNumber = random.nextInt(100);

// Generar un número decimal aleatorio entre 0 (inclusive) y 1 (exclusive)
double randomDecimal = random.nextDouble();

System.out.println("Número aleatorio (entero): " + randomNumber);
System.out.println("Número aleatorio (decimal): " + randomDecimal);

```

```java
// Generar un número entero aleatorio entre 0 (inclusive) y 100 (exclusive)
int randomNumber = (int) (Math.random() * 100);

// Generar un número decimal aleatorio entre 0 (inclusive) y 1 (exclusive)
double randomDecimal = Math.random();

System.out.println("Número aleatorio (entero): " + randomNumber);
System.out.println("Número aleatorio (decimal): " + randomDecimal);

```

12. redondear numeros

```java
double number = 5.67;

// Redondear hacia arriba
double roundedUp = Math.ceil(number);

// Redondear hacia abajo
double roundedDown = Math.floor(number);

// Redondear al entero más cercano
long rounded = Math.round(number);

System.out.println("Redondear hacia arriba: " + roundedUp);
System.out.println("Redondear hacia abajo: " + roundedDown);
System.out.println("Redondear al entero más cercano: " + rounded);
```

12. Valor absoluto

```java
int negativeNumber = -10;

// Obtener el valor absoluto
int absoluteValue = Math.abs(negativeNumber);

System.out.println("Valor absoluto: " + absoluteValue);

```