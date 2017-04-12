package learn.redis;

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by Vigo on 16/12/16.
 */
public class WebPage {

    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    private static final int VOTE_SCORE = 432;
    private static final int ARTICLES_PER_PAGE = 25;

    public Jedis conn;

    public WebPage(String host) {
            this.conn = new Jedis(host);
    }

    /**
     * 发布文章
     * @param user
     * @param title
     * @param link
     * @return
     */
    public String postArticle(String user, String title, String link) {
        String articleId = String.valueOf(conn.incr("article:"));
        String voted = "voted:" + articleId;
        conn.sadd(voted, user);
        // 设置过期时间
        conn.expire(voted, ONE_WEEK_IN_SECONDS);

        long now = System.currentTimeMillis() / 1000;
        String article = "article:" + articleId;
        HashMap<String,String> articleData = new HashMap<String,String>();
        articleData.put("title", title);
        articleData.put("link", link);
        articleData.put("user", user);
        articleData.put("now", String.valueOf(now));
        articleData.put("votes", "1");
        conn.hmset(article, articleData);
        conn.zadd("score:", now + VOTE_SCORE, article);
        conn.zadd("time:", now, article);
        return articleId;
    }

    public void articleVote(String user, String article) {
        long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
        if (conn.zscore("time:", article) < cutoff){
            return;
        }
        String articleId =  article.substring(article.indexOf(':') + 1);
        if (conn.sadd("voted:"  + articleId, user) == 1){// 用户第一次投
            conn.zincrby("score:", VOTE_SCORE, article);
            conn.hincrBy(article, "votes", 1);
        }
    }

    public static void main(String[] args) {
        WebPage page = new WebPage("172.22.147.3");
//        String articleId = page.postArticle("user_1", "A title", "www.cqupt.edu.cn");
//        System.out.println(articleId);
        page.articleVote("user_2", "article:1");
    }
}
