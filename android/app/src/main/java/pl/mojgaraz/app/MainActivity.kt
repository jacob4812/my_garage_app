package pl.mojgaraz.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import pl.mojgaraz.app.presentation.navigation.AppNavigation
import pl.mojgaraz.app.presentation.ui.theme.MojGarazTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MojGarazTheme {
                AppNavigation()
            }
        }
    }
}
