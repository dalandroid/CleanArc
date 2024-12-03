package net.pettip.app.cleanarc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.pettip.app.cleanarc.component.GlobalLoadingScreen
import net.pettip.app.cleanarc.screen.MyApp
import net.pettip.app.cleanarc.ui.theme.CleanArcTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition{false}

        enableEdgeToEdge()
        setContent {

            navController = rememberNavController()

            CleanArcTheme {
                Surface{
                    MyApp(navController = navController)
                    GlobalLoadingScreen()
                }
            }
        }
    }
}
