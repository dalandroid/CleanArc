package net.pettip.app.cleanarc.screen.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun CreateScreen(
    navController: NavHostController
){
    var color by remember { mutableStateOf(Color.Blue) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .clickable{
                color = Color.Black
            },
        contentAlignment = Alignment.Center
    ){
        Text(text = "CommunityScreen")
    }
}