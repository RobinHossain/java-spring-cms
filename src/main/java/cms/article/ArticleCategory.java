package cms.article;

import cms.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "article_categories")

public class ArticleCategory extends BaseEntity{

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "details")
    private String details;

    @Column(name = "status")
    private String status;

    public String getName(){
        return this.name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public String getDetails(){
        return this.details;
    }

    public void setDetails( String details ){
        this.details = details;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus( String status ){
        this.status = status;
    }
}
