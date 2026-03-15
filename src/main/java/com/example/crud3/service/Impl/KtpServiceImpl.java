package com.example.crud3.service.Impl;

import com.example.crud3.mapper.KtpMapper;
import com.example.crud3.model.dto.KtpAddRequest;
import com.example.crud3.model.dto.KtpDto;
import com.example.crud3.model.entity.Ktp;
import com.example.crud3.repository.KtpRepository;
import com.example.crud3.service.KtpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class KtpServiceImpl implements KtpService {

    private final KtpRepository ktpRepository;
    private final KtpMapper ktpMapper;

    public KtpServiceImpl(KtpRepository ktpRepository, KtpMapper ktpMapper) {
        this.ktpRepository = ktpRepository;
        this.ktpMapper = ktpMapper;
    }

    @Override
    public KtpDto createKtp(KtpAddRequest request) {
        // Validasi nomor KTP sudah ada atau tidak
        if (ktpRepository.existsByNomorktp(request.getNomorktp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar");
        }

        Ktp ktp = ktpMapper.toEntity(request);
        Ktp savedKtp = ktpRepository.save(ktp);
        return ktpMapper.toDto(savedKtp);
    }

    @Override
    @Transactional(readOnly = true)
    public KtpDto getKtpById(Long id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan dengan id: " + id));
        return ktpMapper.toDto(ktp);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KtpDto> getAllKtp() {
        return ktpRepository.findAll().stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto updateKtp(Long id, KtpAddRequest request) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan dengan id: " + id));

        // Validasi nomor KTP jika diubah
        if (!ktp.getNomorktp().equals(request.getNomorktp()) &&
                ktpRepository.existsByNomorktp(request.getNomorktp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar");
        }

        ktp.setNomorktp(request.getNomorktp());
        ktp.setNamalengkap(request.getNamalengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggallahir(request.getTanggallahir());
        ktp.setJeniskelamin(request.getJeniskelamin());

        Ktp updatedKtp = ktpRepository.save(ktp);
        return ktpMapper.toDto(updatedKtp);
    }

    @Override
    public void deleteKtp(Long id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan dengan id: " + id));
        ktpRepository.delete(ktp);
    }
}