

1. Iterador sobre un Mapa (Map):

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorExample {
    public static void main(String[] args) {
        // Crear un mapa
        Map<String, Integer> map = new HashMap<>();
        map.put("Uno", 1);
        map.put("Dos", 2);
        map.put("Tres", 3);

        // Obtener un iterador sobre las entradas del mapa
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        // Iterar sobre el mapa usando el iterador
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

2. Iterador sobre una Lista (List)

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorExample {
    public static void main(String[] args) {
        // Crear una lista
        List<String> list = new ArrayList<>();
        list.add("Elemento 1");
        list.add("Elemento 2");
        list.add("Elemento 3");

        // Obtener un iterador sobre la lista
        Iterator<String> iterator = list.iterator();

        // Iterar sobre la lista usando el iterador
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
```

3. Iterador sobre una Colección

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIteratorExample {
    public static void main(String[] args) {
        // Crear una colección (por ejemplo, una lista)
        Collection<String> collection = new ArrayList<>();
        collection.add("Item 1");
        collection.add("Item 2");
        collection.add("Item 3");

        // Obtener un iterador sobre la colección
        Iterator<String> iterator = collection.iterator();

        // Iterar sobre la colección usando el iterador
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}
```