package com.example.luxoft.dao;

import com.example.luxoft.model.NaceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NaceDetailsRepository extends JpaRepository<NaceDetail, Integer> {

}
