package com.practica.hitfactor.jpa.entity.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base entity
 */
@MappedSuperclass
public abstract class AbstractEntity<T> {
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Id
    private T id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s{id='%s'}", getClass().getSimpleName(), id);
    }
}
