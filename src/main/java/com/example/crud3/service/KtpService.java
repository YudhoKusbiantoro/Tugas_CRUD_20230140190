package com.example.crud3.service;

import com.example.crud3.model.dto.KtpAddRequest;
import com.example.crud3.model.dto.KtpDto;

import java.util.List;

public interface KtpService {
    KtpDto createKtp(KtpAddRequest request);
    KtpDto getKtpById(Long id);
    List<KtpDto> getAllKtp();
    KtpDto updateKtp(Long id, KtpAddRequest request);
    void deleteKtp(Long id);
}
