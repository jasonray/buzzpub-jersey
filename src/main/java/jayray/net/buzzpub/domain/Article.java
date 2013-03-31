package jayray.net.buzzpub.domain;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jasonray
 * Date: 3/31/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */

//post = post.append("author", username);
//post.append("title", title);
//post.append("body", body);
//post.append("permalink", permalink);
//post.append("tags", tags);
//post.append("comments", new ArrayList());
//post.append("date", new Date());


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Article {

    @XmlElement
    private String title;
    @XmlElement
    private String body;
    @XmlElement
    private String permalink;
    //    private List<String> tags;
    @XmlElement
    private Date date;

    public Article() {
//        tags = new ArrayList<String>();
    }

    public Article(String title, String body, String permalink, List<String> tags, Date date) {
        this.title = title;
        this.body = body;
        this.permalink = permalink;
//        this.tags = tags;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

//    public List<String> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<String> tags) {
//        this.tags = tags;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
