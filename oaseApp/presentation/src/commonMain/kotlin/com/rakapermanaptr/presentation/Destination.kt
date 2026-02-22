import kotlinx.serialization.Serializable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

// 1. Definisikan Route sebagai class/object murni
@Serializable sealed interface Route

@Serializable data object HomeRoute : Route
@Serializable data object HavenRoute : Route
@Serializable data object ExploreRoute : Route
@Serializable data object ProfileRoute : Route
@Serializable data object SignInRoute : Route
@Serializable data object SignUpRoute : Route
@Serializable data class HavenDetailsRoute(val roomId: String) : Route

// 2. Buat UI Wrapper untuk Bottom Bar (Metadata)
// Ini tidak perlu @Serializable karena hanya dipakai di level UI
data class NavigationItem(
    val route: Route,
    val title: String,
    val icon: ImageVector?
)

val bottomNavItems = listOf(
    NavigationItem(HavenRoute, "Haven", Icons.Default.Home),
    NavigationItem(ExploreRoute, "Explore", Icons.Default.TravelExplore),
    NavigationItem(ProfileRoute, "Profile", Icons.Default.Person)
)