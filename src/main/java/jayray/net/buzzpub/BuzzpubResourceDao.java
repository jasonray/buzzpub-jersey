package jayray.net.buzzpub;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;
import jayray.net.buzzpub.domain.Article;
import jayray.net.buzzpub.domain.Articles;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jasonray
 * Date: 3/31/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuzzpubResourceDao {
    private static final Logger logger = Logger.getLogger(BuzzpubResourceDao.class);
    private static DB articleDatabase = DatabaseConnectionHelper.getConnection();
    private static DBCollection postsCollection = articleDatabase.getCollection("posts");

    public Articles fetchArticles(int limit) {
        logger.debug("fetch articles, limit = " + limit);

        Articles articles = null;
        try {
            articleDatabase.requestStart();
            articleDatabase.requestEnsureConnection();

            DBObject sort = new BasicDBObject("date", -1);
            DBCursor cursor = postsCollection.find(new BasicDBObject(), new BasicDBObject("title", 1).append("permalink", 1).append("body", 1).append("tags", 1).append("_id", 0)).sort(sort).limit(limit);


            logger.debug("convert json to articles");
            articles = new Articles();
            Gson gson = new Gson();
            while (cursor.hasNext()) {
                String json = JSON.serialize(cursor.curr());
                Article article = gson.fromJson(json, Article.class);
                articles.add(article);
                cursor.next();
            }
        } finally {
            articleDatabase.requestDone();
        }

        return articles;
    }


}
