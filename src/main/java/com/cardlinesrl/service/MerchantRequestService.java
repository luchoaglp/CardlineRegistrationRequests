package com.cardlinesrl.service;

import com.cardlinesrl.domain.MerchantRequest;
import com.cardlinesrl.repository.MerchantRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantRequestService {

    @Autowired
    MerchantRequestRepository merchantRequestRepository;

    public MerchantRequest add(MerchantRequest merchantRequest) {

        return merchantRequestRepository.save(merchantRequest);
    }
}
