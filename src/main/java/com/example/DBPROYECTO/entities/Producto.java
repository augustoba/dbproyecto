package com.example.DBPROYECTO.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo NOMBRE")
    private String nombre;
    @NotNull
    private Double precio;
    @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo DESCRIPCION")
    private String descripcion;

    private Long codigo;
    @ManyToOne // Define la relación de muchos a uno con Proveedor
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @ManyToOne // Relación de muchos a uno con TipoProducto
    @JoinColumn(name = "tipo_producto_id", nullable = false)
    private TipoProducto tipoProducto;

    private Boolean disponible;

    private String imageURL;



    public Producto() {
    }

    public Producto(Long id, String nombre, Double precio, String descripcion, Long codigo, Proveedor proveedor, TipoProducto tipoProducto, Boolean disponible, String imageURL) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.tipoProducto = tipoProducto;
        this.disponible = disponible;
        this.imageURL = imageURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo NOMBRE") String getNombre() {
        return nombre;
    }

    public void setNombre(@Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo NOMBRE") String nombre) {
        this.nombre = nombre;
    }

    public @NotNull Double getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull Double precio) {
        this.precio = precio;
    }

    public @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo DESCRIPCION") String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo DESCRIPCION") String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", codigo=" + codigo +
                ", proveedor=" + proveedor +
                ", tipoProducto=" + tipoProducto +
                ", disponible=" + disponible +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
