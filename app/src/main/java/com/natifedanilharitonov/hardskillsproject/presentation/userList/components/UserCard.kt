package com.natifedanilharitonov.hardskillsproject.presentation.userList.components

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiName

@Composable
fun UserCard(
    modifier: Modifier = Modifier,
    image: Bitmap?,
    name: UiName,
) {
    Card(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(5.dp),
        shape =
            RoundedCornerShape(
                topStart = 5.dp,
                topEnd = 5.dp,
                bottomStart = 5.dp,
            ),
        colors =
            CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.authBorderCard),
            ),
    ) {
        Row {
            AsyncImage(
                model = image,
                contentDescription = "User",
                modifier =
                    Modifier
                        .size(80.dp)
                        .padding(5.dp)
                        .clip(CircleShape),
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.users),
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart,
            ) {
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text =
                        stringResource(
                            id = R.string.user_full_name,
                            name.title,
                            name.first,
                            name.last,
                        ),
                    fontSize = 24.sp,
                )
            }
        }
    }
}
