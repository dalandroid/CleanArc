package net.pettip.app.cleanarc.screen.main.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.pettip.app.cleanarc.R

/**
 * @Project     : PetTip-Android
 * @FileName    : HomeScreen
 * @Date        : 2024-11-29
 * @author      : CareBiz
 * @description : net.pettip.app.cleanarc.screen.main
 * @see net.pettip.app.cleanarc.screen.main.HomeScreen
 */
 @Composable
fun HomeScreen(
    navController: NavHostController
){
    val lazyListState = rememberLazyListState()
    val items = listOf(R.drawable.lol, R.drawable.`val`)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues)
        ){
            Box(
                modifier = Modifier
                    .padding(top = 16.dp, start = 8.dp)
                    .fillMaxWidth()
                    .height(40.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.logotext),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                state = lazyListState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(top = 16.dp, bottom = 80.dp)
            ) {
                items(items){item ->
                    GameListItem(
                        image = item
                    )
                }
            }
        }
    }
}

@Composable
fun GameListItem(image: Int) {

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }

    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.White),
        startY = sizeImage.height.toFloat()*0.5f,
        endY = sizeImage.height.toFloat()*0.98f
    )

    Column (
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(240.dp)
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(20.dp))
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp)),
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .onGloballyPositioned { sizeImage = it.size }
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            )

            Box(modifier = Modifier
                .matchParentSize()
                .background(gradient)
            )
        }

    }
}