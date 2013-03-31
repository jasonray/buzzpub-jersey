package jayray.net.buzzpub;

import com.mongodb.DB;
import com.mongodb.Mongo;

import java.net.UnknownHostException;

public class DatabaseConnectionHelper {
    public static DB getConnection() {
        Mongo m;
        try {
            m = new Mongo();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return m.getDB("blog");
    }

    public static void releaseConnection(DB db) {
        db.getMongo().close();
    }

}
