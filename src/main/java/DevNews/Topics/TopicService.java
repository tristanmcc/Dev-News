package DevNews.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TopicService {

    @Autowired
    private TopicRepo repo;

    //get list all articles
    public List<Topic> getAll(){
        return repo.findAll();
    }

    public Optional<Topic> getById(Long id){
        return repo.findById(id);
    }

    public Topic create(Topic article) {
        return repo.save(article);
    }

    public Topic update(Topic updatedArticle){
        return repo.save(updatedArticle);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    /*public List<Topic> getAllByArticleId(Long articleId) {
        return repo.findAllByArticleId(articleId);
    }*/
}