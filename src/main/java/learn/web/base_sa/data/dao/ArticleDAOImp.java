//package learn.web.base_sa.data.dao;
//
//import learn.web.base_sa.data.base.RedisBase;
//import learn.web.base_sa.data.po.Article;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.stereotype.Component;
//
///**
// * Created by Vigo on 17/2/23.
// */
//@Component("articleDaoImp")
//public class ArticleDAOImp extends RedisBase<String, Article> implements ArticleDao{
//
//
//    public boolean addArticle(final Article article) {
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            public Boolean doInRedis(RedisConnection connection)
//                    throws DataAccessException {
//                RedisSerializer<String> serializer = getRedisSerializer();
//                byte[] key = serializer.serialize("uid:1");
//                byte[] field  = serializer.serialize(article.getId());
//                byte[] value = serializer.serialize(article.getName() + ", " + article.getType());
//                return connection.hSetNX(key, field, value);
//            }
//        });
//        return result;
//    }
//
//    public String getArticle(final String field){
//        String result = redisTemplate.execute(new RedisCallback<String>() {
//            public String doInRedis(RedisConnection connection)
//                    throws DataAccessException {
//                RedisSerializer<String> serializer = getRedisSerializer();
//                byte[] key = serializer.serialize("uid:1");
//                byte[] f = serializer.serialize(field);
//                byte[] value = connection.hGet(key, f);
//                if (value == null) {
//                    return null;
//                }
//                String content = serializer.deserialize(value);
//                return content;
//            }
//        });
//        return result;
//    }
//
//    public static void main(String[] args) {
//        ArticleDAOImp articleDAOImp = new ArticleDAOImp();
//        System.out.println(articleDAOImp.addArticle(new Article("1", "java", "science")));
//    }
//}
