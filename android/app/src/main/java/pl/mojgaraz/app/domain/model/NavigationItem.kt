package pl.mojgaraz.app.domain.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector
import pl.mojgaraz.app.R

enum class NavigationItem(
    val route: String,
    @StringRes val labelRes: Int,
    val icon: ImageVector,
) {
    START("start", R.string.nav_start, Icons.Default.Home),
    TOOLS("tools", R.string.nav_tools, Icons.Default.Build),
    PARTS("parts", R.string.nav_parts, Icons.Default.Inventory2),
    INVENTORY("inventory", R.string.nav_inventory, Icons.Default.PieChart),
    MORE("more", R.string.nav_more, Icons.Default.MoreHoriz),
}
