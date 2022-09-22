package com.example.eventmanagement.domain.models;

import com.example.sharedkernel.domain.base.*;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist extends AbstractEntity<ArtistId> {
    private String name;
}
