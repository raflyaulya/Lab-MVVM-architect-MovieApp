// File: EpisodeRepository.kt
class EpisodeRepository {
    // Data dummy untuk simulasi
    private val episodes = listOf(
        Episode("Episode 1", "50m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode 2", "50m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode 3", "50m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode 4", "50m", "Lorem ipsum dolor sit amet...")
    )

    fun getEpisodes(): List<Episode> {
        return episodes
    }
}