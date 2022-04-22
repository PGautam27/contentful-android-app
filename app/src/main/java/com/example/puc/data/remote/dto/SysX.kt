package com.example.puc.data.remote.dto

data class SysX(
    val contentType: ContentType,
    val createdAt: String,
    val environment: Environment,
    val id: String,
    val locale: String,
    val revision: Int,
    val space: Space,
    val type: String,
    val updatedAt: String
)