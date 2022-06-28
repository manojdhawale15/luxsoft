package com.example.luxoft.services;

import com.example.luxoft.dao.NaceDetailsRepository;
import com.example.luxoft.model.NaceDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NaceDetailsServiceImpl implements NaceDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NaceDetailsServiceImpl.class);

    private final NaceDetailsRepository naceDetailsRepository;

    @Autowired
    NaceDetailsServiceImpl(NaceDetailsRepository naceDetailsRepository){
        this.naceDetailsRepository = naceDetailsRepository;
    }

    @Override
    @Transactional
    public void saveAll(List<NaceDetail> naceDetails) {
      naceDetailsRepository.saveAll(naceDetails);
    }

    @Override
    public NaceDetail save(NaceDetail naceDetails) {
        return naceDetailsRepository.save(naceDetails);
    }

    @Override
    public NaceDetail findByOrderId(int orderId) {
        return naceDetailsRepository.findById(orderId).get();

    }

    @Override
    public List<NaceDetail> findAllByOrderId() {
        return naceDetailsRepository.findAll();
    }

    @Override
    public void deleteById(int orderId) {

    }

    public Optional<NaceDetail> findById(int orderId) {
      return naceDetailsRepository.findById(orderId);
    }




}
