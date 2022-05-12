package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public Connection conectar() {
		Connection cn = null;
		try {
			String [] st = new String [1];
			Class.forName("com.microsoft.sqlserver.jdbc.SQLDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;DatabaseName=Pruebas");
			if(!cn.isValid(0)){
				System.out.println("Error de conexión");
			}
			else {
				System.out.println("conexion exitosa");
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return cn;
	}
}
