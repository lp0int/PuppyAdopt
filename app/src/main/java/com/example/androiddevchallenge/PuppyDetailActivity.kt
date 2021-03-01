package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

class PuppyDetailActivity : AppCompatActivity() {
    lateinit var puppyInfo: PuppyInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        puppyInfo = intent.getSerializableExtra("puppyInfo") as PuppyInfo
        setContent {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.BottomCenter) {
                    Image(
                        painter = painterResource(id = puppyInfo.imageRes),
                        contentDescription = puppyInfo.name,
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                    )
                    Button(onClick = {
                        Toast.makeText(
                            this@PuppyDetailActivity,
                            "Thank you adaption me ❤️~",
                            Toast.LENGTH_SHORT
                        ).show()
                    },modifier = Modifier.padding(bottom = 12.dp)) {
                        Text(text = "Adopt me")
                    }
                }
//                Card(modifier = Modifier.height(40.dp).width(120.dp),
//                    elevation = 4.dp,
//
//                    shape = RoundedCornerShape(8.dp),) {
//                    Text(text = puppyInfo.name)
//                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "puppy name:${puppyInfo.name}.",
                    style = typography.h5
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "puppy age:${puppyInfo.name} months old.",
                    style = typography.body2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "more info:${puppyInfo.desc}${puppyInfo.desc}${puppyInfo.desc}${puppyInfo.desc} ",
                    style = typography.body2
                )
                Spacer(modifier = Modifier.height(10.dp))

            }
        }
    }
}