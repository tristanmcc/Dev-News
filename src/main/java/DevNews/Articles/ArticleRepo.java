package DevNews.Articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {
    List<Article> findAllByTopicList_id(Long topicId);
}
