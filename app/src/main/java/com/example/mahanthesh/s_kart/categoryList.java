package com.example.mahanthesh.s_kart;

public class categoryList {

    private String img_url;
    private String product_name;
    private String price;

    public String getImg_url() {
        return img_url;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getPrice() {
        return price;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public categoryList(String img_url, String product_name, String price) {
        this.img_url = img_url;
        this.product_name = product_name;
        this.price = price;
    }
}
