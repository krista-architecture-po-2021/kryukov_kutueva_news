import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.Calendar;
import java.util.Date;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/reader")
public class Reader {
    NewsService newsService;

    @GET
    @Path("/")
    @Produces("text/plain")
    public String getSimpleText() {
        return "Привет, читатель!";
    }
    @GET
    @Path("/newslist")
    @Produces(APPLICATION_JSON)
    public Response getAllNews() {
        newsService = new NewsService(null, null, null);
        return Response.ok(newsService.getNewsList()).build();
    }

    @GET
    @Path("/newsitem/{id}")
    @Produces(APPLICATION_JSON)
    public Response getNewsItem(@PathParam("id") int id) {
        newsService = new NewsService(null, null, null);
        return Response.ok(newsService.getNews(id)).build();
    }

    @GET
    @Path("/categorieslist")
    @Produces(APPLICATION_JSON)
    public Response getAllCategories() {
        newsService = new NewsService(null, null, null);
        return Response.ok(newsService.getCategoriesList()).build();
    }

    @GET
    @Path("/newslist/recent")
    @Produces(APPLICATION_JSON)
    public Response getRecentNewsList() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();
        newsService = new NewsService(null, null, yesterday);
        return Response.ok(newsService.getNewsList()).build();
    }

}
