package com.sd.lib.encrypt

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@Throws(NoSuchAlgorithmException::class)
fun fMd5(input: String): String {
    return fMd5(input.toByteArray())
}

@Throws(NoSuchAlgorithmException::class)
fun fMd5(input: ByteArray): String {
    val md5Bytes = MessageDigest.getInstance("MD5").digest(input)
    return buildString {
        for (byte in md5Bytes) {
            val hex = Integer.toHexString(0xff and byte.toInt())
            if (hex.length == 1) append("0")
            append(hex)
        }
    }
}