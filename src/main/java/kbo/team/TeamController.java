package kbo.team;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor

public class TeamController {
    private final TeamRepository teamRepository;

    @GetMapping
    public List<TeamResponse> getTeams() {
        return teamRepository.findAll().stream()
                .map(TeamResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public TeamResponse getTeam(@PathVariable Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "구단을 찾을 수 없습니다."));
        return TeamResponse.from(team);
    }
}
