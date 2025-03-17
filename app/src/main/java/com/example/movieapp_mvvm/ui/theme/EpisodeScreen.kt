// File: EpisodesScreen.kt
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.offline.Download

//import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@JvmOverloads
@Composable
fun EpisodesScreen(viewModel: EpisodeViewModel = viewModel()) {
    val episodes by viewModel.episodes.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EPISODES") },
                actions = {
                    IconButton(onClick = { /* Handle search */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Handle profile */ }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { /* Handle home click */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Add, contentDescription = "Watchlist") },
                    label = { Text("Watchlist") },
                    selected = false,
                    onClick = { /* Handle watchlist click */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Movie, contentDescription = "Movies") },
                    label = { Text("Movies") },
                    selected = true,
                    onClick = { /* Handle movies click */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Download, contentDescription = "Downloads") },
                    label = { Text("Downloads") },
                    selected = false,
                    onClick = { /* Handle downloads click */ }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Title of Series", style = MaterialTheme.typography.titleLarge)

            episodes.forEachIndexed { index, episode ->
                EpisodeItem(
                    episode = episode,
                    onDownloadClick = { /* Handle download click */ }
                )
                if (index < episodes.size - 1) {
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

// File: EpisodesScreen.kt
@Composable
fun EpisodeItem(episode: Episode, onDownloadClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
        ) {
            Text(
                text = "Movie",
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "1. ${episode.title}", style = MaterialTheme.typography.bodyLarge)
            Text(text = episode.duration, style = MaterialTheme.typography.bodyMedium)
            Text(text = episode.description, style = MaterialTheme.typography.bodySmall)
        }
        IconButton(onClick = onDownloadClick) {
            Icon(Icons.Default.Download, contentDescription = "Download")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEpisodeItem() {
    val episode = Episode(
        title = "Sample Episode",
        duration = "50m",
        description = "This is a sample episode description."
    )
    EpisodeItem(
        episode = episode,
        onDownloadClick = { /* Handle download click */ }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewEpisodesScreen() {
    // Buat ViewModel dengan data dummy untuk preview
    val viewModel = EpisodeViewModel()
    EpisodesScreen(viewModel)
}