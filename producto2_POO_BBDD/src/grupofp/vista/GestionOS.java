/**
 * 
 */
package grupofp.vista;

import java.time.Duration;

import grupofp.controlador.Controlador;
import grupofp.modelo.Articulo;
import java.util.Date;
import java.util.Scanner;

import grupofp.modelo.Cliente;
import grupofp.modelo.ClienteEstandar;
import grupofp.modelo.ClientePremium;
/**
 * @author J-Programers
 *
 */
public class GestionOS {
	
	private Controlador miControlador; //objeto miControlador que permite la relacion entre esta clase y la clase Controlador
	
	
	public void setControlador(Controlador miControlador) {
		this.miControlador=miControlador;
	}
	
	public void anadirArticuloVistaGestionOS() {
		
		try {
			String codigo_articulo;
	 	    String descripcion_articulo;
	 	    float pvp_articulo;
	 	    String tiempoPrep_articulo;
	 	    Duration tiempoPrep_articulo_parsed;
	 	    float gastosEnvioArticulo;
	 	    
	 		System.out.println("Introducir c�digo del art�culo:");
	 		Scanner sn_codigo_articulo = new Scanner(System.in);
	 		codigo_articulo = sn_codigo_articulo.nextLine();
	 		
	 		System.out.println("Introducir descripci�n del art�culo:");
	 		Scanner sn_descripcion_articulo = new Scanner(System.in);
	 		descripcion_articulo = sn_descripcion_articulo.nextLine();
	 		
	 		System.out.println("Introducir pvp del art�culo:");
	 		Scanner sn_pvp_articulo = new Scanner(System.in);
	 		pvp_articulo = sn_descripcion_articulo.nextFloat();
	 		
	 		System.out.println("Introducir el tiempo de preparaci�n del art�culo:");
	 		System.out.println("(la duraci�n del tiempo de preparaci�n debe introducirse en formato ISO 8601 (PTnHnMnS))");
	 		Scanner sn_tiempo_prep_articulo = new Scanner(System.in);
	 		tiempoPrep_articulo = sn_tiempo_prep_articulo.nextLine();
	 		Duration duration = Duration.parse(tiempoPrep_articulo);
	 		tiempoPrep_articulo_parsed = duration;
	 		
	 		System.out.println("Introducir gastos env�o del art�culo:");
	 		Scanner sn_gastos_envio_articulo = new Scanner(System.in);
	 		gastosEnvioArticulo = sn_descripcion_articulo.nextFloat();
	 		
	 		this.miControlador.crearArticulo(codigo_articulo, descripcion_articulo, pvp_articulo, tiempoPrep_articulo_parsed, gastosEnvioArticulo);		
		} catch (Exception ex) {
			// printStackTrace method
            // prints line numbers + call stack
            ex.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(ex);
		}
	}

	public void mostrarArticulos() {
		if (this.miControlador.getListaArticulos().size() > 0) {
			for (Articulo articulo : this.miControlador.getListaArticulos()) {
			    System.out.println(articulo.toString());
			}
		} else {
			System.out.println("No se ha podido mostrar la lista de art�culos, ya que no se ha registrado ning�n art�culo hasta el momento.");
		}
	}
	
	public void anadirClienteVistaGestionOS() {
		
		try {
			String email_cliente;
			String nombre_cliente;
			String domicilio_cliente;
			String nif_cliente;
			String tipo_cliente;
	 	    
	 		System.out.println("Introducir email de cliente:");
	 		Scanner sn_email_cliente = new Scanner(System.in);
	 		email_cliente = sn_email_cliente.nextLine();
	 		
	 		System.out.println("Introducir nombre del cliente:");
	 		Scanner sn_nombre_cliente = new Scanner(System.in);
	 		nombre_cliente = sn_nombre_cliente.nextLine();
	 		
	 		System.out.println("Introducir domicilio del cliente:");
	 		Scanner sn_domicilio_cliente = new Scanner(System.in);
	 		domicilio_cliente = sn_domicilio_cliente.nextLine();
	 		
	 		System.out.println("Introducir NIF del cliente:");
	 		Scanner sn_nif_cliente = new Scanner(System.in);
	 		nif_cliente = sn_nif_cliente.nextLine();
	 		
	 		System.out.println("Introducir tipo de cliente:");
	 		Scanner sn_tipo_cliente = new Scanner(System.in);
	 		tipo_cliente = sn_tipo_cliente.nextLine();
	 		
	 		this.miControlador.crearCliente(email_cliente, nombre_cliente, domicilio_cliente, nif_cliente, tipo_cliente);
	 		
		
		} catch (Exception ex) {
			// printStackTrace method
            // prints line numbers + call stack
            ex.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(ex);
		}
	}
	
	public void mostrarClientes() {
		if (this.miControlador.getListaClientes().size() > 0) {
			for (Cliente cliente : this.miControlador.getListaClientes()) {
			    System.out.println(cliente.toString());
			}
		} else {
			System.out.println("No se ha podido mostrar la lista de clientes, ya que no se ha registrado ning�n cliente hasta el momento.");
		}
	}
	
	public void mostrarClientesEstandar() {
		if (this.miControlador.getListaClientesEstandar().size() > 0) {
			for (ClienteEstandar cliente_estandar : this.miControlador.getListaClientesEstandar()) {
			    System.out.println(cliente_estandar.toString());
			}
		} else {
			System.out.println("No se ha podido mostrar la lista de clientes est�ndar, ya que no se ha registrado ning�n cliente est�ndar hasta el momento.");
		}
	}
	
	public void mostrarClientesPremium() {
		if (this.miControlador.getListaClientesPremium().size() > 0) {
			for (ClientePremium cliente_premium : this.miControlador.getListaClientesPremium()) {
			    System.out.println(cliente_premium.toString());
			}
		} else {
			System.out.println("No se ha podido mostrar la lista de clientes premium, ya que no se ha registrado ning�n cliente premium hasta el momento.");
		}
	}
	
	public void anadirPedidoVistaGestionOS() {
		
		try {
			String codigo_articulo;
	 	    String descripcion_articulo;
	 	    float pvp_articulo;
	 	    String tiempoPrep_articulo;
	 	    Duration tiempoPrep_articulo_parsed;
	 	    float gastosEnvioArticulo;
	 	    
	 		System.out.println("Introducir c�digo del art�culo:");
	 		Scanner sn_codigo_articulo = new Scanner(System.in);
	 		codigo_articulo = sn_codigo_articulo.nextLine();
	 		
	 		System.out.println("Introducir descripci�n del art�culo:");
	 		Scanner sn_descripcion_articulo = new Scanner(System.in);
	 		descripcion_articulo = sn_descripcion_articulo.nextLine();
	 		
	 		System.out.println("Introducir pvp del art�culo:");
	 		Scanner sn_pvp_articulo = new Scanner(System.in);
	 		pvp_articulo = sn_descripcion_articulo.nextFloat();
	 		
	 		System.out.println("Introducir el tiempo de preparaci�n del art�culo:");
	 		System.out.println("(la duraci�n del tiempo de preparaci�n debe introducirse en formato ISO 8601 (PTnHnMnS))");
	 		Scanner sn_tiempo_prep_articulo = new Scanner(System.in);
	 		tiempoPrep_articulo = sn_tiempo_prep_articulo.nextLine();
	 		Duration duration = Duration.parse(tiempoPrep_articulo);
	 		tiempoPrep_articulo_parsed = duration;
	 		
	 		System.out.println("Introducir gastos env�o del art�culo:");
	 		Scanner sn_gastos_envio_articulo = new Scanner(System.in);
	 		gastosEnvioArticulo = sn_descripcion_articulo.nextFloat();
	 		
	 		this.miControlador.crearArticulo(codigo_articulo, descripcion_articulo, pvp_articulo, tiempoPrep_articulo_parsed, gastosEnvioArticulo);		
		} catch (Exception ex) {
			// printStackTrace method
            // prints line numbers + call stack
            ex.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(ex);
		}
	}

	
	public void printClienteDetalles(String nombre, String domicilio, String nif, String email, Class tipo, float calcAnual, float descuentoEnv) {
		System.out.println("**** DATOS CLIENTE ****");
		System.out.println("Id: " + nombre);
		System.out.println("Nombre: " + domicilio);
		System.out.println("NIF: " + nif);
		System.out.println("Email: " + email);
		System.out.println("tipo: " + tipo);
		System.out.println("cuota anual: " + calcAnual);
		System.out.println("descuento: " + descuentoEnv);
	}
	
	public void printArticuloDetalles(String codigo, String descripcion, Float pvp, Float gastosEnvio,
			Duration tiempoPrep) {
		System.out.println("**** DATOS ARTICULO ****");
		System.out.println("C�digo: " + codigo);
		System.out.println("Descripcion: " + descripcion);
		System.out.println("Pvp: " + pvp);
		System.out.println("Gastos de env�o: " + gastosEnvio);
		System.out.println("Tiempo de preparaci�n: " + tiempoPrep);

	}

	public void printPedidoDetalles(int numPedido, Cliente cliente, Articulo articulo, int cantUnidades, Date fechaHora, boolean enviado, float precioEnvio) {
		System.out.println("**** DATOS PEDIDO ****");
		System.out.println("Numero de pedido: " + numPedido);
		System.out.println("Cliente: " + cliente.toString());
		System.out.println("Articulo: " + articulo.toString());
		System.out.println("Unidades: " + cantUnidades);
		System.out.println("Fecha y hora: " + fechaHora);
		String msgEnviado = enviado ? "si" : "no";
		System.out.println("Enviado: " + msgEnviado);
		System.out.println("Precio envio: " + precioEnvio);

	}

}
