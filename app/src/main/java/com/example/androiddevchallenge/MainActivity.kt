/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyList()
        }
    }

    @Composable
    fun PuppyList() {
        val puppyData = arrayOf(
            PuppyInfo(
                5,
                "Lulu",
                "Jarrod Richards",
                "this is some info about this puppy,balabalabgala...",
                R.drawable.lulu
            ), PuppyInfo(
                12,
                "Niko",
                "Stanley Bowles",
                "this is some info about this puppy,balabalabgala...",
                R.drawable.niko
            ), PuppyInfo(
                6,
                "Spot",
                "Tim Harvey",
                "this is some info about this puppy,balabalabgala...",
                R.drawable.spot
            ), PuppyInfo(
                21,
                "Lucky",
                "Cameron Coombs",
                "this is some info about this puppy,balabalabgala...",
                R.drawable.lucky
            ), PuppyInfo(
                12,
                "Buddy",
                "Alfredo Rahman",
                "this is some info about this puppy,balabalabgala...",
                R.drawable.buddy
            ), PuppyInfo(
                5,
                "Jarvis",
                "Dax Lautner",
                "this is some info about this puppy,balabalabgala...",
                R.drawable.jarvis
            ), PuppyInfo(
                5,
                "Loki",
                "Lucas Nicole",
                "this is some info about this puppy,balabalabgala...",
                R.drawable.loki
            )
        )
            LazyColumn(content = {
                items(puppyData) {
                    PuppyItem(puppyInfo = it)
                }
            })
    }

    @Composable
    fun PuppyItem(puppyInfo: PuppyInfo) {
        Card(
            elevation = 4.dp,
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp)
                .clickable {
//                    Toast
//                        .makeText(this, puppyInfo.name, Toast.LENGTH_LONG)
//                        .show()
                    val intent = Intent()
                    //获取intent对象
                    intent.setClass(this, PuppyDetailActivity::class.java)
                    intent.putExtra("puppyInfo",puppyInfo)
                    startActivity(intent)
                },
            shape = RoundedCornerShape(18.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = puppyInfo.imageRes), contentDescription = puppyInfo.name,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .clip(shape = RoundedCornerShape(18.dp)),
                    contentScale = ContentScale.FillBounds

                )
                Spacer(modifier = Modifier.width(20.dp))
                Column(

                ) {
                    Text(
                        text = puppyInfo.name,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Age:${puppyInfo.age} months old",
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Publisher:${puppyInfo.publisher}",
                        color = Color.Blue,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewList() {
        PuppyList()
    }
}
