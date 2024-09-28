package com.example.Nutrit.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table (name="Administrativos")
public class Administrativos {

    @Id
    @Column(name = "administrativo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int administrativoId;

    @OneToOne
    //Indica que administrativoId será tanto la PK como la FK
    @MapsId
    @JoinColumn(name = "administrativo_id")
    private Usuarios usuario;  // Relación con Usuarios

    @Column(name = "area_responsable")
    private String areaResponsable;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "perfil")
    private String perfil;

//Getter y Setter


    public int getAdministrativoId() {
        return administrativoId;
    }

    public void setAdministrativoId(int administrativoId) {
        this.administrativoId = administrativoId;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getAreaResponsable() {
        return areaResponsable;
    }

    public void setAreaResponsable(String areaResponsable) {
        this.areaResponsable = areaResponsable;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    //Constructores
    public Administrativos() {
    }

    public Administrativos(int administrativoId, Usuarios usuario, String areaResponsable, String telefono, LocalDate fechaIngreso, String perfil) {
        this.administrativoId = administrativoId;
        this.usuario = usuario;
        this.areaResponsable = areaResponsable;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Administrativos{" +
                "administrativoId=" + administrativoId +
                ", usuario=" + usuario +
                ", areaResponsable='" + areaResponsable + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
