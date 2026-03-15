package com.example.crud3.controller;

import com.example.crud3.model.dto.KtpAddRequest;
import com.example.crud3.model.dto.KtpDto;
import com.example.crud3.service.KtpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ktp")
public class KtpController {

    private final KtpService ktpService;

    public KtpController(KtpService ktpService) {
        this.ktpService = ktpService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createKtp(@RequestBody KtpAddRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            KtpDto createdKtp = ktpService.createKtp(request);
            response.put("success", true);
            response.put("message", "Data KTP berhasil ditambahkan");
            response.put("data", createdKtp);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllKtp() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<KtpDto> ktpList = ktpService.getAllKtp();
            response.put("success", true);
            response.put("message", "Data KTP berhasil diambil");
            response.put("data", ktpList);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getKtpById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            KtpDto ktp = ktpService.getKtpById(id);
            response.put("success", true);
            response.put("message", "Data KTP berhasil diambil");
            response.put("data", ktp);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateKtp(@PathVariable Long id,
                                                         @RequestBody KtpAddRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            KtpDto updatedKtp = ktpService.updateKtp(id, request);
            response.put("success", true);
            response.put("message", "Data KTP berhasil diperbarui");
            response.put("data", updatedKtp);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteKtp(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            ktpService.deleteKtp(id);
            response.put("success", true);
            response.put("message", "Data KTP berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}