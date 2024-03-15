package com.sd.demo.encrypt

import com.sd.lib.encrypt.fMd5
import org.junit.Assert.assertEquals
import org.junit.Test
import java.security.MessageDigest

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Md5Test {
    @Test
    fun test() {
        val input = "123"
        val result = "202cb962ac59075b964b07152d234b70"
        assertEquals(result, input.fMd5())
        assertEquals(result, md5(input))
    }
}

private fun md5(input: String): String {
    val md5Bytes = MessageDigest.getInstance("MD5").digest(input.toByteArray())
    return buildString {
        for (byte in md5Bytes) {
            val hex = Integer.toHexString(0xff and byte.toInt())
            if (hex.length == 1) append("0")
            append(hex)
        }
    }
}