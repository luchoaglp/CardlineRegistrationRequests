package com.cardlinesrl.repository;


import com.cardlinesrl.domain.MerchantRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRequestRepository extends CrudRepository<MerchantRequest, Integer> {

    MerchantRequest save(MerchantRequest merchantRequest);

}
