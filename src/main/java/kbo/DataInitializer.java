package kbo;


import kbo.player.Player;
import kbo.player.PlayerRepository;
import kbo.team.Team;
import kbo.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Override
    public void run(String... args) {
        if (teamRepository.count() > 0) {
            return;
        }
        Team lg = teamRepository.save(new Team("LG 트윈스", "서울", 1982));
        Team kia = teamRepository.save(new Team("KIA 타이거즈", "광주", 1982));

        playerRepository.save(new Player("홍길동", "투수",LocalDate.of(1995, 3, 1), 11, lg));
        playerRepository.save(new Player("김철수", "타자",LocalDate.of(1998, 7, 15), 7, lg));
        playerRepository.save(new Player("이영희", "포수",LocalDate.of(1997, 5, 20), 22, kia));

    }
}
