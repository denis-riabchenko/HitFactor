package com.practica.hitfactor.jpa.entity.common;

import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Base class for entities with auto-generated UUID as ID
 */
@MappedSuperclass
public abstract class AutoEntity extends AbstractEntity<String> {
    public AutoEntity() {
        setId(UUID.randomUUID().toString());
    }
}
