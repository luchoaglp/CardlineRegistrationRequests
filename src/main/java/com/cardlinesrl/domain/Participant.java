package com.cardlinesrl.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "participant_type")
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "participant_id")
    protected Integer participantId;

    @Column(name = "virtual_id")
    protected Integer virtualId;

    @Column(name = "participant_name", length = 50, nullable = false)
    protected String participantName;

    @Column(name = "participant_type", length = 1, nullable = false)
    protected String participantType;

    @Column(name = "participant_phone", nullable = false)
    protected String participantPhone;

    @Column(name = "participant_active", nullable = false)
    protected Boolean participantActive;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    protected Participant owner;

    public Participant() {
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getVirtualId() {
        return virtualId;
    }

    public void setVirtualId(Integer virtualId) {
        this.virtualId = virtualId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType(String participantType) {
        this.participantType = participantType;
    }

    public String getParticipantPhone() {
        return participantPhone;
    }

    public void setParticipantPhone(String participantPhone) {
        this.participantPhone = participantPhone;
    }

    public Boolean getParticipantActive() {
        return participantActive;
    }

    public void setParticipantActive(Boolean participantActive) {
        this.participantActive = participantActive;
    }

    public Participant getOwner() {
        return owner;
    }

    public void setOwner(Participant owner) {
        this.owner = owner;
    }

}

