package thuannd.com.candycoded;

import java.io.Serializable;

/**
 * Created by nguye on 5/28/2018.
 */

public class Candy implements Serializable {
    private int id;
    private String name;
    private String image;
    private String price;
    private String description;

    public Candy() {

    }

    public Candy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
