package com.sd.lib.encrypt

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@Throws(NoSuchAlgorithmException::class)
fun fMd5(input: String): String {
    return fMd5(input.toByteArray())
}

@Throws(NoSuchAlgorithmException::class)
fun fMd5(input: ByteArray): String {
    return MessageDigest.getInstance("MD5")
        .digest(input)
        .let { bytes ->
            bytes.joinToString("") { "%02X".format(it) }
        }
}