package com.sd.lib.encrypt

import java.security.MessageDigest

fun fMd5(input: String): String? {
    return try {
        fMd5(input.toByteArray())
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun fMd5(input: ByteArray): String? {
    return try {
        MessageDigest.getInstance("MD5").digest(input).let {
            it.joinToString("") { "%02X".format(it) }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}