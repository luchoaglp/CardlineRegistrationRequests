package com.cardlinesrl.repository;

import com.cardlinesrl.domain.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Integer> {

    Participant findByVirtualId(Integer virtualId);

}
