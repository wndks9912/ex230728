package vo;
public class BookVO {
    private int idx;
    private String name;
    private String title;
    private int price;

    public BookVO() { }

    public BookVO(int idx, String name, String title, int price) {
        this.idx = idx;
        this.name = name;
        this.title = title;
        this.price = price;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookVO [idx=" + idx + ", name=" + name + ", title=" + title + ", price=" + price + "]";
    }
}
