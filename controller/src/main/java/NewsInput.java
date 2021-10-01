public class NewsInput implements INewsInput {
    private String title;
    private String category;
    private String text;

    public NewsInput(String title, String category, String text) {
        this.title = title;
        this.category = category;
        this.text = text;
    }

    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String getCategory() {
        return category;
    }
    @Override
    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String getText() {
        return text;
    }
    @Override
    public void setText(String text) {
        this.text = text;
    }
}
