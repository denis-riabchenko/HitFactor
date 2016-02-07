package com.practica.hitfactor.jpa.entity.common;

import javax.persistence.MappedSuperclass;

/**
 * Base class for entities with non auto-generated IDs
 */
@MappedSuperclass
public abstract class Entity<T> extends AbstractEntity<T> {
    @Override
    public void setId(T id) {
        super.setId(id);
    }
}
