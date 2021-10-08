public class DtoNewsItem {
    public int id;
    public String title;
    public String category;
    public String text;
    public String author;

    public DtoNewsItem(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.category = news.getCategory();
        this.text = news.getText();
        this.author = news.getAuthor();
    }
}
