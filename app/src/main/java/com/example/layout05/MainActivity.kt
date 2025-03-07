package com.example.layout05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layout05.ui.theme.Layout05Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Layout05Theme {
                CategoryScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF78909C))
            .padding(8.dp)
    ) {
        TopAppBar(
            title = { Text(text = "Categories", color = Color.White) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF546E7A)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(modifier = Modifier.weight(1f)) {
                CategoryItem("Woman", R.drawable.saltoalto, Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                CategoryItem("Man", R.drawable.gravata, Modifier.weight(1f))
            }
            Row(modifier = Modifier.weight(1f)) {
                CategoryItem("Baby", R.drawable.chupeta, Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                CategoryItem("Travel", R.drawable.aviao, Modifier.weight(1f))
            }
            Row(modifier = Modifier.weight(1f)) {
                CategoryItem("Tech", R.drawable.tech, Modifier.weight(1f))
                Spacer(modifier = Modifier.width(8.dp))
                CategoryItem("Food & Drink", R.drawable.cafe, Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun CategoryItem(title: String, icon: Int, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .aspectRatio(1f)
            .background(Color(0xFF607D8B), shape = RoundedCornerShape(8.dp))
            .clickable {  }
            .padding(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, color = Color.White, fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    Layout05Theme {
        CategoryScreen()
    }
}
