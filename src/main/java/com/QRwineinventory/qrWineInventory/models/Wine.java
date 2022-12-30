package com.QRwineinventory.qrWineInventory.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.UUID;
@Entity
@Table(name = "wines")
public class Wine implements Serializable {

    @GeneratedValue
    private int id;
    @Id
    @Column(unique = true)
    private UUID uid;
    @Column(nullable = false)
    @NotBlank
    private String brandGrape;
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
    private float price;
    @NotBlank
    private float alcohol;
    @NotBlank
    private int quantity;


    public Wine(@JsonProperty("id") int id,
                @JsonProperty("uid") UUID uid,
                @JsonProperty("brandGrape") String brandGrape,
                @JsonProperty("winery") String winery,
                @JsonProperty("vintage") String vintage,
                @JsonProperty("price") float price,
                @JsonProperty("color") String color,
                @JsonProperty("type") String type,
                @JsonProperty("alcohol") float alcohol,
                @JsonProperty("quantity") int quantity,
                @JsonProperty("image_pp") String image_pp) {
        this.id = id;
        this.uid = uid;
        this.brandGrape = brandGrape;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getBrandGrape() {
        return brandGrape;
    }

    public void setBrandGrape(String brandGrape) {
        this.brandGrape = brandGrape;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
