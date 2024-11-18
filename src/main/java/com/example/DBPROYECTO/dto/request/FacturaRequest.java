package com.example.DBPROYECTO.dto.request;

import com.example.DBPROYECTO.entities.TipoPago;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class FacturaRequest {
    @NotEmpty
    private List<String> productosListID;
    @NotNull
    private String clienteCUIT;
    @NotNull
    private String tipoFactura;
    @NotNull
    private Boolean pagado;
    @NotNull
    private String tipoPago;

    public FacturaRequest() {
    }

    public FacturaRequest(List<String> productosListID, String clienteCUIT, String tipoFactura, Boolean pagado, String tipoPago) {
        this.productosListID = productosListID;
        this.clienteCUIT = clienteCUIT;
        this.tipoFactura = tipoFactura;
        this.pagado = pagado;
        this.tipoPago = tipoPago;
    }

    public @NotEmpty List<String> getProductosListID() {
        return productosListID;
    }

    public void setProductosListID(@NotEmpty List<String> productosListID) {
        this.productosListID = productosListID;
    }

    public @NotNull String getClienteCUIT() {
        return clienteCUIT;
    }

    public void setClienteCUIT(@NotNull String clienteCUIT) {
        this.clienteCUIT = clienteCUIT;
    }

    public @NotNull String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(@NotNull String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public @NotNull Boolean getPagado() {
        return pagado;
    }

    public void setPagado(@NotNull Boolean pagado) {
        this.pagado = pagado;
    }

    public @NotNull String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(@NotNull String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "FacturaRequest{" +
                "productosListID=" + productosListID +
                ", clienteCUIT='" + clienteCUIT + '\'' +
                ", tipoFactura=" + tipoFactura +
                ", pagado=" + pagado +
                ", tipoPago=" + tipoPago +
                '}';
    }
}
