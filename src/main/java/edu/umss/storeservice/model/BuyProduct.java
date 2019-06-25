package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.BuyProductDto;
import edu.umss.storeservice.dto.DtoBase;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "buy_product", schema = "dbo", catalog = "ShippingForce")
public class BuyProduct extends ModelBase<BuyProductDto> {
   // private Long id;
    private Integer q;
    private Buy buyByBuyId;

    //@Id
    //@Column(name = "id", nullable = false)
    //public Long getId() {
    //    return id;
    //}

    //public void setId(Long id) {
    //    this.id = id;
    //}

    @Basic
    @Column(name = "q", nullable = true)
    public Integer getQ() {
        return q;
    }

    public void setQ(Integer q) {
        this.q = q;
    }


    @ManyToOne
    @JoinColumn(name = "buy_id", referencedColumnName = "id")
    public Buy getBuyByBuyId() {
        return buyByBuyId;
    }

    public void setBuyByBuyId(Buy buyByBuyId) {
        this.buyByBuyId = buyByBuyId;
    }
}
