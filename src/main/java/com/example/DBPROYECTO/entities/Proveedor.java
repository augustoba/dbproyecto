package com.example.DBPROYECTO.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "\\d+", message = "El campo CUIT solo debe contener números")
    private Long cuit;
    @Size(min = 4, max = 30, message = "Debe ingresar un mínimo de 4 caracteres y máximo 30 para el campo NOMBRE")
    private String nombre;
    @Size(min = 9, max = 15, message = "Debe ingresar un mínimo de 9 caracteres y máximo 11 para el campo TELEFONO")
    private String telefono;
    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El formato del email no es válido")
    private String email;
    @Size(min = 4, max = 30, message = "Debe ingresar un mínimo de 30 caracteres y máximo 11 para el campo DIRECCION")
    private String direccion;
    @Size(min = 4, max = 9, message = "Debe ingresar un mínimo de 9 caracteres y máximo 11 para el campo CBU")
    private String cbu;
    @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo DESCRIPCION")
    private String descripcion;

    public Proveedor() {
    }

    public Proveedor(Long id, Long cuit, String nombre, String telefono, String email, String direccion, String cbu, String descripcion) {
        this.id = id;
        this.cuit = cuit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.cbu = cbu;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Long getCuit() {
        return cuit;
    }

    public void setCuit(@NotNull Long cuit) {
        this.cuit = cuit;
    }

    public @NotNull String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public @NotNull String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotNull String telefono) {
        this.telefono = telefono;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotNull String direccion) {
        this.direccion = direccion;
    }

    public @NotNull String getCbu() {
        return cbu;
    }

    public void setCbu(@NotNull String cbu) {
        this.cbu = cbu;
    }

    public @NotNull String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", cuit=" + cuit +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cbu='" + cbu + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
