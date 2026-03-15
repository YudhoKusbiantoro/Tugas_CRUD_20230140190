package com.example.crud3.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ktp")
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomorktp", unique = true, nullable = false, length = 16)
    private String nomorktp;

    @Column(name = "namalengkap", nullable = false)
    private String namalengkap;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tanggallahir")
    private LocalDate tanggallahir;

    @Column(name = "jeniskelamin")
    private String jeniskelamin;

    // Constructors
    public Ktp() {}

    public Ktp(String nomorktp, String namalengkap, String alamat,
               LocalDate tanggallahir, String jeniskelamin) {
        this.nomorktp = nomorktp;
        this.namalengkap = namalengkap;
        this.alamat = alamat;
        this.tanggallahir = tanggallahir;
        this.jeniskelamin = jeniskelamin;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomorktp() {
        return nomorktp;
    }

    public void setNomorktp(String nomorktp) {
        this.nomorktp = nomorktp;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public LocalDate getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(LocalDate tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }
}