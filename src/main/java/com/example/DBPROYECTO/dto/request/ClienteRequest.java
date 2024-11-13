package com.example.DBPROYECTO.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo NOMBRE")
    private String nombre;
    @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo APELLIDO")
    private String apellido;
    @Pattern(regexp = "\\d+", message = "El campo TELEFONO solo debe contener números")
    private String telefono;
    @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo TELEFONO")
    private String direccion;
    @Size(min = 4, max = 5, message = "Debe ingresar un mínimo de 4 caracteres y máximo 5 para el campo CODIGOPOSTAL")
    private String codigoPostal;
    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El formato del email no es válido")
    private String email;
    @Pattern(regexp = "\\d+", message = "El campo CUIT solo debe contener números")
    private String cuit;

    public ClienteRequest() {
    }

    public ClienteRequest(Long id, String nombre, String apellido, String telefono, String direccion, String codigoPostal, String email, String cuit) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.cuit = cuit;
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

    public @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo APELLIDO") String getApellido() {
        return apellido;
    }

    public void setApellido(@Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo APELLIDO") String apellido) {
        this.apellido = apellido;
    }

    public @Pattern(regexp = "\\d+", message = "El campo TELEFONO solo debe contener números") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@Pattern(regexp = "\\d+", message = "El campo TELEFONO solo debe contener números") String telefono) {
        this.telefono = telefono;
    }

    public @Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo TELEFONO") String getDireccion() {
        return direccion;
    }

    public void setDireccion(@Size(min = 4, max = 50, message = "Debe ingresar un mínimo de 4 caracteres y máximo 50 para el campo TELEFONO") String direccion) {
        this.direccion = direccion;
    }

    public @Size(min = 4, max = 5, message = "Debe ingresar un mínimo de 4 caracteres y máximo 5 para el campo CODIGOPOSTAL") String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(@Size(min = 4, max = 5, message = "Debe ingresar un mínimo de 4 caracteres y máximo 5 para el campo CODIGOPOSTAL") String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public @NotNull(message = "El email no puede ser nulo") @Email(message = "El formato del email no es válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "El email no puede ser nulo") @Email(message = "El formato del email no es válido") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "\\d+", message = "El campo CUIT solo debe contener números") String getCuit() {
        return cuit;
    }

    public void setCuit(@Pattern(regexp = "\\d+", message = "El campo CUIT solo debe contener números") String cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "ClienteRequest{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", email='" + email + '\'' +
                ", cuit='" + cuit + '\'' +
                '}';
    }
}
