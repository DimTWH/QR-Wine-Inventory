package com.QRwineinventory.qrWineInventory.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
@Entity
@Table(name = "wines")
public class Wine implements Serializable {
    @Id
    @Column(unique = true)
    private UUID uid;
    @Column(nullable = false)
    @NotBlank
    private String brand_grape;
    @NotBlank
    private String winery;
    @NotBlank
    private String vintage;
    @NotBlank
    private String color;
    @NotBlank
    private String type;
    private String image_pp;

    @Column(nullable = false, length = 10)
    @NotBlank
    private double price;
    @NotBlank
    private double alcohol;
    @NotBlank
    private int quantity;


    public Wine(@JsonProperty("uid") UUID uid,
                @JsonProperty("brandGrape") String brand_grape,
                @JsonProperty("winery") String winery,
                @JsonProperty("vintage") String vintage,
                @JsonProperty("price") double price,
                @JsonProperty("color") String color,
                @JsonProperty("type") String type,
                @JsonProperty("alcohol") double alcohol,
                @JsonProperty("quantity") int quantity,
                @JsonProperty("image_pp") String image_pp) {
        this.uid = uid;
        this.brand_grape = brand_grape;
        this.winery = winery;
        this.vintage = vintage;
        this.price = price;
        this.color = color;
        this.type = type;
        this.alcohol = alcohol;
        this.quantity = quantity;
        this.image_pp = image_pp;
    }

    public Wine() {}

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getBrand_grape() {
        return brand_grape;
    }

    public void setBrand_grape(String brandGrape) {
        this.brand_grape = brandGrape;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage_pp() {
        return image_pp;
    }

    public void setImage_pp(String image_pp) {
        this.image_pp = image_pp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wine wine = (Wine) o;
        return uid.equals(wine.uid);
    }
    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
