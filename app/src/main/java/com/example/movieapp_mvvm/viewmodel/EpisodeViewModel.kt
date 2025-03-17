// File: EpisodeViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodeViewModel : ViewModel() {
    private val repository = EpisodeRepository()
    private val repository = EpisodeRepository()

    // State untuk daftar episode
    private val _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> = _episodes

    init {
        loadEpisodes()
    }

    private fun loadEpisodes() {
        viewModelScope.launch {
            _episodes.value = repository.getEpisodes()
        }
    }
}