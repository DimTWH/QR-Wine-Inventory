package com.QRwineinventory.qrWineInventory.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
public class Wine {
    private final UUID id;
    private final String name;
    private final String vintage;
    private final float price;
    private final String color;
    private final String type;
    private final float alcohol;
    private final int quantity;
    private final String image_pp;

    public Wine(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("vintage") String vintage,
                @JsonProperty("price") float price,
                @JsonProperty("color") String color,
                @JsonProperty("type") String type,
                @JsonProperty("alcohol") float alcohol,
                @JsonProperty("quantity") int quantity,
                @JsonProperty("image_pp") String image_pp) {
        this.id = id;
        this.name = name;
        this.vintage = vintage;
        this.price = price;
        this.color = color;
        this.type = type;
        this.alcohol = alcohol;
        this.quantity = quantity;
        this.image_pp = image_pp;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVintage() {
        return vintage;
    }

    public float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage_pp() {
        return image_pp;
    }
}
