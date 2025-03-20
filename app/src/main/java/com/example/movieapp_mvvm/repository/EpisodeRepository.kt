// File: EpisodeRepository.kt
class EpisodeRepository {
    // Data dummy untuk simulasi
    private val episodes = listOf(
        Episode("Episode: Spiderman", "60m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Iron man", "35m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Hulk", "40m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Captain America", "55m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Black Panther", "50m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Thor", "45m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Spiderman 2", "70m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Iron man 2", "45m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Hulk 2", "50m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Spiderman 3", "80m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Iron man 3", "65m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Hulk 3", "60m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Spiderman 4", "30m", "Lorem ipsum dolor sit amet..."),
        Episode("Episode: Iron man 4", "25m", "Lorem ipsum dolor sit amet..."),
//        Episode("Episode: Hulk 4", "60m", "Lorem ipsum dolor sit amet..."),

        )

    fun getEpisodes(): List<Episode> {
        return episodes
    }
}