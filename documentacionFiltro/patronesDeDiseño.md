# Patrones de diseño

Son soluciones habituales a problemas que ocurren con frecuencia, como planos prefabricados que se pueden personalizar para resolver un problema.

- patrones creacionales
- patrones estructurales
- patrones de comportamientos

# Patrones Creacionales

# FactoryMethod

Primero, crearemos una interfaz `Unit` que representará el comportamiento común de todas las unidades:

```java
// Interfaz Unit
public interface Unit {
    void attack();
    void move();
}

```

Luego, crearemos implementaciones concretas de esta interfaz para diferentes tipos de unidades:

```java
// Implementación de Soldier
public class Soldier implements Unit {
    @Override
    public void attack() {
        System.out.println("Soldier attacks!");
    }

    @Override
    public void move() {
        System.out.println("Soldier moves!");
    }
}

// Implementación de Archer
public class Archer implements Unit {
    @Override
    public void attack() {
        System.out.println("Archer attacks!");
    }

    @Override
    public void move() {
        System.out.println("Archer moves!");
    }
}

// Implementación de Mage
public class Mage implements Unit {
    @Override
    public void attack() {
        System.out.println("Mage attacks!");
    }

    @Override
    public void move() {
        System.out.println("Mage moves!");
    }
}

```

Ahora, crearemos la interfaz `UnitFactory` que define el método de fábrica (`createUnit`) para crear instancias de unidades:

```java
// Interfaz UnitFactory
public interface UnitFactory {
    Unit createUnit();
}

```

A continuación, implementaremos fábricas concretas para cada tipo de unidad:

```java
// Fábrica para crear Soldiers
public class SoldierFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Soldier();
    }
}

// Fábrica para crear Archers
public class ArcherFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Archer();
    }
}

// Fábrica para crear Mages
public class MageFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Mage();
    }
}

```

Finalmente, en el cliente, podemos utilizar las fábricas para crear instancias de unidades sin preocuparnos por los detalles de implementación específicos:

```java
public class Game {
    public static void main(String[] args) {
        UnitFactory soldierFactory = new SoldierFactory();
        Unit soldier = soldierFactory.createUnit();
        soldier.attack();
        soldier.move();

        UnitFactory archerFactory = new ArcherFactory();
        Unit archer = archerFactory.createUnit();
        archer.attack();
        archer.move();

        UnitFactory mageFactory = new MageFactory();
        Unit mage = mageFactory.createUnit();
        mage.attack();
        mage.move();
    }
}

```

# Abstract Factory

Ejemplo donde tengamos dos familias de productos: `Button` y `Checkbox`. Cada familia tiene sus variantes para diferentes sistemas operativos, como Windows y macOS.

Primero, definimos las interfaces para los productos:

```java
// Interfaz para el producto Button
public interface Button {
    void click();
}

// Interfaz para el producto Checkbox
public interface Checkbox {
    void check();
}

```

Ahora, crearemos implementaciones concretas para estos productos para diferentes sistemas operativos:

```java
// Implementación concreta de Button para Windows
public class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows Button clicked");
    }
}

// Implementación concreta de Checkbox para Windows
public class WindowsCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("Windows Checkbox checked");
    }
}

// Implementación concreta de Button para macOS
public class MacOSButton implements Button {
    @Override
    public void click() {
        System.out.println("macOS Button clicked");
    }
}

// Implementación concreta de Checkbox para macOS
public class MacOSCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("macOS Checkbox checked");
    }
}

```

Luego, definimos la interfaz `GUIFactory` que declara los métodos de creación para los productos relacionados:

```java
// Interfaz para la fábrica abstracta
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

```

A continuación, implementaremos fábricas concretas para cada sistema operativo:

```java
// Fábrica concreta para Windows
public class WindowsGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Fábrica concreta para macOS
public class MacOSGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

```

Finalmente, en el cliente, podemos utilizar una fábrica abstracta para crear una familia completa de productos sin preocuparnos por los detalles de implementación específicos:

```java
public class Application {
    private GUIFactory guiFactory;

    public Application(GUIFactory guiFactory) {
        this.guiFactory = guiFactory;
    }

    public void createUI() {
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();

        button.click();
        checkbox.check();
    }

    public static void main(String[] args) {
        Application windowsApp = new Application(new WindowsGUIFactory());
        windowsApp.createUI();

        Application macOsApp = new Application(new MacOSGUIFactory());
        macOsApp.createUI();
    }
}

```

# Builder

Primero, definimos la clase `Computer` que queremos construir:

```java
// Clase Computer que queremos construir
public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public Computer(String cpu, String ram, String storage) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    public void display() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
    }
}

```

Luego, definimos la interfaz `ComputerBuilder` que declara los métodos para construir las diferentes partes del objeto `Computer`:

```java
// Interfaz para el builder
public interface ComputerBuilder {
    void buildCPU(String cpu);
    void buildRAM(String ram);
    void buildStorage(String storage);
    Computer getResult();
}

```

A continuación, implementamos una clase concreta del `ComputerBuilder`:

```java
// Implementación concreta del builder
public class ConcreteComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public ConcreteComputerBuilder() {
        this.computer = new Computer("Default CPU", "Default RAM", "Default Storage");
    }

    @Override
    public void buildCPU(String cpu) {
        computer = new Computer(cpu, computer.getRam(), computer.getStorage());
    }

    @Override
    public void buildRAM(String ram) {
        computer = new Computer(computer.getCpu(), ram, computer.getStorage());
    }

    @Override
    public void buildStorage(String storage) {
        computer = new Computer(computer.getCpu(), computer.getRam(), storage);
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}

```

Finalmente, en el cliente, utilizamos el `ComputerBuilder` para construir un objeto `Computer` paso a paso:

```java
public class Director {
    public static void main(String[] args) {
        ComputerBuilder builder = new ConcreteComputerBuilder();

        // Construir un Computer personalizado
        builder.buildCPU("Intel i7");
        builder.buildRAM("16GB");
        builder.buildStorage("512GB SSD");

        Computer customComputer = builder.getResult();
        customComputer.display();
    }
}

```

# Prototype

El patrón de diseño Prototype se utiliza para crear nuevos objetos copiando un objeto existente, conocido como prototipo. 

Primero, definimos la interfaz `Shape` que todos los objetos deben implementar:

```java
// Interfaz Shape
public interface Shape extends Cloneable {
    void draw();
}

```

Luego, implementamos clases concretas que implementan la interfaz `Shape`:

```java
// Implementación concreta de Circle
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

// Implementación concreta de Rectangle
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }

    @Override
    public Rectangle clone() {
        try {
            return (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

```

A continuación, creamos una clase `ShapeCache` que actuará como un registro de prototipos y almacenará instancias iniciales de los objetos:

```java
import java.util.HashMap;
import java.util.Map;

// Clase ShapeCache que actúa como un registro de prototipos
public class ShapeCache {
    private static Map<String, Shape> shapeCache = new HashMap<>();

    public static void loadCache() {
        Circle circle = new Circle();
        circle.draw();
        shapeCache.put("Circle", circle);

        Rectangle rectangle = new Rectangle();
        rectangle.draw();
        shapeCache.put("Rectangle", rectangle);
    }

    public static Shape getShape(String shapeType) {
        Shape cachedShape = shapeCache.get(shapeType);
        return (cachedShape != null) ? cachedShape.clone() : null;
    }
}

```

Finalmente, en el cliente, utilizamos la clase `ShapeCache` para obtener instancias clonadas de los objetos `Shape`:

```java
public class Client {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedCircle = ShapeCache.getShape("Circle");
        System.out.println("Shape: " + clonedCircle);
        clonedCircle.draw();

        Shape clonedRectangle = ShapeCache.getShape("Rectangle");
        System.out.println("Shape: " + clonedRectangle);
        clonedRectangle.draw();
    }
}

```

# Singleton

El patrón de diseño Singleton se utiliza para garantizar que una clase tenga solo una instancia y proporcionar un punto global de acceso a esa instancia. 

```java
// Clase Singleton
public class Singleton {
    // La instancia única de la clase
    private static Singleton instance;

    // Constructor privado para evitar la creación de instancias directas
    private Singleton() {
        // Inicialización del Singleton
        System.out.println("Singleton instance created");
    }

    // Método público para obtener la instancia única del Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Otros métodos de la clase
    public void doSomething() {
        System.out.println("Singleton is doing something");
    }
}

```

En este ejemplo:

- `Singleton` tiene un constructor privado para evitar que se creen instancias directas de la clase desde fuera.
- La instancia única de la clase se mantiene como una variable estática privada (`instance`).
- El método `getInstance()` es el punto de acceso público a la única instancia del Singleton. Si la instancia aún no ha sido creada, se crea; de lo contrario, se devuelve la instancia existente.
- `doSomething()` es solo un método de ejemplo en la clase Singleton.

A continuación, un ejemplo de cómo usar la clase Singleton:

```java
public class SingletonExample {
    public static void main(String[] args) {
        // Intentar crear instancias directas (no se permite)
        // Singleton invalidInstance = new Singleton(); // Esto genera un error

        // Obtener la instancia única del Singleton
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // Verificar que ambas instancias sean iguales
        System.out.println("Are instances equal? " + (instance1 == instance2));

        // Utilizar la instancia del Singleton
        instance1.doSomething();
        instance2.doSomething();
    }
}

```

Este ejemplo muestra cómo se garantiza que solo existe una instancia de la clase `Singleton`, y ambas variables `instance1` e `instance2` hacen referencia a la misma instancia. Esto es útil cuando queremos tener un punto de control centralizado para una determinada funcionalidad en nuestra aplicación.

# Patrones Estructurales

Los patrones de diseño estructurales son patrones que se centran en la composición de clases y objetos para formar estructuras más grandes y flexibles

# Adapter

El patrón Adapter se utiliza cuando se quiere permitir que interfaces incompatibles trabajen juntas. Su objetivo principal es hacer que objetos con interfaces incompatibles puedan colaborar.

Esta clase es la que se puede adaptar según sea necesario. A pesar de ser un motor, presenta características considerablemente distintas en comparación con los otros tipos de motores en el sistema. Debido a estas diferencias, no puede heredar directamente de la clase Motor. En cambio, esta clase es accedida y manejada por la clase Adapter para asegurar su integración adecuada en el sistema.

El patrón de diseño Adapter se utiliza para permitir que dos interfaces incompatibles trabajen juntas. A continuación, te proporciono un ejemplo sencillo de un adaptador que convierte la interfaz de un sistema de reproducción de música a otra interfaz más generalizada.

Supongamos que tenemos una interfaz `MediaPlayer` que puede reproducir archivos de audio:

```java
// Interfaz MediaPlayer
public interface MediaPlayer {
    void play(String audioType, String fileName);
}

```

Ahora, imaginemos que tenemos una clase `AdvancedMediaPlayer` que puede reproducir formatos de audio más avanzados:

```java
// Interfaz AdvancedMediaPlayer
public interface AdvancedMediaPlayer {
    void playMp3(String fileName);
    void playWav(String fileName);
}

```

Pero queremos utilizar `AdvancedMediaPlayer` en un contexto que espera la interfaz `MediaPlayer`. Aquí es donde entra en juego el adaptador.

Primero, creamos una clase adaptadora `AdvancedMediaPlayerAdapter` que implementa la interfaz `MediaPlayer` y utiliza `AdvancedMediaPlayer` internamente:

```java
// Adaptador para convertir AdvancedMediaPlayer a MediaPlayer
public class AdvancedMediaPlayerAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public AdvancedMediaPlayerAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            advancedMediaPlayer.playMp3(fileName);
        } else if (audioType.equalsIgnoreCase("wav")) {
            advancedMediaPlayer.playWav(fileName);
        } else {
            System.out.println("Unsupported audio type: " + audioType);
        }
    }
}

```

Ahora, podemos utilizar `AdvancedMediaPlayer` a través del adaptador en un contexto que espera la interfaz `MediaPlayer`:

```java
public class AudioPlayer implements MediaPlayer {
    private MediaPlayer mediaPlayer;

    public AudioPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        mediaPlayer.play(audioType, fileName);
    }

    public static void main(String[] args) {
        // Crear un reproductor de audio con adaptador
        AdvancedMediaPlayer advancedMediaPlayer = new MyAdvancedMediaPlayer();
        MediaPlayer adapter = new AdvancedMediaPlayerAdapter(advancedMediaPlayer);
        AudioPlayer audioPlayer = new AudioPlayer(adapter);

        // Reproducir diferentes tipos de archivos de audio
        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("wav", "music.wav");
        audioPlayer.play("flac", "audio.flac"); // Unsupported audio type
    }
}

```

En este ejemplo, `AudioPlayer` utiliza un adaptador para permitir la reproducción de diferentes formatos de audio (`mp3`, `wav`, etc.) a través de la interfaz `MediaPlayer`, aunque internamente utiliza `AdvancedMediaPlayer`. Esto es un ejemplo básico del patrón Adapter, que facilita la interoperabilidad entre sistemas con interfaces incompatibles.

# Bridge

EI patrón Bridge es un patrón de diseño estructural que separa la abstracción de su implementación, permitiendo que ambas puedan variar independientemente. Esto se logra mediante la creación de dos jerarquías de clases: una para la abstracción y otra para la implementación, y luego utilizando una interfaz para conectarlas.

El patrón de diseño Bridge se utiliza para desacoplar una abstracción de su implementación, de modo que ambas puedan variar de forma independiente. A continuación, te proporciono un ejemplo de un sistema de entretenimiento que utiliza el patrón Bridge para separar la interfaz de reproducción del contenido multimedia y la implementación de los dispositivos de reproducción.

Primero, definimos la interfaz `MediaPlayer`:

```java
// Interfaz MediaPlayer
public interface MediaPlayer {
    void play();
    void pause();
    void stop();
}

```

Luego, creamos una implementación concreta de `MediaPlayer` para reproducir contenido de audio:

```java
// Implementación concreta de MediaPlayer para audio
public class AudioPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Playing audio...");
    }

    @Override
    public void pause() {
        System.out.println("Pausing audio...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping audio...");
    }
}

```

Ahora, definimos una interfaz separada `MediaPlatform` que representa la implementación subyacente del reproductor:

```java
// Interfaz MediaPlatform
public interface MediaPlatform {
    void start();
    void close();
}

```

Implementamos una clase concreta `MediaPlatformImpl` que representa la implementación de un dispositivo de reproducción específico, como un reproductor de audio en un teléfono móvil:

```java
// Implementación concreta de MediaPlatform
public class MediaPlatformImpl implements MediaPlatform {
    @Override
    public void start() {
        System.out.println("Starting media platform...");
    }

    @Override
    public void close() {
        System.out.println("Closing media platform...");
    }
}

```

Ahora, aplicamos el patrón Bridge creando una interfaz `MediaPlayerWithPlatform` que extiende `MediaPlayer` y contiene una referencia a `MediaPlatform`:

```java
// Interfaz MediaPlayerWithPlatform
public interface MediaPlayerWithPlatform extends MediaPlayer {
    void setMediaPlatform(MediaPlatform mediaPlatform);
}

```

Implementamos una clase concreta `AdvancedMediaPlayer` que extiende `AudioPlayer` y utiliza un `MediaPlatform` para reproducir contenido multimedia:

```java
// Implementación concreta de MediaPlayerWithPlatform
public class AdvancedMediaPlayer extends AudioPlayer implements MediaPlayerWithPlatform {
    private MediaPlatform mediaPlatform;

    @Override
    public void setMediaPlatform(MediaPlatform mediaPlatform) {
        this.mediaPlatform = mediaPlatform;
    }

    @Override
    public void play() {
        mediaPlatform.start();
        super.play();
    }

    @Override
    public void stop() {
        super.stop();
        mediaPlatform.close();
    }
}

```

Finalmente, en el cliente, podemos utilizar el `AdvancedMediaPlayer` para reproducir contenido multimedia con diferentes plataformas:

```java
public class EntertainmentSystem {
    public static void main(String[] args) {
        // Crear un reproductor de contenido avanzado
        AdvancedMediaPlayer advancedMediaPlayer = new AdvancedMediaPlayer();

        // Configurar diferentes plataformas para reproducir
        advancedMediaPlayer.setMediaPlatform(new MediaPlatformImpl());

        // Reproducir contenido multimedia
        advancedMediaPlayer.play();

        // Cambiar la plataforma
        advancedMediaPlayer.setMediaPlatform(new AnotherMediaPlatformImpl());

        // Reproducir otro contenido multimedia
        advancedMediaPlayer.play();
    }
}

```

Este ejemplo ilustra cómo el patrón Bridge permite desacoplar la interfaz de reproducción (`MediaPlayerWithPlatform`) de la implementación de los dispositivos de reproducción (`MediaPlatform`). De esta manera, podemos cambiar y extender ambos de forma independiente.

# Composite

El patrón de diseño Composite es un patrón estructural que permite componer objetos en estructuras de árbol para representar jerarquías parte-todo. Este patrón trata a los objetos individuales y a las composiciones de objetos de manera uniforme, lo que significa que se puede tratar a un solo objeto o a una colección de objetos de manera similar

El patrón de diseño Composite se utiliza para tratar objetos individuales y composiciones de objetos de manera uniforme. Este patrón permite a los clientes tratar tanto a objetos individuales como a composiciones de objetos de manera uniforme. A continuación, te proporciono un ejemplo de cómo podrías usar el patrón Composite para modelar una estructura jerárquica de componentes gráficos.

Primero, definimos la interfaz `Graphic` que representa tanto a los elementos individuales como a las composiciones:

```java
// Interfaz para los elementos gráficos (Component)
public interface Graphic {
    void draw();
}

```

Luego, creamos clases concretas que implementan la interfaz `Graphic`:

```java
// Implementación de un elemento gráfico simple (Leaf)
public class Ellipse implements Graphic {
    @Override
    public void draw() {
        System.out.println("Ellipse drawn");
    }
}

// Implementación de un elemento gráfico compuesto (Composite)
public class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void addGraphic(Graphic graphic) {
        graphics.add(graphic);
    }

    @Override
    public void draw() {
        System.out.println("Composite Graphic drawn");
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

```

En este ejemplo, `Ellipse` representa un elemento gráfico simple (hoja), y `CompositeGraphic` representa un elemento gráfico compuesto (nodo interno) que puede contener otras instancias de `Graphic`.

Ahora, podemos utilizar el patrón Composite para construir una estructura jerárquica de elementos gráficos:

```java
public class Drawing {
    public static void main(String[] args) {
        // Crear elementos gráficos individuales
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();

        // Crear un elemento gráfico compuesto y agregar elementos individuales
        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.addGraphic(ellipse1);
        compositeGraphic.addGraphic(ellipse2);
        compositeGraphic.addGraphic(ellipse3);

        // Dibujar la estructura completa (Composite Graphic que contiene Ellipses)
        compositeGraphic.draw();
    }
}

```

Este ejemplo ilustra cómo el patrón Composite permite tratar tanto a los elementos gráficos individuales (`Ellipse`) como a las composiciones de elementos (`CompositeGraphic`) de manera uniforme. Al llamar al método `draw()` en el `CompositeGraphic`, se invoca el método `draw()` en cada elemento dentro de la composición, ya sean elementos individuales o composiciones anidadas.

# Facade

EI patrón de diseño Facade es un patrón estructural que proporciona una interfaz simplificada para un conjunto de interfaces más complejas o subsistemas. Facade actúa como una fachada o un punto de entrada único a un grupo de clases o servicios, ocultando su complejidad detrás de una interfaz sencilla.

El patrón de diseño Facade se utiliza para proporcionar una interfaz unificada a un conjunto de interfaces en un subsistema. Este patrón define una interfaz de alto nivel que facilita el uso de un sistema más grande y complejo. Aquí tienes un ejemplo simple de cómo podrías usar el patrón Facade para simplificar el acceso a subsistemas más complejos, como un sistema de home theater.

Primero, definimos algunas clases que representan los subsistemas:

```java
// Subsistema para encender el proyector
class Projector {
    void turnOn() {
        System.out.println("Proyector encendido");
    }

    void turnOff() {
        System.out.println("Proyector apagado");
    }
}

// Subsistema para encender el reproductor de DVD
class DVDPlayer {
    void turnOn() {
        System.out.println("Reproductor de DVD encendido");
    }

    void turnOff() {
        System.out.println("Reproductor de DVD apagado");
    }

    void play(String movie) {
        System.out.println("Reproduciendo película: " + movie);
    }
}

// Subsistema para controlar el sistema de audio
class AudioSystem {
    void turnOn() {
        System.out.println("Sistema de audio encendido");
    }

    void turnOff() {
        System.out.println("Sistema de audio apagado");
    }

    void setVolume(int volume) {
        System.out.println("Volumen ajustado a: " + volume);
    }
}

```

Luego, creamos una clase `HomeTheaterFacade` que actúa como una interfaz unificada para simplificar el uso del sistema de home theater:

```java
// Facade para el sistema de home theater
public class HomeTheaterFacade {
    private Projector projector;
    private DVDPlayer dvdPlayer;
    private AudioSystem audioSystem;

    public HomeTheaterFacade(Projector projector, DVDPlayer dvdPlayer, AudioSystem audioSystem) {
        this.projector = projector;
        this.dvdPlayer = dvdPlayer;
        this.audioSystem = audioSystem;
    }

    // Método para encender todo el sistema de home theater
    public void turnOn() {
        projector.turnOn();
        dvdPlayer.turnOn();
        audioSystem.turnOn();
    }

    // Método para apagar todo el sistema de home theater
    public void turnOff() {
        projector.turnOff();
        dvdPlayer.turnOff();
        audioSystem.turnOff();
    }

    // Método para reproducir una película en el sistema de home theater
    public void watchMovie(String movie) {
        turnOn();
        dvdPlayer.play(movie);
        audioSystem.setVolume(10);
    }

    // Método para detener la película y apagar el sistema de home theater
    public void endMovie() {
        dvdPlayer.turnOff();
        audioSystem.turnOff();
    }
}

```

Finalmente, en el cliente, podemos utilizar la clase `HomeTheaterFacade` para interactuar con el sistema de home theater de una manera más sencilla:

```java
public class Client {
    public static void main(String[] args) {
        // Crear instancias de los subsistemas
        Projector projector = new Projector();
        DVDPlayer dvdPlayer = new DVDPlayer();
        AudioSystem audioSystem = new AudioSystem();

        // Crear la fachada para el sistema de home theater
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, dvdPlayer, audioSystem);

        // Utilizar la fachada para ver una película
        homeTheater.watchMovie("Inception");

        // Detener la película y apagar el sistema de home theater
        homeTheater.endMovie();
    }
}

```

Este ejemplo demuestra cómo el patrón Facade proporciona una interfaz simplificada (`HomeTheaterFacade`) para interactuar con un sistema más complejo (`Projector`, `DVDPlayer`, `AudioSystem`). Esto facilita la utilización del sistema de home theater sin necesidad de conocer los detalles de implementación específicos de cada subsistema.

# Flyweight

EI patrón de diseño Flyweight es un patrón estructural que se utiliza para minimizar el uso de memoria y mejorar el rendimiento al compartir objetos pequeños que se utilizan de manera repetida. Este patrón se centra en reutilizar objetos en lugar de crear nuevos cada vez que son necesarios, lo que puede ser especialmente útil cuando se maneja una gran cantidad de objetos similares.

El patrón de diseño Flyweight se utiliza para reducir la redundancia cuando se tienen muchas instancias de un objeto similar. El patrón Flyweight se centra en compartir, en lugar de crear, instancias para ahorrar memoria y mejorar el rendimiento. A continuación, te proporciono un ejemplo de cómo podrías utilizar el patrón Flyweight para gestionar de manera eficiente diferentes tipos de lápices y colores en una aplicación de dibujo.

Primero, definimos la interfaz `Pencil` que representa el lápiz:

```java
// Interfaz para el lápiz (Flyweight)
public interface Pencil {
    void draw(String color);
}

```

A continuación, implementamos una clase concreta `ConcretePencil` que implementa la interfaz `Pencil`:

```java
// Implementación concreta de Pencil (ConcreteFlyweight)
public class ConcretePencil implements Pencil {
    private String type;

    public ConcretePencil(String type) {
        this.type = type;
    }

    @Override
    public void draw(String color) {
        System.out.println("Drawing with " + color + " " + type + " pencil");
    }
}

```

Luego, creamos una clase `PencilFactory` que actúa como una fábrica para crear y gestionar instancias de lápices. Utilizamos un mapa (`pencilMap`) para almacenar instancias de lápices y reutilizarlas cuando sea posible:

```java
import java.util.HashMap;
import java.util.Map;

// Fábrica para crear y gestionar lápices (FlyweightFactory)
public class PencilFactory {
    private static final Map<String, Pencil> pencilMap = new HashMap<>();

    public static Pencil getPencil(String type) {
        Pencil pencil = pencilMap.get(type);

        if (pencil == null) {
            pencil = new ConcretePencil(type);
            pencilMap.put(type, pencil);
        }

        return pencil;
    }
}

```

Finalmente, en el cliente, utilizamos la `PencilFactory` para obtener instancias de lápices y los usamos para dibujar:

```java
public class DrawingApp {
    public static void main(String[] args) {
        // Obtener instancias de lápices de la fábrica
        Pencil pencil1 = PencilFactory.getPencil("HB");
        Pencil pencil2 = PencilFactory.getPencil("2B");
        Pencil pencil3 = PencilFactory.getPencil("HB");

        // Dibujar con lápices
        pencil1.draw("blue");
        pencil2.draw("red");
        pencil3.draw("green");

        // Verificar si las instancias son compartidas
        System.out.println("pencil1 == pencil2: " + (pencil1 == pencil2));
        System.out.println("pencil1 == pencil3: " + (pencil1 == pencil3));
    }
}

```

Este ejemplo ilustra cómo el patrón Flyweight permite compartir instancias de lápices similares (`ConcretePencil`) para reducir la redundancia y ahorrar memoria. En este caso, aunque se solicita un lápiz "HB" dos veces, solo se crea una instancia y se reutiliza en ambas ocasiones. Esto es especialmente útil cuando se manejan grandes cantidades de objetos similares y se busca optimizar el uso de la memoria.

# Proxy

EI patrón de diseño Proxy es un patrón estructural que actúa como un intermediario o sustituto de otro objeto para controlar el acceso a éste. Proporciona una representación o proxy de otro objeto y controla el acceso a él. Esto puede ser útil en situaciones en las que se quiere agregar funcionalidad adicional al objeto original sin modificar su código.

El patrón de diseño Proxy se utiliza para proporcionar un sustituto o representante de otro objeto para controlar el acceso a él. Este patrón es útil para implementar lógica adicional, como control de acceso, registro o manipulación de datos, sin modificar directamente el objeto real. Aquí tienes un ejemplo de cómo podrías utilizar el patrón Proxy para controlar el acceso a un servicio remoto de imágenes.

Primero, definimos una interfaz `Image` que representa la operación principal que queremos realizar en el servicio remoto:

```java
// Interfaz para la imagen (Subject)
public interface Image {
    void display();
}

```

A continuación, implementamos una clase concreta `RealImage` que representa la implementación real del servicio remoto:

```java
// Implementación concreta de Image (RealSubject)
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

```

Luego, creamos una clase `ImageProxy` que actúa como un proxy para `RealImage`. `ImageProxy` controla el acceso a la instancia de `RealImage` y puede realizar acciones adicionales antes o después de llamar a `display()`:

```java
// Proxy para Image
public class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

```

Finalmente, en el cliente, podemos utilizar `ImageProxy` para acceder a la imagen sin cargarla inmediatamente, sino solo cuando sea necesario:

```java
public class Client {
    public static void main(String[] args) {
        // Utilizar ImageProxy para controlar el acceso a RealImage
        Image image = new ImageProxy("sample.jpg");

        // La imagen se carga y muestra solo cuando se llama a display()
        image.display();

        // La imagen no se vuelve a cargar, ya que ya está en memoria
        image.display();
    }
}

```

Este ejemplo ilustra cómo el patrón Proxy (`ImageProxy`) controla el acceso a un objeto real (`RealImage`). En este caso, la imagen real se carga desde el disco solo cuando se llama al método `display()` en el proxy. Este enfoque es útil para optimizar el rendimiento y reducir la carga de recursos, especialmente cuando no todas las operaciones en el objeto real son necesarias en todos los casos.