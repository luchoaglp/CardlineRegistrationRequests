package com.cardlinesrl.repository;


import com.cardlinesrl.domain.Reseller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResellerRepository extends CrudRepository<Reseller, Integer> {

    Reseller findByPlataformaId(Integer resellerId);

}
