package kbo.player;

import jakarta.persistence.*;
import kbo.team.Team;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String position;

    private LocalDate birthDate;

    private Integer backNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(String name, String position, LocalDate birthDate, Integer backNumber, Team team) {
        this.name = name;
        this.position = position;
        this.birthDate = birthDate;
        this.backNumber = backNumber;
        this.team = team;
    }
}