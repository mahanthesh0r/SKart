package com.example.mahanthesh.s_kart;

public class ProductList {

    private String pname;
    private String img_url;
    private String price;
    private float rating;
    private String pid;

    public String getPname() {
        return pname;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getPrice(){ return price; }

    public float getRating() { return rating; }

    public String getPid() { return pid; }

    public ProductList(String pname, String img_url, String price, float rating, String pid) {
        this.pname = pname;
        this.img_url = img_url;
        this.price = price;
        this.rating = rating;
        this.pid = pid;
    }
}
