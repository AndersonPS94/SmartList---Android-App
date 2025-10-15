package com.teamkode.smartlist.domain

import java.time.LocalDateTime

data class AnotacaoDetalhada(
    val id: Long,
    val titulo: String,
    val anotacao: String,
    val data: LocalDateTime,
    val categoria:Long
)
