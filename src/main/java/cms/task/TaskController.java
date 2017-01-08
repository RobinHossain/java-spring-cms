package cms.task;

import org.springframework.beans.factory.annotation.Autowired;
import cms.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
class TaskController {

	private final TaskRepository tasks;

	@Autowired
	public TaskController(TaskRepository taskrepo){
		this.tasks = taskrepo;
	}

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

	@RequestMapping(value = "/tasks/new", method = RequestMethod.GET)
	public String initTaskCreationForm(Map<String, Object> model){
		Task task = new Task();
		model.put("cms/task", task);
		return "tasks/createTaskFormGet";
	}



	@RequestMapping(value = "/tasks/new", method = RequestMethod.POST)
	public String processTaskCreationForm(@Valid Task task, BindingResult result){
		if(result.hasErrors()){
			return "tasks/createTaskFormGet";
		} else{
			this.tasks.save(task);
			return "redirect:/tasks/" + task.getId();
		}
	}

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String processFindForm(Task task, BindingResult result, Map<String, Object> model) {

        // allow parameterless GET request for /owners to return all records
        if (task.getName() == null) {
            task.setName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        Collection<Task> results = this.tasks.findByFirstName(task.getName());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("name", "notFound", "not found");
            return "tasks/findTasks";
        } else if (results.size() == 1) {
            // 1 owner found
            task = results.iterator().next();
            return "redirect:/tasks/" + task.getId();
        } else {
            // multiple owners found
            model.put("tasks", results);
            return "tasks/taskList";
        }
    }



}
