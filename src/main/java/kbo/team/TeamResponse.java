package kbo.team;

public record TeamResponse(Long id, String name, String city, Integer foundedYear) {
    public static TeamResponse from(Team team) {
        return new TeamResponse(
                team.getId(), team.getName(), team.getCity(), team.getFoundedYear());


    }
}
