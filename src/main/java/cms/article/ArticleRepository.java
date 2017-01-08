package cms.article;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ArticleRepository extends Repository<Article, Integer> {

    @Query("SELECT DISTINCT article FROM Article article WHERE article.title LIKE :title%")
    @Transactional(readOnly = true)
    Collection<Article> findByTitle(@Param("title") String title);
}
