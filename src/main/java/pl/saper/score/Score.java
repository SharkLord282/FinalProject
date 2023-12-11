package pl.saper.score;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usersScore")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nickName;
    private int time;
    public String difficulty;

    public Score(String nickName, int time, String difficulty) {
        this.nickName = nickName;
        this.time = time;
        this.difficulty = difficulty;
    }
}
