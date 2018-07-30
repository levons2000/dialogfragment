package com.example.student.lionmarket.models;

public class GameModel {
    private String[] imgUrl;
    private String name;
    private String price;
    private int desc;
    private String type;
    private String videoLink;
    private String creator;
    private float raiting;
    public boolean isLiked = false;
    public boolean isInBin = false;
    private String imageForVideo;

    public GameModel(String[] imgUrl, String name, String price, int desc, String type, String videoLink, String creator, int raiting, String imageForVideo) {
        this.name = name;
        this.price = price + "$";
        this.desc = desc;
        this.type = type;
        this.raiting = raiting;
        this.imgUrl = imgUrl;
        this.creator = creator;
        this.videoLink = videoLink;
        this.imageForVideo = imageForVideo;
    }

    public String[] getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String[] imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getRaiting() {
        return raiting;
    }

    public void setRaiting(float raiting) {
        this.raiting = raiting;
    }

    public GameModel(String creator) {
        this.creator = creator;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getImageForVideo() {
        return imageForVideo;
    }

    public void setImageForVideo(String imageForVideo) {
        this.imageForVideo = imageForVideo;
    }
}
