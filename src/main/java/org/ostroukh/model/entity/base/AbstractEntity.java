package org.ostroukh.model.entity.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Base class for all business entities
 * @author Eugene Ostroukh
 */
@MappedSuperclass
public abstract class AbstractEntity {
    public static final String FIELD_MODIFIED_AT = "modifiedAt";
    /**
     * Unique entity identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Timestamp of entity creation
     */
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Timestamp of entity update
     */
    @Column(name = "MODIFIED_AT", insertable = false)
    private LocalDateTime modifiedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    /**
     * Sets creation date and last modified date
     */
    @PrePersist
    public void prePersist(){
        if(getId() == 0){
            setCreatedAt(LocalDateTime.now());
            setModifiedAt(LocalDateTime.now());
        }else setModifiedAt(LocalDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(createdAt, that.createdAt)
                .append(modifiedAt, that.modifiedAt)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(createdAt)
                .append(modifiedAt)
                .toHashCode();
    }
}
