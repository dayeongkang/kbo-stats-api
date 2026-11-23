package kbo.team;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String city;

    private Integer foundedYear;

    public Team(String name, String city, Integer foundedYear) {
        this.name = name;
        this.city = city;
        this.foundedYear = foundedYear;
    }
}
