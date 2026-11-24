package kbo.player;

import kbo.team.Team;
import kbo.team.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor

public class PlayerController {

    private final PlayerRepository playerRepository;

    @GetMapping
    public List<PlayerResponse> getPlayers(@RequestParam(required = false) Long teamId) {
        List<Player> players;

        if (teamId != null) {
            players = playerRepository.findByTeamId(teamId);
        } else {
            players = playerRepository.findAll();
        }
        return players.stream()
                .map(PlayerResponse::from)
                .toList();
        }

    @GetMapping("/{id}")
    public PlayerResponse getPlayer(@PathVariable Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "구단을 찾을 수 없습니다."));
        return PlayerResponse.from(player);
    }
}
