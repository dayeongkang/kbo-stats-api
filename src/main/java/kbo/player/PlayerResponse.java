package kbo.player;
import java.time.LocalDate;

public record PlayerResponse(
        Long id,
        String name,
        String position,
        LocalDate birthDate,
        Integer backNumber,
        String teamName
) {

    public static PlayerResponse from(Player player) {
        String teamName = player.getName() != null ? player.getTeam().getName() : null;

        return new PlayerResponse(
               player.getId(),
                 player.getName(),
                 player.getPosition(),
                 player.getBirthDate(),
                 player.getBackNumber(),
                 teamName
        );
    }
}
