package monk.zyli.store.auth.model;

/**
 * @author lizy
 * @date 2018/07/11
 */
public class Product {

    /**
     * 所属店铺id
     */
    private String storeId;

    /**
     * 商品名称
     */
    private String name;


    /**
     * 商品名称
     */
    private String description;

    /**
     * 图片url
     */
    private String[] imageUrls;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }
}
