package com.example.mahanthesh.s_kart;

public class ProductDetailObjects {

    private String product_model;
    private String product_brand;
    private String product_category;
    private String available_colors;

    private String store_name;
    private String store_img_url;
    private String product_Dname;
    private String store_price;
    private String store_url;

    public String getStore_url() {
        return store_url;
    }

    public void setStore_url(String store_url) {
        this.store_url = store_url;
    }

    public String getProduct_brand() {
        return product_brand;
    }

    public String getProduct_category() {
        return product_category;
    }

    public String getAvailable_colors() {
        return available_colors;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getStore_img_url() {
        return store_img_url;
    }

    public String getProduct_Dname() {
        return product_Dname;
    }

    public String getStore_price() {
        return store_price;
    }

    public String getProduct_model() {
        return product_model;
    }

    public void setProduct_model(String product_model) {
        this.product_model = product_model;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public void setAvailable_colors(String available_colors) {
        this.available_colors = available_colors;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public void setStore_img_url(String store_img_url) {
        this.store_img_url = store_img_url;
    }

    public void setProduct_Dname(String product_Dname) {
        this.product_Dname = product_Dname;
    }

    public void setStore_price(String store_price) {
        this.store_price = store_price;
    }


    public ProductDetailObjects() {

    }


    public ProductDetailObjects(String store_name, String store_img_url, String store_price, String store_url) {
        this.store_name = store_name;
        this.store_img_url = store_img_url;
        this.store_price = store_price;
        this.store_url = store_url;
    }
}

