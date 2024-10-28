package org.example.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "cover_type")
public class CoverType{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cover_type",nullable = false,unique = true)
    private String coverType;

    public CoverType() {
    }

    public CoverType(Integer id, String coverType) {
        this.id = id;
        this.coverType = coverType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoverType coverType1 = (CoverType) o;
        return Objects.equals(id, coverType1.id) && Objects.equals(coverType, coverType1.coverType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coverType);
    }

    @Override
    public String toString() {
        return "CoverType{" +
                "id=" + id +
                ", coverType='" + coverType + '\'' +
                '}';
    }
}
