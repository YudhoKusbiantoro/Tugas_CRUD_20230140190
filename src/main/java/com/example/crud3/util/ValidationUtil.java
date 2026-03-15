package com.example.crud3.util;

import com.example.crud3.model.dto.KtpAddRequest;

public class ValidationUtil {

    public static void validateKtpRequest(KtpAddRequest request) {
        if (request.getNomorktp() == null || request.getNomorktp().trim().isEmpty()) {
            throw new IllegalArgumentException("Nomor KTP tidak boleh kosong");
        }

        if (request.getNomorktp().length() != 16) {
            throw new IllegalArgumentException("Nomor KTP harus 16 digit");
        }

        if (request.getNamalengkap() == null || request.getNamalengkap().trim().isEmpty()) {
            throw new IllegalArgumentException("Nama lengkap tidak boleh kosong");
        }

        if (request.getJeniskelamin() == null || request.getJeniskelamin().trim().isEmpty()) {
            throw new IllegalArgumentException("Jenis kelamin tidak boleh kosong");
        }

        if (!request.getJeniskelamin().equalsIgnoreCase("L") &&
                !request.getJeniskelamin().equalsIgnoreCase("P")) {
            throw new IllegalArgumentException("Jenis kelamin harus L atau P");
        }
    }
}