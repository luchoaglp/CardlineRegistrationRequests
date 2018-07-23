package com.cardlinesrl.service;

import com.cardlinesrl.domain.Reseller;
import com.cardlinesrl.repository.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResellerService {

    @Autowired
    ResellerRepository resellerRepository;

    public Reseller findByPlataformaId(Integer resellerId) {
        return resellerRepository.findByPlataformaId(resellerId);
    }
}
