package doremi.repositories;

import doremi.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepositoryWithJdbc implements ArticleRepositoryInt {

    @Autowired
    private DataSource dataSource;

    public List<Article> findAllArticles() {
        List<Article> articles = new ArrayList<>();
        ResultSet fetchedArticles;

        Connection connexion = null;
        try {
            connexion = dataSource.getConnection();
            Statement statement = connexion.createStatement();
            fetchedArticles = statement.executeQuery("SELECT * FROM articles");
            while(fetchedArticles.next()) {
                Article art = new Article();
                art.setArticleId(fetchedArticles.getInt("id"));
                art.setTitle(fetchedArticles.getString("title"));
                art.setCategory(fetchedArticles.getString("category"));
                articles.add(art);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connexion != null)
                    connexion.close();
            } catch(SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        return articles;
    }

    @Override
    public Article findArticleById(int id) {
        Article article = null;
        ResultSet fetchedArticles;

        Connection connexion = null;
        try {
            connexion = dataSource.getConnection();
            Statement statement = connexion.createStatement();
            fetchedArticles = statement.executeQuery("SELECT * FROM articles WHERE id = " + id);
            while(fetchedArticles.next()) {
                Article art = new Article();
                art.setArticleId(fetchedArticles.getInt("id"));
                art.setTitle(fetchedArticles.getString("title"));
                art.setCategory(fetchedArticles.getString("category"));
                article = art;
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connexion != null)
                    connexion.close();
            } catch(SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        return article;
    }

}