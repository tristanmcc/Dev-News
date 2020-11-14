package DevNews.Topics;

import DevNews.Articles.Article;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "topicList")
    private List<Article> articleList;

    public Topic(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Topic() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
