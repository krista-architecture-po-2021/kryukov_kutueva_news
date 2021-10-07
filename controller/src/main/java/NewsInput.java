public class NewsInput implements INewsInput {
    private String title;
    private String category;
    private String text;
    private String author;

    public NewsInput(String title, String category, String text, String author) {
        this.title = title;
        this.category = category;
        this.text = text;
        this.author = author;
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
    @Override
    public String getAuthor() {
        return author;
    }
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
}
