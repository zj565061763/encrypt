package com.sd.demo.encrypt

import com.sd.lib.encrypt.fMd5
import org.junit.Assert.assertEquals
import org.junit.Test

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
      assertEquals(result, fMd5(input))
   }
}