package net.pettip.app.cleanarc.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import net.pettip.app.cleanarc.R

/**
 * @Project     : PetTip-Android
 * @FileName    : IntroScreen
 * @Date        : 2024-11-29
 * @author      : CareBiz
 * @description : net.pettip.app.cleanarc.screen
 * @see net.pettip.app.cleanarc.screen.IntroScreen
 */
@Composable
fun IntroScreen(onNext:()->Unit) {

    val alpha = remember {
        Animatable(0f)
    }

    LaunchedEffect(Unit) {
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(1500)
        )

        delay(1500)
        onNext()
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(
            painter = painterResource(id = R.drawable.logo_ex),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.alpha(alpha = alpha.value)
        )
    }
}