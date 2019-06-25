package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.BuyDto;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Buy")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "GetAllBuy",
                procedureName = "GetAllBuy",
                resultClasses = Buy.class
        ),
        @NamedStoredProcedureQuery(
                name = "DeleteBuyById",
                procedureName = "DeleteBuyById",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "GetBuyById",
                procedureName = "GetBuyById",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class)
                },
                resultClasses = Buy.class
        ),
        @NamedStoredProcedureQuery(
                name = "SaveBill",
                procedureName = "SaveBill",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "code", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "createdAt", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "isDeleted", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "k", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "version", type = Integer.class),
                },
                resultClasses = Buy.class
        )
})
public class Buy extends ModelBase<BuyDto> {
    private String k;
    private String code;

    public Buy(String k, String code) {
        this.k = k;
        this.code = code;
    }




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
