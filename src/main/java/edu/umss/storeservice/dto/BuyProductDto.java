/**
 * @author: Edson A. Terceros T.
 * 05
 */

package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Buy;
import edu.umss.storeservice.model.BuyProduct;

public class BuyProductDto extends DtoBase<BuyProduct> {
    private Integer q;

    public Integer getQ() {
        return q;
    }

    public void setQ(Integer q) {
        this.q = q;
    }

    public Buy getBuyByBuyId() {
        return buyByBuyId;
    }

    public void setBuyByBuyId(Buy buyByBuyId) {
        this.buyByBuyId = buyByBuyId;
    }

    private Buy buyByBuyId;

}