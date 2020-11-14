package DevNews.Topics;

import DevNews.Comments.Comment;
import DevNews.Comments.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    //get list all topics
    @GetMapping("")
    public List<Topic> getAll(){
            return topicService.getAll();
    }

    //get specific task by ID
    @GetMapping("/{id}")
    public Topic getById(@PathVariable Long id){
        return topicService.getById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //create article
    @PostMapping("")
    public Topic create(@RequestBody Topic newTopic){
        return topicService.create(newTopic);
    }

    //Update article
    @PutMapping("")
    public Topic update(@RequestBody Topic updatedTopic){
        return topicService.update(updatedTopic);
    }

    //Delete task
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
       topicService.delete(id);
    }
}

