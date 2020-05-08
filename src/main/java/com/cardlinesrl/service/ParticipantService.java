package com.cardlinesrl.service;

import com.cardlinesrl.domain.Participant;
import com.cardlinesrl.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant findByVirtualId(Integer virtualId) {
        return participantRepository.findByVirtualId(virtualId);
    }

}
