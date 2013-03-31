package jayray.net.buzzpub.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: jasonray
 * Date: 3/31/13
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Articles extends ArrayList<Article> {

    @XmlElement          (name = "article")
    public Articles getArticles() {
        return this;
    }
}
