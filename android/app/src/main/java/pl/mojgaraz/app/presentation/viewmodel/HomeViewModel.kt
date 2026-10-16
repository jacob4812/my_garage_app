package pl.mojgaraz.app.presentation.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import pl.mojgaraz.app.R

data class HomeUiState(
    @StringRes val titleRes: Int = R.string.home_title,
    @StringRes val welcomeRes: Int = R.string.home_welcome,
)

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val uiState: HomeUiState = HomeUiState()
}
