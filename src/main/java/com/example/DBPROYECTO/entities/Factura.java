package com.example.DBPROYECTO.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;


@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Boolean pagado;
    private Date fecha;
    @NotNull
    private Double total;
    @ManyToOne
    @JoinColumn(name = "tipo_factura_id", nullable = false)
    private TipoFactura tipoFactura;
    @ManyToOne
    @JoinColumn(name = "tipo_pago_id", nullable = false)
    private  TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "cliente_id") // Asegúrate de que esta columna exista en la tabla.
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "factura_producto", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "factura_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;



    public Factura() {
    }

    public Factura(Long id, Boolean pagado, Date fecha, Double total, TipoFactura tipoFactura, TipoPago tipoPago, Cliente cliente, List<Producto> productos) {
        this.id = id;
        this.pagado = pagado;
        this.fecha = fecha;
        this.total = total;
        this.tipoFactura = tipoFactura;
        this.tipoPago = tipoPago;
        this.cliente = cliente;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Boolean getPagado() {
        return pagado;
    }

    public void setPagado(@NotNull Boolean pagado) {
        this.pagado = pagado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public @NotNull Double getTotal() {
        return total;
    }

    public void setTotal(@NotNull Double total) {
        this.total = total;
    }

    public TipoFactura getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFactura tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", pagado=" + pagado +
                ", fecha=" + fecha +
                ", total=" + total +
                ", tipoFactura=" + tipoFactura +
                ", tipoPago=" + tipoPago +
                ", cliente=" + cliente +
                ", productos=" + productos +
                '}';
    }
}