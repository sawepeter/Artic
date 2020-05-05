/*
 * Copyright 2020 Abdul-Mujeeb Aliu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliumujib.artic.domain.models

import java.util.*

data class Article(
    val id: Int,
    val type: String,
    val slug: String,
    val url: String,
    val status: String,
    val title: String,
    val title_plain: String,
    val content: String,
    val excerpt: String,
    val date: Date,
    val modified: String,
    val thumbnail: String,
    val fullImageURL: String,
    val comment_count: Int,
    val categories: List<Category>,
    val author: Author,
    var isBookmarked: Boolean
)
