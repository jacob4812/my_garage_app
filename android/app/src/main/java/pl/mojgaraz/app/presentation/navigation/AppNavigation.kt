package pl.mojgaraz.app.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pl.mojgaraz.app.R
import pl.mojgaraz.app.domain.model.NavigationItem
import pl.mojgaraz.app.presentation.screens.HomeScreen
import pl.mojgaraz.app.presentation.screens.MoreScreen
import pl.mojgaraz.app.presentation.screens.PlaceholderScreen
import pl.mojgaraz.app.presentation.screens.SettingsScreen

private const val SETTINGS_ROUTE = "settings"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val selectedItem = NavigationItem.entries.firstOrNull { it.route == currentRoute }
    val showBottomBar = selectedItem != null

    Scaffold(
        topBar = {
            if (currentRoute == SETTINGS_ROUTE) {
                TopAppBar(
                    title = { Text(stringResource(R.string.settings_title)) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back),
                            )
                        }
                    },
                )
            }
        },
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    NavigationItem.entries.forEach { item ->
                        NavigationBarItem(
                            selected = item == selectedItem,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = stringResource(item.labelRes),
                                )
                            },
                            label = { Text(stringResource(item.labelRes)) },
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationItem.START.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(NavigationItem.START.route) { HomeScreen() }
            composable(NavigationItem.TOOLS.route) {
                PlaceholderScreen(titleRes = R.string.nav_tools)
            }
            composable(NavigationItem.PARTS.route) {
                PlaceholderScreen(titleRes = R.string.nav_parts)
            }
            composable(NavigationItem.INVENTORY.route) {
                PlaceholderScreen(titleRes = R.string.nav_inventory)
            }
            composable(NavigationItem.MORE.route) {
                MoreScreen(onSettingsClick = { navController.navigate(SETTINGS_ROUTE) })
            }
            composable(SETTINGS_ROUTE) { SettingsScreen() }
        }
    }
}
