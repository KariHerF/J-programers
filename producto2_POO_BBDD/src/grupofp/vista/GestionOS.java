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
			System.out.println("No se ha podido mostrar la lista de art�culos ya que no se ha registrado ning�n art�culo hasta el momento.");
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
