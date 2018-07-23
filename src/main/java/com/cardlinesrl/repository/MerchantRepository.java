package com.cardlinesrl.repository;


import com.cardlinesrl.domain.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Integer> {

    List<Merchant> findByMerchantOwnerIdAndMerchantActiveAndMerchantSubeOrderByMerchantNameAsc(Integer ownerId, Boolean active, Boolean isSube);

    Merchant findByPlataformaId(Integer plataformaId);
}
