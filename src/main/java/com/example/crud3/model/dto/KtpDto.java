package com.example.crud3.model.dto;

import java.time.LocalDate;

public class KtpDto {
    private Long id;
    private String nomorktp;
    private String namalengkap;
    private String alamat;
    private LocalDate tanggallahir;
    private String jeniskelamin;

    // Constructors
    public KtpDto() {}

    public KtpDto(Long id, String nomorktp, String namalengkap, String alamat,
                  LocalDate tanggallahir, String jeniskelamin) {
        this.id = id;
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
