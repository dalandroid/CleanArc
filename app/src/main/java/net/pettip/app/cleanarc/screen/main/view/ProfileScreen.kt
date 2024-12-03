package net.pettip.app.cleanarc.screen.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

/**
 * @Project     : PetTip-Android
 * @FileName    : HomeScreen
 * @Date        : 2024-11-29
 * @author      : CareBiz
 * @description : net.pettip.app.cleanarc.screen.main
 * @see net.pettip.app.cleanarc.screen.main.HomeScreen
 */
 @Composable
fun ProfileScreen(
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Text(text = "ProfileScreen")
    }
}