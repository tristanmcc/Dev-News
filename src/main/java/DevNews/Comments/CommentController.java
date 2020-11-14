package DevNews.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //get list all tasks
    @GetMapping("")
    public List<Comment> getAll(
            @RequestParam(required = false) Long articleId){
        if (articleId== null){
            return commentService.getAll();
        } else{
            return commentService.getAllByArticleId(articleId);
        }
    }

    //get specific task by ID
    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id){
        return commentService.getById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //create article
    @PostMapping("")
    public Comment create(@RequestBody Comment newComment){
        return commentService.create(newComment);
    }

    //Update article
    @PutMapping("")
    public Comment update(@RequestBody Comment updatedComment){
        return commentService.update(updatedComment);
    }

    //Delete task
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}
