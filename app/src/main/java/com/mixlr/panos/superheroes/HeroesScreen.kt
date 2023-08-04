package com.mixlr.panos.superheroes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mixlr.panos.superheroes.model.Hero

@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                HeroHeader(header = stringResource(hero.nameRes))
                HeroInfo(info = stringResource(id = hero.descriptionRes))
            }
            HeroImage(image = hero.imageRes)
        }
    }
}

@Composable
fun HeroHeader(
    header: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = header,
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
fun HeroInfo(
    info: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = info,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun HeroImage(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            modifier = modifier
                .padding(start = 16.dp),
            contentScale = ContentScale.FillWidth
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}
