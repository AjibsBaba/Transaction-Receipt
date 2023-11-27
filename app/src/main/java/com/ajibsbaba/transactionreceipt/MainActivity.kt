package com.ajibsbaba.transactionreceipt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajibsbaba.transactionreceipt.ui.theme.BaseBlack
import com.ajibsbaba.transactionreceipt.ui.theme.Blue20
import com.ajibsbaba.transactionreceipt.ui.theme.Green
import com.ajibsbaba.transactionreceipt.ui.theme.Grey20
import com.ajibsbaba.transactionreceipt.ui.theme.TransactionReceiptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransactionReceiptTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptScreen() {

    var checked by remember { mutableStateOf(false) }

    Scaffold(containerColor = Blue20) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), verticalArrangement = Arrangement.Bottom
        ) {

            OutlinedCard(
                modifier = Modifier
                    .padding(bottom = 36.dp, start = 19.5.dp, end = 19.5.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFF6F6F6)),
                elevation = CardDefaults.cardElevation(
                    1.dp
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(16.dp)
                        .height(203.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF5F7FC),
                            shape = RoundedCornerShape(size = 16.dp)
                        )
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.receipt_bg),
                            contentDescription = "Receipt Background"
                        )
                        Image(
                            painter = painterResource(id = R.drawable.receipt_header),
                            contentDescription = "Receipt Header",
                            modifier = Modifier
                                .align(
                                    Alignment.TopCenter
                                )
                                .padding(24.dp)
                        )
                        Row(
                            modifier = Modifier.padding(top = 12.dp),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.receipt_placeholder),
                                contentDescription = "Placeholder"
                            )
                            if (checked) {
                                Image(
                                    painter = painterResource(id = R.drawable.image_card),
                                    contentDescription = "Image Placeholder"
                                )
                            }

                        }
                    }

                }
                Divider(
                    thickness = 1.dp, modifier = Modifier
                        .padding(16.dp)
                        .border(
                            border = BorderStroke(0.dp, Color.Transparent),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.width(249.dp)) {
                        Text(
                            text = "Add Image.",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = "Make it memorable, set the mood and add personality to the receipt.",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF4B4B4B),
                            ),
                            modifier = Modifier.padding(top = 6.dp)
                        )
                    }
                    Switch(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Green,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Grey20,
                        ),
                    )
                }
                if (checked) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .drawWithContent {
                                drawContent()
                                drawRoundRect(
                                    color = Color(0xFF91D7FF),
                                    size = size,
                                    style = Stroke(
                                        width = 1.dp.toPx(),
                                        pathEffect = PathEffect.dashPathEffect(
                                            floatArrayOf(
                                                10f * density,
                                                5f * density
                                            ), 0f
                                        )
                                    ),
                                    cornerRadius = CornerRadius(12.0F, 12.0F)
                                )
                            }
                    ) {
                        Row(modifier = Modifier.padding(8.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.image_vector),
                                contentDescription = "image description",
                                contentScale = ContentScale.None
                            )
                            Text(
                                text = "You currently have no image set, tap here to choose.",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF00A3FF),
                                ),
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        }

                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F7FC)),
                        modifier = Modifier
                            .width(149.dp)
                            .height(42.dp), shape = RoundedCornerShape(size = 32.dp)

                    ) {
                        Text(
                            "Download", style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                )
                        )
                    }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = BaseBlack),
                        modifier = Modifier
                            .width(149.dp)
                            .height(42.dp),
                        shape = RoundedCornerShape(size = 32.dp)
                    ) {
                        Text(
                            "Share receipt", style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF),

                                )
                        )
                    }
                }

            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectImageReceiptScreen() {

    var checked by remember { mutableStateOf(false) }

    Scaffold(containerColor = Blue20) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), verticalArrangement = Arrangement.Bottom
        ) {

            OutlinedCard(
                modifier = Modifier
                    .padding(bottom = 36.dp, start = 19.5.dp, end = 19.5.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFF6F6F6)),
                elevation = CardDefaults.cardElevation(
                    1.dp
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(16.dp)
                        .height(203.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFFF5F7FC),
                            shape = RoundedCornerShape(size = 16.dp)
                        )
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.receipt_bg),
                            contentDescription = "Receipt Background"
                        )
                        Image(
                            painter = painterResource(id = R.drawable.receipt_header),
                            contentDescription = "Receipt Header",
                            modifier = Modifier
                                .align(
                                    Alignment.TopCenter
                                )
                                .padding(24.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .height(200.dp),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.receipt_placeholder),
                                contentDescription = "Placeholder"
                            )
                            if (checked) {
                                Box(
                                    Modifier
                                        .border(width = 1.dp, color = Color(0xFF91D7FF))
                                        .padding(1.dp)
                                        .height(130.dp)
                                        .background(
                                            color = Color(0xFFF5FBFF),
                                            shape = RoundedCornerShape(size = 4.dp)
                                        )
                                ) {

                                }
                            }

                        }
                    }

                }
                Divider(
                    thickness = 1.dp, modifier = Modifier
                        .padding(16.dp)
                        .border(
                            border = BorderStroke(0.dp, Color.Transparent),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.width(249.dp)) {
                        Text(
                            text = "Select Image",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = "Make image selection default",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF4B4B4B),
                            ),
                            modifier = Modifier.padding(top = 6.dp)
                        )
                    }
                    Switch(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Green,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Grey20,
                        ),
                    )
                }
                if (checked) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .drawWithContent {
                                drawContent()
                                drawRoundRect(
                                    color = Color(0xFF91D7FF),
                                    size = size,
                                    style = Stroke(
                                        width = 1.dp.toPx(),
                                        pathEffect = PathEffect.dashPathEffect(
                                            floatArrayOf(
                                                10f * density,
                                                5f * density
                                            ), 0f
                                        )
                                    ),
                                    cornerRadius = CornerRadius(12.0F, 12.0F)
                                )
                            }
                    ) {
                        Box(modifier = Modifier.padding(8.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.image_vector),
                                contentDescription = "image description",
                                contentScale = ContentScale.None
                            )
                        }
                    }
                    Row {
                        Box(modifier = Modifier.padding(8.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.image_vector),
                                contentDescription = "image description",
                                contentScale = ContentScale.None
                            )
                        }
                        Box(modifier = Modifier.padding(8.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.image_vector),
                                contentDescription = "image description",
                                contentScale = ContentScale.None
                            )
                        }
                        Box(modifier = Modifier.padding(8.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.image_vector),
                                contentDescription = "image description",
                                contentScale = ContentScale.None
                            )
                        }
                        Box(modifier = Modifier.padding(8.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.image_vector),
                                contentDescription = "image description",
                                contentScale = ContentScale.None
                            )
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F7FC)),
                        modifier = Modifier
                            .width(149.dp)
                            .height(42.dp), shape = RoundedCornerShape(size = 32.dp)

                    ) {
                        Text(
                            "Back", style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),

                                )
                        )
                    }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = BaseBlack),
                        modifier = Modifier
                            .width(149.dp)
                            .height(42.dp),
                        shape = RoundedCornerShape(size = 32.dp)
                    ) {
                        Text(
                            "Share", style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF),

                                )
                        )
                    }
                }

            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReceiptPreview() {
    ReceiptScreen()
}
