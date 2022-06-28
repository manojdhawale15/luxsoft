package com.example.luxoft.services;

import com.example.luxoft.model.NaceDetail;

import java.util.List;

public interface NaceDetailsService {

    void saveAll(List<NaceDetail> naceDetails);

    NaceDetail save(NaceDetail naceDetails);

    NaceDetail findByOrderId(int orderId);

    void deleteById(int orderId);

    List<NaceDetail> findAllByOrderId();
}
