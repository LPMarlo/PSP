package Tema3.ActEv.modelo;

import Tema3.ActEv.cliente.ClienteServicio;

public class Tienda {

	private String nombreEstablecimiento;
	private Integer idTienda;
	public ClienteServicio cs;
	
	/**
	 * Registra la tienda en el servicio.
	 * @param cs
	 * @param nombreEstablecimiento
	 */
	public Tienda(ClienteServicio cs, String nombreEstablecimiento) {
		this.cs = cs;
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.idTienda = this.cs.nuevoEstablecimiento(nombreEstablecimiento);
	}
	
	/**
	 * Registra el pedido pasado en ped en la tienda idTienda.
	 * @param ped
	 * @return
	 */
	public boolean registraPedido(Pedido ped) {
		int idPedido = cs.nuevoPedido(idTienda);
		boolean insertadoConExito = false;
		for (Producto p : ped.getProductosPedido()) {
			insertadoConExito = cs.anadirProducto(idTienda, idPedido, p.getCodProducto());
		}
		return insertadoConExito;
	}
}
