package DevNews.Articles;


import DevNews.Comments.Comment;
import DevNews.Topics.Topic;

import javax.persistence.*;
import java.util.List;


@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String authorName;

    @OneToMany
    private List<Comment> comments;

    @ManyToMany
    private List<Topic> topicList;


    //DefaultConstructor
    public Article(){
    }

    //Constructor
    public Article(Long id, String title, String body, String authorName){
        this.title = title;
        this.body = body;
        this.id = id;
        this.authorName = authorName;
}
    //Getters
    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getBody() {
        return body;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}

