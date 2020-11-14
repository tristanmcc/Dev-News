package DevNews.Articles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/articles")
class ArticleController {

@Autowired
private ArticleService articleService;

    //get list all tasks
    @GetMapping("")
    public List<Article> getAll(@RequestParam (required = false) Long topicId){
    if(topicId != null){
        return articleService.getAllByTopicId(topicId);
    }
       else{ return articleService.getAll();}
}

    //get specific task by ID
    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id){
        return articleService.getById(id)
                    .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
       }


    //create article
    @PostMapping("")
    public Article create(@RequestBody Article newArticle){
        return articleService.create(newArticle);
       }

   //Update article
    @PutMapping("")
    public Article update(@RequestBody Article updatedArticle){
        return articleService.update(updatedArticle);
    }

   //Delete task
   @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
   }
}
