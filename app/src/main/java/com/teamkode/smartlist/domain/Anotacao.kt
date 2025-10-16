package com.teamkode.smartlist.domain

import java.time.LocalDateTime

data class Anotacao(
    val id:Long,
    val titulo:String,
    val categoriaId:Long,
    val anotacao:String,
    val data: LocalDateTime
)
