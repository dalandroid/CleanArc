package net.pettip.app.cleanarc.screen.main.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.pettip.app.cleanarc.component.BackOnPressed
import net.pettip.app.cleanarc.component.BottomNavWithAnimation
import net.pettip.app.cleanarc.component.Screen

/**
 * @Project     : PetTip-Android
 * @FileName    : MainScreen
 * @Date        : 2024-11-29
 * @author      : CareBiz
 * @description : net.pettip.app.cleanarc.screen
 * @see net.pettip.app.cleanarc.screen.MainScreen
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController){

    val screens = listOf(Screen.Home, Screen.Create, Screen.Profile, Screen.Settings)
    var selectedScreen by remember { mutableStateOf(0) }

    val mainNavHostController = rememberNavController()

    val navBackStackEntry by mainNavHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route


    LaunchedEffect(currentDestination) {

    }

    BackOnPressed()

    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .navigationBarsPadding(),
        bottomBar = {
            BottomNavWithAnimation(
                navHostController = mainNavHostController,
                currentDestination = navBackStackEntry?.destination
            )
        }
    ){
        NavHost(
            navController = mainNavHostController,
            startDestination = Screen.Home.title,
        ) {
            composable(
                route = Screen.Home.title
            ){
                HomeScreen(navController = navController)
            }

            composable(
                route = Screen.Create.title
            ){
                CreateScreen(navController = navController)
            }

            composable(
                route = Screen.Profile.title
            ){
                ProfileScreen(navController = navController)
            }

            composable(
                route = Screen.Settings.title
            ){
                SettingScreen(navController = navController)
            }
        }
    }
}
