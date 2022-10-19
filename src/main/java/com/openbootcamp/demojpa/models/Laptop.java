package com.openbootcamp.demojpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptops")
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String procesador;
	private Integer memoriaRam;
	private Double price;
	private Boolean conexionBluetooth;
	
	public Laptop() {
		super();
	}

	public Laptop(Long id, String marca, String procesador, Integer memoriaRam, Double price,
			Boolean conexionBluetooth) {
		super();
		this.id = id;
		this.marca = marca;
		this.procesador = procesador;
		this.memoriaRam = memoriaRam;
		this.price = price;
		this.conexionBluetooth = conexionBluetooth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public Integer getMemoriaRam() {
		return memoriaRam;
	}

	public void setMemoriaRam(Integer memoriaRam) {
		this.memoriaRam = memoriaRam;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getConexionBluetooth() {
		return conexionBluetooth;
	}

	public void setConexionBluetooth(Boolean conexionBluetooth) {
		this.conexionBluetooth = conexionBluetooth;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", marca=" + marca + ", procesador=" + procesador + ", memoriaRam=" + memoriaRam
				+ ", price=" + price + ", conexionBluetooth=" + conexionBluetooth + "]";
	}
	



	
	
}

