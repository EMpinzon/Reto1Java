# Manejo de Archivos

El manejo de archivos en Java es una parte esencial de muchas aplicaciones, ya que permite la lectura y escritura de datos en el sistema de archivos. En esta documentación, exploraremos las principales clases y métodos proporcionados por Java para gestionar archivos de manera efectiva.

## Clases Principales

### 1. `File`

La clase `File` en Java se utiliza para representar rutas de archivos y directorios. Aunque no proporciona métodos para leer o escribir datos, es fundamental para manipular rutas y realizar operaciones básicas en archivos.

### Ejemplo de uso:

```java
File file = new File("ruta/del/archivo.txt");
if (file.exists()) {
    // Realizar operaciones en el archivo
} else {
    // Archivo no encontrado
}
```

### 2. `FileInputStream` y `FileOutputStream`

Estas clases son utilizadas para leer y escribir datos binarios desde y hacia archivos, respectivamente.

### Ejemplo de lectura:

```java
try (FileInputStream fis = new FileInputStream("archivo.txt")) {
    int byteLeido;
    while ((byteLeido = fis.read()) != -1) {
        // Procesar byte leído
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Ejemplo de escritura:

```java
try (FileOutputStream fos = new FileOutputStream("archivo_salida.txt")) {
    byte[] datos = "Hola, mundo!".getBytes();
    fos.write(datos);
} catch (IOException e) {
    e.printStackTrace();
}
```

### 3. `BufferedReader` y `BufferedWriter`

Estas clases proporcionan un rendimiento mejorado al leer y escribir datos de manera eficiente mediante la utilización de búferes.

### Ejemplo de lectura:

```java
try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        // Procesar línea leída
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Ejemplo de escritura:

```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("archivo_salida.txt"))) {
    bw.write("Hola, mundo!");
} catch (IOException e) {
    e.printStackTrace();
}
```

### 4. `Scanner`

La clase `Scanner` se utiliza para leer datos de entrada, incluidos archivos, de manera fácil y flexible.

### Ejemplo de lectura desde archivo:

```java
try (Scanner scanner = new Scanner(new File("archivo.txt"))) {
    while (scanner.hasNext()) {
        // Procesar datos
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```

### 5. `Paths` y `Files`

Las clases `Paths` y `Files` proporcionan métodos estáticos para manipular rutas y realizar operaciones avanzadas en archivos, como la lectura y escritura de archivos completos.

### Ejemplo de lectura y escritura usando `Files`:

```java
try {
    List<String> lineas = Files.readAllLines(Paths.get("archivo.txt"));
    // Procesar líneas leídas

    Files.write(Paths.get("archivo_salida.txt"), lineas);
} catch (IOException e) {
    e.printStackTrace();
}
```


1.  Escribir en un archivo

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteToFileExample {
    public static void main(String[] args) {
        String content = "Hola, este es un ejemplo de escritura en un archivo.";

        // Ruta del archivo
        Path filePath = Path.of("miarchivo.txt");

        try {
            // Escribir en el archivo
            Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            System.out.println("Contenido escrito en el archivo correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

2. Leer desde un archivo

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFromFileExample {
    public static void main(String[] args) {
        // Ruta del archivo
        Path filePath = Path.of("miarchivo.txt");

        try {
            // Leer desde el archivo
            String content = Files.readString(filePath);
            System.out.println("Contenido leído desde el archivo:\n" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
