package com.sd.lib.encrypt

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@Throws(NoSuchAlgorithmException::class)
fun String.fMd5(): String {
    return this.toByteArray().fMd5()
}

@Throws(NoSuchAlgorithmException::class)
fun ByteArray.fMd5(): String {
    val md5Bytes = MessageDigest.getInstance("MD5").digest(this)
    return buildString {
        for (byte in md5Bytes) {
            val hex = Integer.toHexString(0xff and byte.toInt())
            if (hex.length == 1) append("0")
            append(hex)
        }
    }
}