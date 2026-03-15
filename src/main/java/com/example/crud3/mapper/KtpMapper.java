package com.example.crud3.mapper;

import com.example.crud3.model.dto.KtpAddRequest;
import com.example.crud3.model.dto.KtpDto;
import com.example.crud3.model.entity.Ktp;
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {

    public Ktp toEntity(KtpAddRequest request) {
        Ktp ktp = new Ktp();
        ktp.setNomorktp(request.getNomorktp());
        ktp.setNamalengkap(request.getNamalengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggallahir(request.getTanggallahir());
        ktp.setJeniskelamin(request.getJeniskelamin());
        return ktp;
    }

    public KtpDto toDto(Ktp ktp) {
        return new KtpDto(
                ktp.getId(),
                ktp.getNomorktp(),
                ktp.getNamalengkap(),
                ktp.getAlamat(),
                ktp.getTanggallahir(),
                ktp.getJeniskelamin()
        );
    }
}
