/**
 * @author: Edson A. Terceros T.
 * 23
 */

package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Buy;

public class BuyDto extends DtoBase<Buy> {
    private String k;

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;
}