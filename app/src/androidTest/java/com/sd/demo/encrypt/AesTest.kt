package com.sd.demo.encrypt

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sd.lib.encrypt.fAesDecrypt
import com.sd.lib.encrypt.fAesEncrypt
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AesTest {
   @Test
   fun test() {
      val key = "1234567891234567"
      val content = "content"

      val contentEncrypt = fAesEncrypt(content, key)
      assertEquals("M6ig5jd3evwm9mWFeDqq5Q==\n", contentEncrypt)

      assertEquals(content, fAesDecrypt(contentEncrypt, key))
   }
}