package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ProductDto;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_GetAll_Product",
                procedureName = "sp_get_all_product",
                resultClasses = Product.class
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Delete_Product_ById",
                procedureName = "sp_delete_product_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Get_Product_ById",
                procedureName = "sp_get_product_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class)
                },
                resultClasses = Product.class
        )
})
public class Product extends ModelBase<ProductDto> {
    private String shortNameProduct;
    private String nameProduct;
    private String codeProduct;
    private String description;
    private String offerTxt;
    private String linkProduct;
    private Boolean isFeatured;
    private Boolean isPublic;
    private Boolean inExistence;
    private Timestamp orderAt;
    private Double priceProduct;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;
    private Timestamp expirationDateProduct;
    private Timestamp startSaleDate;
    private Timestamp discontinuedDate;
    private Long subCategory;
    private Long unit;

    public String getShortNameProduct() {
        return shortNameProduct;
    }

    public void setShortNameProduct(String shortNameProduct) {
        this.shortNameProduct = shortNameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOfferTxt() {
        return offerTxt;
    }

    public void setOfferTxt(String offerTxt) {
        this.offerTxt = offerTxt;
    }

    public String getLinkProduct() {
        return linkProduct;
    }

    public void setLinkProduct(String linkProduct) {
        this.linkProduct = linkProduct;
    }

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Boolean getInExistence() {
        return inExistence;
    }

    public void setInExistence(Boolean inExistence) {
        this.inExistence = inExistence;
    }

    public Timestamp getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(Timestamp orderAt) {
        this.orderAt = orderAt;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public Timestamp getExpirationDateProduct() {
        return expirationDateProduct;
    }

    public void setExpirationDateProduct(Timestamp expirationDateProduct) {
        this.expirationDateProduct = expirationDateProduct;
    }

    public Timestamp getStartSaleDate() {
        return startSaleDate;
    }

    public void setStartSaleDate(Timestamp startSaleDate) {
        this.startSaleDate = startSaleDate;
    }

    public Timestamp getDiscontinuedDate() {
        return discontinuedDate;
    }

    public void setDiscontinuedDate(Timestamp discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public Long getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Long subCategory) {
        this.subCategory = subCategory;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }
}
