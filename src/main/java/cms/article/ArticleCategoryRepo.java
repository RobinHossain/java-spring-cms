package cms.article;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ArticleCategoryRepo extends Repository<ArticleCategory, Integer> {

    @Query("SELECT DISTINCT acategory FROM ArticleCategory acategory WHERE acategory.name LIKE :name%")
    @Transactional(readOnly = true)
    Collection<ArticleCategory> findArticleCategories(@Param("name") String name);

    void save(ArticleCategory acategory);
}
