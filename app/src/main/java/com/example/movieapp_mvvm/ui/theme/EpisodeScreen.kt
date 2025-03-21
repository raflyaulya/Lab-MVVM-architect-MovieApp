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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

// Import kelas Episode
//import com.example.movieapp_mvvm.Episode
//import com.example.movieapp_mvvm.EpisodeViewModel

@OptIn(ExperimentalMaterial3Api::class)
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
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { /* Handle home click */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Add, contentDescription = "Watchlist") },
                    label = { Text("Watchlist") },
                    selected = false,
                    onClick = { /* Handle watchlist click */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Apps, contentDescription = "Movies") },
                    label = { Text("Movies") },
                    selected = true,
                    onClick = { /* Handle movies click */ }
                )
                NavigationBarItem(
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
            Text("Marvel", style = MaterialTheme.typography.titleLarge)

            // Gunakan LazyColumn untuk menampilkan daftar episode
            LazyColumn {
                items(episodes) { episode ->
                    EpisodeItem(
                        episode = episode,
                        onDownloadClick = { /* Handle download click */ }
                    )
                    this@LazyColumn.item {
                        Divider(modifier = Modifier.padding(vertical = 8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun EpisodeItem(episode: Episode, onDownloadClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(125.dp, 80.dp)
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)),
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
            Text(text = "${episode.title} ", style = MaterialTheme.typography.bodyLarge)
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
        title = "Sample Episodes ",
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
    val viewModel = EpisodeViewModel()
    EpisodesScreen(viewModel)
}