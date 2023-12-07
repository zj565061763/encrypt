package com.sd.demo.encrypt

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sd.lib.encrypt.fAesDecrypt
import com.sd.lib.encrypt.fAesEncrypt
import com.sd.lib.encrypt.fMd5
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun testAes() {
        val key = "1234567891234567"
        val content = "content"
        val contentEncrypt = fAesEncrypt(content, key)
        assertEquals(content, fAesDecrypt(contentEncrypt, key))
    }

    @Test
    fun testMd5() {
        val md5 = fMd5("hello world!")
        assertEquals("FC3FF98E8C6A0D3087D515C0473F8677", md5)
    }
}