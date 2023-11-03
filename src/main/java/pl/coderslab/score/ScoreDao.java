package pl.coderslab.score;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ScoreDao {

    @PersistenceContext
    EntityManager  entityManager;

    public void saveScore(Score score) {
        entityManager.persist(score);
    }

    public List<Score> bestTenEasyScore() {
        TypedQuery<Score> query = entityManager.createQuery("SELECT s FROM Score s WHERE dificulty = 'easy' ORDER BY s.time ASC ", Score.class);
        List<Score> scoreList = query.getResultList();
        return scoreList;
    }

    public List<Score> bestTenNormalScore() {
        TypedQuery<Score> query = entityManager.createQuery("SELECT s FROM Score s WHERE dificulty = 'normal' ORDER BY s.time ASC ", Score.class);
        List<Score> scoreList = query.getResultList();
        return scoreList;
    }

    public List<Score> bestTenHardScore() {
        TypedQuery<Score> query = entityManager.createQuery("SELECT s FROM Score s WHERE dificulty = 'hard' ORDER BY s.time ASC ", Score.class);
        List<Score> scoreList = query.getResultList();
        return scoreList;
    }

}
