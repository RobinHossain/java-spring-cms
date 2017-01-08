package cms.article;



import cms.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

@Controller
class ArticleController {

    private final ArticleRepository articles;

    @Autowired
    public ArticleController(ArticleRepository articlerepo ){
        this.articles = articlerepo;
    }

    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public String findArticle (Article article, BindingResult result, Map<String, Object> model){

        if(article.getTitle() == null){
            article.setTitle("");
        }

        Collection<Article> results = this.articles.findByTitle(article.getTitle());
        if(results.isEmpty()){
            result.rejectValue("title", "notFound", "not found");
            return "articles/findArticles";
        }else if ( results.size() == 1 ){
            article = results.iterator().next();
            return "redirect:/articles/"+article.getId();
        }else {
            model.put("articles", results);
            return "articles/articleList";
        }
    }

}
