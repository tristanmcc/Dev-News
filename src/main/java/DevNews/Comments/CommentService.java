package DevNews.Comments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepo repo;

    public CommentService(){}

    //get list all articles
    public List<Comment> getAll(){
        return repo.findAll();
    }

    public Optional<Comment> getById(Long id){
        return repo.findById(id);
    }

    public Comment create(Comment article) {
        return repo.save(article);
    }

    public Comment update(Comment updatedArticle){
        return repo.save(updatedArticle);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Comment> getAllByArticleId(Long articleId) {
        return repo.findAllByArticleId(articleId);
    }
}
