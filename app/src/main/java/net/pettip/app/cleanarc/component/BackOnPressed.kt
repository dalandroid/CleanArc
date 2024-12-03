package net.pettip.app.cleanarc.component

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

/**
 * @Project     : PetTip-Android
 * @FileName    : BackOnPressed
 * @Date        : 2024-12-02
 * @author      : CareBiz
 * @description : net.pettip.app.cleanarc.component
 * @see net.pettip.app.cleanarc.component.BackOnPressed
 */
@Composable
fun BackOnPressed(
) {
    val context = LocalContext.current
    var backPressedState by remember { mutableStateOf(true) }
    var backPressedTime = 0L
    val closeCmt = "한 번 더 누르면 앱이 종료됩니다"

    BackHandler(enabled = backPressedState) {
        if(System.currentTimeMillis() - backPressedTime <= 1000L) {
            // 앱 종료
            (context as Activity).finish()
        } else {
            backPressedState = true
            Toast.makeText(context, closeCmt, Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}