package cms.task;

import cms.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Task Table
 *
 */

@Entity
@Table(name = "tasks")

public class Task extends BaseEntity {
	@Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "details")
    @NotEmpty
    private String details;

    @Column(name = "date")
    @NotEmpty
    private String date;

    public String getName(){
    	return this.name;
    }

    public String getDetails(){
    	return this.details;
    }

    public String getDate(){
    	return this.date;
    }

    public void setName(String name){
    	this.name = name;
    }

    public void setDetails(String details){
    	this.name = details;
    }

    public void setDate(String date){
    	this.name = date;
    }
}
