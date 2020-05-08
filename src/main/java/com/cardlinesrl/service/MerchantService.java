package com.cardlinesrl.service;

import com.cardlinesrl.domain.Merchant;
import com.cardlinesrl.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    /*
    public List<Merchant> findByMerchantOwnerId(Integer ownerId) {
        return merchantRepository.findByMerchantOwnerIdAndMerchantActiveAndMerchantSubeOrderByMerchantNameAsc(ownerId, true, false);
    }
    */

    public List<Merchant> findByOwnerNotSube(Integer ownerId) {
        return merchantRepository.findByOwnerNotSube(ownerId);
    }

    public Merchant findByVirtualId(Integer virtualId) {
        return merchantRepository.findByVirtualId(virtualId);
    }

}
