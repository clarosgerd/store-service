package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.BuyDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Buy")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "findBuy",
                procedureName = "sp_getAllBuy",
                resultClasses = { Buy.class })
})
public class Buy extends ModelBase<BuyDto> {
    //private Long id;
    private String k;

    public Buy(String k, String code) {
        this.k = k;
        this.code = code;
    }

    private String code;
    //private Timestamp createdAt;

    //@Id
    //@Column(name = "id", nullable = false)
    //public Long getId() {
    //  return id;
    //}

    //public void setId(Long id) {
    //    this.id = id;
    //}

    @Basic
    @Column(name = "k", nullable = true, length = 20)
    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 20)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buy buy = (Buy) o;
        return  Objects.equals(k, buy.k) &&
                Objects.equals(code, buy.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(k, code);
    }
}
