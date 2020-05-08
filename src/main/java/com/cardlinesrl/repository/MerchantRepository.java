package com.cardlinesrl.repository;


import com.cardlinesrl.domain.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Integer> {

    //List<Merchant> findByMerchantOwnerIdAndMerchantActiveAndMerchantSubeOrderByMerchantNameAsc(Integer ownerId, Boolean active, Boolean isSube);

    @Query("SELECT m FROM Merchant m WHERE m.merchantSube = FALSE AND m.virtualId IS NOT NULL AND m.participantActive = TRUE AND m.owner.participantId = ?1 ORDER BY m.participantName ASC")
    List<Merchant> findByOwnerNotSube(Integer ownerId);

    Merchant findByVirtualId(Integer virtualId);
}
