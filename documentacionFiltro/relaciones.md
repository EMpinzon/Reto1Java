# UML

## Tipos de relaciones

Hay seis tipos principales de relaciones entre clases: herencia, realización/implementación, composición, agregación, asociación y dependencia. Las flechas para las seis relaciones son las siguientes:

![Untitled](/Reto1Java/images/image1.png)

### Herencia

**La herencia** también se denomina **generalización** y se utiliza para describir la relación entre las clases padre e hijo. Una clase principal también se denomina clase base y una subclase también se denomina clase derivada.

En la relación de herencia, la subclase hereda todas las funciones de la clase principal y la clase principal tiene todos los atributos, métodos y subclases. Las subclases contienen información adicional además de la misma información que la clase principal.

Por ejemplo: autobuses, taxis y automóviles son automóviles, todos tienen nombres y todos pueden estar en la carretera.

![Untitled](/Reto1Java/images/image2.png)

## Realización / Implementación

**La implementación** (Implementación) se utiliza principalmente para especificar **la relación entre las interfaces y las clases de implementación** .

**Una interfaz** (incluida una **clase abstracta** ) es una colección de métodos. En una relación de implementación, una clase implementa una interfaz y los métodos de la clase implementan todos los métodos de la declaración de la interfaz.

Por ejemplo: los automóviles y los barcos son vehículos, y el vehículo es solo un concepto abstracto de una herramienta móvil, y el barco y el vehículo realizan las funciones móviles específicas.

![Untitled](/Reto1Java/images/image3.png)

## Composición

Composición: **La relación entre el todo y la parte, pero el todo y la parte no se pueden separar** .

La relación de combinación representa la relación entre el todo y la parte de la clase, y el total y la parte tienen una duración constante. Una vez que el objeto general no existe, algunos de los objetos no existirán y todos morirán en la misma vida. Por ejemplo, una persona está compuesta por una cabeza y un cuerpo. Los dos son inseparables y coexisten.

![Untitled](/Reto1Java/images/image4.png)

## Agregación

Agregación: **La relación entre el todo y la parte, y el todo y la parte se pueden separar.**

Las relaciones agregadas también representan la relación entre el todo y una parte de la clase, los objetos miembros son parte del objeto general, pero el objeto miembro puede existir independientemente del objeto general.

Por ejemplo, los conductores de autobús y la ropa y los sombreros de trabajo son parte de la relación general, pero se pueden separar. La ropa de trabajo y los sombreros se pueden usar en otros conductores. Los conductores de autobuses también pueden usar otra ropa de trabajo y sombreros.

![Untitled](/Reto1Java/images/image5.png)

## Asociación

Asociación: indica que **una propiedad de una clase contiene una referencia a una instancia (o instancias) de otra clase** .

La asociación es la relación **más utilizada** entre una clase y otra clase, lo que significa que existe una conexión entre un tipo de objeto y otro tipo de objeto. **Las combinaciones y agregaciones también pertenecen a las relaciones asociativas** , pero las relaciones entre clases de afiliaciones son más débiles que las otras dos.

Hay cuatro tipos de **asociaciones** : **asociaciones bidireccionales** , **asociaciones unidireccionales** , **autoasociación y asociaciones** de **números múltiples** .

Por ejemplo: coches y conductores, un coche corresponde a un conductor en particular y un conductor puede conducir varios coches.

![Untitled](/Reto1Java/images/image6.png)

En los diagramas UML, las asociaciones bidireccionales pueden tener **dos flechas** o **ninguna** , y las asociaciones unidireccionales o autoasociaciones tienen **una flecha** .

En una relación de multiplicidad, puede agregar un número directamente a la línea asociada para indicar el número de objetos en la clase correspondiente.

- `1..1`: Sólo uno
- `0..*`: cero o más
- `1..*`:uno o mas
- `0..1`: Ninguno o solo uno
- `m..n`: al menos m, como máximo n (m<=n)

## Dependencias

Dependencia: suponga que un cambio en la clase A provoca un cambio en la clase B, luego diga que la clase B depende de la clase A.

En la mayoría de los casos, **las dependencias se reflejan en los métodos de una clase que utilizan el objeto de otra clase como parámetro** .

Una relación de dependencia es una relación de “uso”. Un cambio en una cosa en particular puede afectar a otras cosas que la usan, y usar una dependencia cuando es necesario indicar que una cosa usa otra. Por ejemplo: El auto depende de la gasolina. Si no hay gasolina, el automóvil no podrá conducir.

![Untitled](/Reto1Java/images/image7.png)