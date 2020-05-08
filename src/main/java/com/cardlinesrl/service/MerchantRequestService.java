package com.cardlinesrl.service;

import com.cardlinesrl.domain.MerchantRequest;
import com.cardlinesrl.repository.MerchantRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class MerchantRequestService {

    private final MerchantRequestRepository merchantRequestRepository;

    public MerchantRequestService(MerchantRequestRepository merchantRequestRepository) {
        this.merchantRequestRepository = merchantRequestRepository;
    }

    public MerchantRequest add(MerchantRequest merchantRequest) {

        return merchantRequestRepository.save(merchantRequest);
    }
}
