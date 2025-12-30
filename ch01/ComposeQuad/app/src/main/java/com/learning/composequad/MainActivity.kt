package com.learning.composequad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learning.composequad.ui.theme.ComposeQuadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuad(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ComposeCard(title: String, content: String, bg: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(bg)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp),
        )
        Text(
            text = content,
        )
    }
}

@Composable
fun ComposeRow(t1: String, c1: String, bg1: Color, t2: String, c2: String, bg2: Color, modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(),
    ) {
        ComposeCard(title = t1, content = c1, bg = bg1, Modifier.weight(1f).fillMaxHeight())
        ComposeCard(title = t2, content = c2, bg = bg2, Modifier.weight(1f).fillMaxHeight())
    }
}
@Preview(showBackground = true)
@Composable
fun ComposeQuad(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        ComposeRow(
            t1 = stringResource(R.string.text),
            c1 = stringResource(R.string.text_c),
            t2 = stringResource(R.string.image),
            c2 = stringResource(R.string.image_c),
            bg1 = Color(0xFFEADDFF),
            bg2 = Color(0xFFD0BCFF),
            modifier = Modifier.weight(1f)
        )
        ComposeRow(
            t1 = stringResource(R.string.row),
            c1 = stringResource(R.string.row_c),
            t2 = stringResource(R.string.column),
            c2 = stringResource(R.string.column_c),
            bg1 = Color(0xFFB69DF8),
            bg2 = Color(0xFFF6EDFF),
            modifier = Modifier.weight(1f)
        )
    }
}

