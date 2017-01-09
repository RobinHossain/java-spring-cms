package cms.article;



import cms.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
class ArticleController {

    private final ArticleRepository articles;

    private final ArticleCategoryRepo acategory;


    @Autowired
    public ArticleController(ArticleRepository articlerepo, ArticleCategoryRepo acategoryrepo ){
        this.articles = articlerepo;
        this.acategory = acategoryrepo;
    }


    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public String findArticle (Article article, BindingResult result, Map<String, Object> model){

        if(article.getTitle() == null){
            article.setTitle("");
        }

        Collection<Article> results = this.articles.findByTitle(article.getTitle());
        if(results.isEmpty()){
            result.rejectValue("title", "notFound", "not found");
            return "articles/notFound";
        }else if ( results.size() == 1 ){
            article = results.iterator().next();
            return "redirect:/articles/articleList";
        }else {
            model.put("articles", results);
            return "articles/articleList";
        }
    }

    @RequestMapping(value = "article/categories", method = RequestMethod.GET)
    public String findArticleCategory(ArticleCategory acategory, BindingResult result, Map<String, Object> model){
        if(acategory.getName() == null){
            acategory.setName("");
        }

        Collection<ArticleCategory> categoryResult = this.acategory.findArticleCategories(acategory.getName());
        if(categoryResult.isEmpty()){
            result.rejectValue("name", "notFound", "not found");
            return "articles/category/notFound";
        }else {
            model.put("articleCategories", categoryResult);
            return "articles/category/list";
        }
    }

    @RequestMapping(value = "article/category/add", method = RequestMethod.GET)
    public String categoryCreationForm(Map<String, Object> model){
        ArticleCategory acategory = new ArticleCategory();
        model.put("category", acategory);
        return "articles/category/add";
    }

    @RequestMapping(value = "article/category/add", method = RequestMethod.POST)
    public String categoryFormSubmit(@Valid ArticleCategory acategory, BindingResult result){
        if(result.hasErrors()){
            return "articles/category/add";
        } else {
            this.acategory.save(acategory);
            return "redirect:/article/categories";
        }
    }

    @RequestMapping(value = "article/add", method = RequestMethod.GET)
    public String articleCreateForm(Map<String, Object> model){
        Article article = new Article();
        model.put("article", article);
        return "articles/add";
    }

    @RequestMapping(value = "article/add", method = RequestMethod.POST)
    public String articleFormSubmit(@Valid Article article, BindingResult result){
        if(result.hasErrors()){
            return "article/add";
        } else {
            this.articles.save(article);
            return "redirect:/articles";
        }
    }


}
