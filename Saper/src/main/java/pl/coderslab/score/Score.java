package pl.coderslab.score;



import javax.persistence.*;
import java.sql.Time;


@Entity
@Table(name = "usersScore")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nickName;

    private int time;

    public String dificulty;

    public Score(String nickName, int time, String dificulty) {
        this.nickName = nickName;
        this.time = time;
        this.dificulty = dificulty;
    }


    public Score(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
