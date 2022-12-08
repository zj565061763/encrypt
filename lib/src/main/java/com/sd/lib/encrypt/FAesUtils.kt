package com.sd.lib.encrypt

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

private const val DefaultTransform = "AES/ECB/PKCS5Padding"

/**
 * 加密
 */
fun fAesEncrypt(input: String, key: String, transform: String = DefaultTransform): String {
    return try {
        val bytes = input.toByteArray()
        fAesEncrypt(bytes, key, transform)?.let {
            String(it, Charsets.US_ASCII)
        } ?: ""
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

/**
 * 解密
 */
fun fAesDecrypt(input: String, key: String, transform: String = DefaultTransform): String {
    return try {
        val bytes = input.toByteArray()
        fAesDecrypt(bytes, key, transform)?.let {
            String(it)
        } ?: ""
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

/**
 * 加密
 */
fun fAesEncrypt(input: ByteArray, key: String, transform: String = DefaultTransform): ByteArray? {
    return try {
        val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
        Cipher.getInstance(transform).apply {
            this.init(Cipher.ENCRYPT_MODE, secretKeySpec)
        }.doFinal(input)?.let {
            Base64.encode(it, Base64.DEFAULT)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

/**
 * 解密
 */
fun fAesDecrypt(input: ByteArray, key: String, transform: String = DefaultTransform): ByteArray? {
    return try {
        val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
        Cipher.getInstance(transform).apply {
            this.init(Cipher.DECRYPT_MODE, secretKeySpec)
        }.doFinal(Base64.decode(input, Base64.DEFAULT))
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}