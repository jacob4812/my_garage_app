package pl.mojgaraz.app.presentation.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pl.mojgaraz.app.R
import pl.mojgaraz.app.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.uiState
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(text = stringResource(state.titleRes), style = MaterialTheme.typography.headlineMedium)
        Text(text = stringResource(state.welcomeRes), style = MaterialTheme.typography.titleLarge)
        Text(text = stringResource(R.string.home_description))
        FeatureCard(
            titleRes = R.string.home_tools_title,
            descriptionRes = R.string.home_tools_description,
        )
        FeatureCard(
            titleRes = R.string.home_parts_title,
            descriptionRes = R.string.home_parts_description,
        )
    }
}

@Composable
private fun FeatureCard(@StringRes titleRes: Int, @StringRes descriptionRes: Int) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = stringResource(titleRes), style = MaterialTheme.typography.titleMedium)
            Text(text = stringResource(descriptionRes))
            Text(text = stringResource(R.string.feature_next_version))
        }
    }
}

@Composable
fun PlaceholderScreen(@StringRes titleRes: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(text = stringResource(titleRes), style = MaterialTheme.typography.headlineMedium)
        Text(text = stringResource(R.string.section_unavailable))
        Text(text = stringResource(R.string.feature_next_version))
    }
}

@Composable
fun MoreScreen(onSettingsClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(text = stringResource(R.string.more_title), style = MaterialTheme.typography.headlineMedium)
        Button(onClick = onSettingsClick) {
            Text(text = stringResource(R.string.settings_open))
        }
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(text = stringResource(R.string.settings_title), style = MaterialTheme.typography.headlineMedium)
        Text(text = stringResource(R.string.settings_description))
        Text(text = stringResource(R.string.feature_next_version))
    }
}
