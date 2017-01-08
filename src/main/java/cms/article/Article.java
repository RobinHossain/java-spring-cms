package cms.article;


import cms.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "articles")

public class Article extends BaseEntity {

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "details")
    @NotEmpty
    private String details;

    @Column(name = "status")
    @NotEmpty
    private String status;

    @Column(name = "created_at")
    @NotEmpty
    private String created_at;

    @Column(name = "modified_at")
    @NotEmpty
    private String modified_at;

    public String getTitle(){
        return this.title;
    }

    public void setTitle( String title ){
        this.title = title;
    }

    public String getDetails(){
        return this.details;
    }

    public void setDetails( String details ){
        this.title = details;
    }


}
