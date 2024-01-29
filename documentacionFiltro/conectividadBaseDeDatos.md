# Java Database Connectivity

## Configuración (dependencias)

1. Ingresar a Maven Repository

[Maven Repository: Search/Browse/Explore](https://mvnrepository.com/)

1. Buscar la dependencia y su version a instalar
2. Copiar las dependencias
3. Crear la etiqueta en el archivo pom.xml del proyecto
4. Guardar cambios y ejecutar la opción `Clean and Build`

## Uso de JDBC

Definir URL de la conexión que especifica la ubicación y otros detalles

### Resultados de consulta

- Crearse objetos de tipo `Statement` y `ResultSet`
- `Statement`  Se utiliza

## Consultas parametrizadas

1. `Prevención de Inyección SQL`
2. `Optimización de Rendimiento`
3. `Manejo Automático de Tipo de Datos`

## Componentes del MVC

- Modelo
    - Contiene mecanismos para acceder a la información y también actualizar su estado.
    Los datos se tienen normalmente en una base de datos, por lo que en el modelo se
    encuentran todas las las funciones que accederán a las tablas y harán los
    correspondientes selects, updates, inserts, etc.
    - Representa la lógica de la aplicación y gestiona el estado y los datos.
    - Responde a las solicitudes de información y notifica cambios en los datos.
    - Independiente de la interfaz de usuario.
- Vista
    - Presenta la información al usuario y gestiona la interfaz de usuario.
    - Recibe información del modelo y muestra los datos.
    - Puede recibir acciones del usuario y transmitirlas al controlador.
- Controlador
    - Gestiona las interacciones del usuario y actualiza el modelo y la vista según sea
    necesario.
    - Recibe eventos de la vista y actúa como intermediario entre la vista y el modelo.
    - Contiene la lógica de negocio de la aplicación.

### Ventajas

- **Separación de responsabilidad**
- **Reutilización del Código**
- **Escalabilidad**
- **Facilita las Pruebas**

## Arquitectura MVC

### Modelo - Conexión

```java
import java.sql.*;

public abstract class ConexionBD {
    private static String url = "";
    private static String user = "";
    private static String password = "";
    public static Connection con = null;

    public static Connection MySQLConnection() {

        url = "jdbc:mysql://localhost:3306/my_db";
        user = "root";
        password = "123456";        
        return getConnection(url, user, password);
    }
    
    private static Connection getConnection(String url, String user, String password){
        try {
            // Realizar la conexion
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("Base de datos conectada " + meta.getDriverName());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
}
```

### Modelo - Operaciones

```java
import java.sql.*;

public abstract class Operaciones {

    public static Connection con;
    public static Statement stmt = null;
    public static ResultSet rs = null;
    

    public static Connection setConnection(Connection connection) {
        Operaciones.con = connection;
        return connection;
    }

    public static Connection getConnection() {
        return con;
    }
    
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static ResultSet consultar_BD(PreparedStatement sentencia) {
        try {
            rs = sentencia.executeQuery();
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return rs;
    }
    
    public static int insertar_actualizar_borrar_BD(PreparedStatement sentencia){
        int filas;
        try {
            filas = sentencia.executeUpdate();
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR" + sqlex);
            return 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return filas;
    }

    public static boolean setAutoCommitBD(boolean parametro) {
        try {
            con.setAutoCommit(parametro);
        } catch (SQLException sqlex) {
            System.out.println("Error al configurar el autoCommit " + sqlex.getMessage());
            return false;
        }
        return true;
    }

    public static void cerrarConexion() {
        closeConnection(con);
    }

    public static boolean commitBD() {
        try {
            con.commit();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer commit " + sqlex.getMessage());
            return false;
        }
    }

    public static boolean rollbackBD() {
        try {
            con.rollback();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer rollback " + sqlex.getMessage());
            return false;
        }
    }
}
```

### Modelo - Usuario

```java
public class Usuario {

    private int idusers;
    private String name;

    public Usuario(int idusers, String name) {
        this.idusers = idusers;
        this.name = name;
    }

    public Usuario(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdusers() {
        return idusers;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusers=" + idusers + ", name=" + name + '}';
    }

}
```

### Controlador - ControladorUsuario

- Contiene métodos para realizar operaciones CRUD en una base de datos MySQL para la entidad Usuario

```java
import com.nombre.jdbc.Modelo.Clases.Usuario;
import com.nombre.jdbc.Modelo.Persistencia.ConexionBD;
import com.nombre.jdbc.Modelo.Persistencia.Operaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ControladorUsuario {

    public static boolean registrarUsuario(String nombre) throws SQLException {
        Usuario u = new Usuario(nombre);
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String sentencia = "INSERT INTO users(name) VALUES (?);";
        PreparedStatement ps = Operaciones.getConnection().prepareStatement(sentencia);
        ps.setString(1, u.getName());
        if (Operaciones.setAutoCommitBD(false)) {
            if (Operaciones.insertar_actualizar_borrar_BD(ps) > 0) {
                Operaciones.commitBD();
                Operaciones.cerrarConexion();
                return true;
            } else {
                Operaciones.rollbackBD();
                Operaciones.cerrarConexion();
                return false;
            }
        } else {
            Operaciones.cerrarConexion();
            return false;
        }
    }

    public static boolean actualizarUsuario(int id, String nombre) throws SQLException {
        Usuario u = new Usuario(id, nombre);
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String sentencia = "UPDATE users SET name = ? WHERE idusers = ?";
        PreparedStatement ps = Operaciones.getConnection().prepareStatement(sentencia);
        ps.setString(1, u.getName());
        ps.setInt(2, u.getIdusers());
        if (Operaciones.setAutoCommitBD(false)) {
            if (Operaciones.insertar_actualizar_borrar_BD(ps) > 0) {
                Operaciones.commitBD();
                Operaciones.cerrarConexion();
                return true;
            } else {
                Operaciones.rollbackBD();
                Operaciones.cerrarConexion();
                return false;
            }
        } else {
            Operaciones.cerrarConexion();
            return false;
        }
    }

    public static boolean borrarUsuario(String nombre) throws SQLException {
        Usuario u = new Usuario(nombre);
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String sentencia = "DELETE FROM users WHERE name = ?";
        PreparedStatement ps = Operaciones.getConnection().prepareStatement(sentencia);
        ps.setString(1, u.getName());
        if (Operaciones.setAutoCommitBD(false)) {
            if (Operaciones.insertar_actualizar_borrar_BD(ps) > 0) {
                Operaciones.commitBD();
                Operaciones.cerrarConexion();
                return true;
            } else {
                Operaciones.rollbackBD();
                Operaciones.cerrarConexion();
                return false;
            }
        } else {
            Operaciones.cerrarConexion();
            return false;
        }
    }

    public static List<Usuario> ConsultarUsuario(String nombre) throws SQLException {
        List<Usuario> users = new ArrayList<>();
        Operaciones.setConnection(ConexionBD.MySQLConnection());
        String sentencia = "SELECT * FROM users WHERE name = ?";
        PreparedStatement ps = Operaciones.getConnection().prepareStatement(sentencia);
        ps.setString(1, nombre);
        ResultSet rs = Operaciones.consultar_BD(ps);
        while (rs.next()) {
            String name = rs.getString("name");
            int idusers = rs.getInt("idusers");
            Usuario u = new Usuario(idusers, name);
            users.add(u);
        }

        Operaciones.cerrarConexion();
        return users;

    }
}
```

### Vista - ClasePrincipal

Se usa como vista pues interactúa directamente con la consola y el usuario, tiene un método main que demuestra la funcionalidad implementada en el `ControladorUsuario`

```java
import com.nombre.jdbc.Controlador.ControladorUsuario;
import com.nombre.jdbc.Modelo.Clases.Usuario;
import java.sql.*;
import java.util.List;

public class Jdbc {

    public static void main(String[] args) throws SQLException {
        System.out.println(ControladorUsuario.registrarUsuario("Pepe"));

        List<Usuario> users = ControladorUsuario.ConsultarUsuario("Pepe");
        for (Usuario user : users) {
            System.out.println(user);
        }

        System.out.println(ControladorUsuario.borrarUsuario("Pepe"));

        List<Usuario> users2 = ControladorUsuario.ConsultarUsuario("Pepe");
        for (Usuario user: users2) {
            System.out.println(user);
        }
    }
}
```