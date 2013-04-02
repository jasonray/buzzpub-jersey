package jayray.net.buzzpub;

import com.sun.jersey.api.NotFoundException;
import jayray.net.buzzpub.domain.Article;
import jayray.net.buzzpub.domain.Articles;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Articles getCurrentArticles() {
        logger.debug("get current articles");

        BuzzpubResourceDao dao = new BuzzpubResourceDao();
        Articles articles = dao.fetchArticles(10);

        logger.debug(String.format("found %s articles", articles.size()));
        return articles;
    }

    @GET
    @Path("id/{permalink}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Article getArticle(@PathParam("id") String permalink) {
        logger.debug("get single article " + permalink);

        BuzzpubResourceDao dao = new BuzzpubResourceDao();
        Article article = dao.fetchArticle(permalink);

        if (article == null) throw new NotFoundException();

        logger.debug("found article");
        return article;
    }

    @Path("sample")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Article getSampleArticle() {
        logger.debug("get sample articles");

        BuzzpubResourceDao dao = new BuzzpubResourceDao();
        Articles articles = dao.fetchArticles(1);

        Article article = articles.get(0);

        return article;
    }


}
