package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.PaymethodDto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Paymethod extends ModelBase<PaymethodDto>{
    private String shortName;
    private String name;
    private Boolean isActive;


    @Basic
    @Column(name = "short_name", nullable = true, length = 100)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "is_active", nullable = true)
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paymethod paymethod = (Paymethod) o;
        return  Objects.equals(shortName, paymethod.shortName) &&
                Objects.equals(name, paymethod.name) &&
                Objects.equals(isActive, paymethod.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortName, name, isActive);
    }
}
