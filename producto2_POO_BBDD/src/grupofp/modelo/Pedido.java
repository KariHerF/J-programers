package grupofp.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
/**
 * @author J-Programers
 *
 */

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_pedido")
	private int numPedido;
	
	@Column(name="fecha_pedido")
	private LocalDateTime fechaHora;
	
	@Column(name="cantidad")
	private int cantUnidades;
	
	@Column(name="codigo_articulo")
	private String cocigoAticulo;
	
	@Column(name="email")
	private String emailCliente;
	
	@Transient
	private boolean enviado = false;
	@Transient
	private Cliente cliente;
	@Transient
	private Articulo articulo;

	

	private static final String CLIENTE_PREMIUM = "premium";

	// Constructor por defecto, necesario para ciertas operativas de Hibernate
	public Pedido() {
	}

	/**
	 * @param cliente
	 * @param articulo
	 * @param fechaHora
	 * @param cantUnidades
	 * @param enviado
	 */
	public Pedido(Cliente cliente, Articulo articulo, LocalDateTime fechaHora, int cantUnidades) {
		this.cliente = cliente;
		this.articulo = articulo;
		this.fechaHora = fechaHora;
		this.cantUnidades = cantUnidades;
	}

	/**
	 * @return the numPedido
	 */
	public int getNumPedido() {
		return numPedido;
	}

	/**
	 * @param numPedido the numPedido to set
	 */
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}


	/**
	 * @return the cantUnidades
	 */
	public int getCantUnidades() {
		return cantUnidades;
	}

	/**
	 * @param cantUnidades the cantUnidades to set
	 */
	public void setCantUnidades(int cantUnidades) {
		this.cantUnidades = cantUnidades;
	}

	/**
	 * @return the enviado
	 */
	public boolean pedidoEnviado() {
		LocalDateTime fechaHora_pedido;
		LocalDateTime fechaHora_actual = LocalDateTime.now();
		LocalDateTime fechaHora_pedido_con_tiempo_prep_articulo_sumado;
		Duration duracion_prep_articulo_de_pedido;

		fechaHora_pedido = this.getFechaHora();
		duracion_prep_articulo_de_pedido = Duration.ofSeconds(this.getArticulo().getTiempoPrep());

		fechaHora_pedido_con_tiempo_prep_articulo_sumado =  fechaHora_pedido.plus(duracion_prep_articulo_de_pedido);

		// Comparar los dos objetos LocalDateTime
		int resultado_com_fechas = fechaHora_actual.compareTo(fechaHora_pedido_con_tiempo_prep_articulo_sumado);

		if (resultado_com_fechas < 0) {
			enviado = false;
		} else {
			enviado = true;
		}
		return enviado;
	}

	/**
	 * @return the articulo
	 */
	public Articulo getArticulo() {
		return articulo;
	}


	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	/**
	 * @return the cocigoAticulo
	 */
	public String getCocigoAticulo() {
		return cocigoAticulo;
	}

	/**
	 * @param cocigoAticulo the cocigoAticulo to set
	 */
	public void setCocigoAticulo(String cocigoAticulo) {
		this.cocigoAticulo = cocigoAticulo;
	}

	/**
	 * @return the emailCliente
	 */
	public String getEmailCliente() {
		return emailCliente;
	}

	/**
	 * @param emailCliente the emailCliente to set
	 */
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}



	public float precioEnvio() {
		if (this.cliente.tipoCliente().equals(CLIENTE_PREMIUM)) {
			return this.articulo.getGastosEnvio() * this.cantUnidades * (1- this.cliente.descuentoEnv());
		}
		return this.articulo.getGastosEnvio()*this.cantUnidades;
	}



	@Override
	public String toString() {
		return "Pedido [N�mero pedido =" + getNumPedido() + ", Fecha y hora =" + getFechaHora() +
				", NIF Cliente=" + getCliente().getNif() + ", Nombre Cliente=" + getCliente().getNombre() +
			    ", C�digo Art�culo=" + getArticulo().getCodigo() + ", Descripci�n art�culo=" + getArticulo().getDescripcion() +
				", N�mero de unidades =" + getCantUnidades() + ", Precio art�culo=" + getArticulo().getPvp() +
				", Coste env�o =" + precioEnvio()/this.cantUnidades + ", Coste total =" + getArticulo().getPvp() * this.cantUnidades +
				", �Ha sido enviado?=" + pedidoEnviado() + "]";
	}



}
