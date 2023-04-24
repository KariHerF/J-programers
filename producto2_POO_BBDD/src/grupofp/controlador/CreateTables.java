package grupofp.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	public static void main(String[] args) {

		// Obtener la conexión a la base de datos
		try (Connection conexion = ConexionDB.conectar()) { // He importado la conexion de ConexionDB.java e
															// inicializado esa

			// Crear una sentencia
			Statement sentencia = conexion.createStatement();

			// Definir la sentencia SQL para crear la tabla de articulos
			String sqlArticulo = "CREATE TABLE IF NOT EXISTS articulos (" +
					"codigo VARCHAR(50) NOT NULL, " +
					"descripcion VARCHAR(100) NOT NULL," +
					"pvp DOUBLE NOT NULL," +
					"tiempoPrep TIME NOT NULL," +
					"gastosEnvio DOUBLE NOT NULL," +
					"PRIMARY KEY (codigo)" +
					")";
			String sqlCliente = "CREATE TABLE IF NOT EXISTS clientes (" +
					"email VARCHAR(100) NOT NULL," +
					"nombre VARCHAR(50) NOT NULL," +
					"domicilio VARCHAR(50) NOT NULL," +
					"nif VARCHAR(20) NOT NULL," +
					"tipoCliente ENUM('Estandar', 'Premium') NOT NULL," +
					"cuotaAnual DOUBLE," +
					"dtoGtoEnvio DOUBLE," +
					"PRIMARY KEY (nif)" +
					")";
			String sqlPedido = "CREATE TABLE IF NOT EXISTS pedidos (" +
					"numPedido INT AUTO_INCREMENT," +
					"cliente_nif VARCHAR(20) NOT NULL," +
					"articulo_codigo VARCHAR(50) NOT NULL," +
					"fechaHora DATE NOT NULL," +
					"cantUnidades INT NOT NULL," +
					"enviado TINYINT(1) NOT NULL DEFAULT 0," +
					"PRIMARY KEY (numPedido)," +
					"FOREIGN KEY (articulo_codigo) REFERENCES articulos(codigo)," +
					"FOREIGN KEY (cliente_nif) REFERENCES clientes(nif)" +
					")";
			// Ejecutar la sentencia SQL
			try {
				sentencia.executeUpdate(sqlArticulo);
				sentencia.executeUpdate(sqlCliente);
				sentencia.executeUpdate(sqlPedido);
				System.out.println("Tablas creadas correctamente.");
			} catch (SQLException e) {
				System.out.println("Ha ocurrido el siguiente error al crear las tablas: " + e.getMessage());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
