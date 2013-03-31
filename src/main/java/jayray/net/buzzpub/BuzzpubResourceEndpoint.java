package jayray.net.buzzpub;

import jayray.net.buzzpub.domain.Article;
import jayray.net.buzzpub.domain.Articles;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jasonray
 * Date: 3/31/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("articles")
public class BuzzpubResourceEndpoint {
    private static final Logger logger = Logger.getLogger(BuzzpubResourceEndpoint.class);

    @GET
    @Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Articles getCurrentArticles() {
        logger.debug("get current articles");
        Articles articles = getArticles();
        logger.debug(String.format("found %s articles", articles.size()));
        return articles;
    }
    
    @Path("sample")
    @GET
    @Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Article getSampleArticle() {
        logger.debug("get sample articles");
        Article article = getArticles().get(0);
        return article;
    }

    private Articles getArticles() {
        Articles articles = new Articles();

        List<String> tags = new ArrayList<String>();
        tags.add("t1");
        Article article = new Article("My first article", "this is the body of the first article", "firstarticle", tags, new Date());
        articles.add(article);

        tags = new ArrayList<String>();
        tags.add("t2");
        article = new Article("My second article", "this is the body of the second article", "secondarticle", tags, new Date());
        articles.add(article);

        return articles;
    }

}
