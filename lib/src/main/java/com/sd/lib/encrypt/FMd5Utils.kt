package com.sd.lib.encrypt

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@Throws(NoSuchAlgorithmException::class)
fun String.fMd5(): String {
    return this.toByteArray().fMd5()
}

@Throws(NoSuchAlgorithmException::class)
fun ByteArray.fMd5(): String {
    return this.fMd5Bytes().hexString()
}

@Throws(NoSuchAlgorithmException::class)
private fun ByteArray.fMd5Bytes(): ByteArray {
    return MessageDigest.getInstance("MD5").digest(this)
}

private fun ByteArray.hexString(): String {
    val bytes = this
    return buildString {
        for (byte in bytes) {
            val hex = Integer.toHexString(0xff and byte.toInt())
            if (hex.length == 1) append('0')
            append(hex)
        }
    }
}