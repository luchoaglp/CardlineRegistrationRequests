package com.cardlinesrl.service;

import com.cardlinesrl.domain.Merchant;
import com.cardlinesrl.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    public List<Merchant> findByMerchantOwnerId(Integer ownerId) {
        return merchantRepository.findByMerchantOwnerIdAndMerchantActiveAndMerchantSubeOrderByMerchantNameAsc(ownerId, true, false);
    }

    public Merchant findByPlataformaId(Integer plataformaId) {
        return merchantRepository.findByPlataformaId(plataformaId);
    }
}
