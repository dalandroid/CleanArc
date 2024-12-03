package net.pettip.app.cleanarc.screen

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.pettip.app.cleanarc.screen.main.view.MainScreen

/**
 * @Project     : PetTip-Android
 * @FileName    : MyApp
 * @Date        : 2024-11-29
 * @author      : CareBiz
 * @description : net.pettip.app.cleanarc.screen
 * @see net.pettip.app.cleanarc.screen.MyApp
 */
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.IntroScreen.route,
        modifier = modifier.background(Color.White)
    ) {
        composable(
            route = Screen.IntroScreen.route,
            //deepLinks = listOf(
            //    navDeepLink {
            //        uriPattern = "https://pettip.net"
            //        action = Intent.ACTION_VIEW
            //    }
            //)
        ){
            IntroScreen(
                onNext = {
                    navController.navigate(Screen.MainScreen.route){
                        popUpTo(Screen.IntroScreen.route){inclusive = true}
                    }
                }
            )
        }

        composable(Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
    }
}

sealed class Screen(val route: String) {
    data object IntroScreen : Screen("intro")
    data object MainScreen : Screen("mainScreen")
}