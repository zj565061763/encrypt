package com.sd.lib.encrypt

import android.util.Base64
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.SecretKeySpec

private const val DefaultTransform = "AES/ECB/PKCS5Padding"

/**
 * 加密
 */
@Throws(
    /** [transform]参数错误 */
    NoSuchAlgorithmException::class,
    /** [transform]参数错误 */
    NoSuchPaddingException::class,
    /** [key]参数错误 */
    InvalidKeyException::class,
    /** 加密失败 */
    IllegalBlockSizeException::class,
    /** 加密失败 */
    BadPaddingException::class,
)
fun fAesEncrypt(
    input: String,
    key: String,
    transform: String = DefaultTransform,
): String {
    return fAesEncrypt(
        input = input.toByteArray(),
        key = key,
        transform = transform
    ).decodeToString()
}

/**
 * 加密
 */
@Throws(
    /** [transform]参数错误 */
    NoSuchAlgorithmException::class,
    /** [transform]参数错误 */
    NoSuchPaddingException::class,
    /** [key]参数错误 */
    InvalidKeyException::class,
    /** 加密失败 */
    IllegalBlockSizeException::class,
    /** 加密失败 */
    BadPaddingException::class,
)
fun fAesEncrypt(
    input: ByteArray,
    key: String,
    transform: String = DefaultTransform,
): ByteArray {
    return Cipher.getInstance(transform).apply {
        this.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key.toByteArray(), "AES"))
    }.doFinal(input).let {
        Base64.encode(it, Base64.DEFAULT)
    }
}

/**
 * 解密
 */
@Throws(
    /** [transform]参数错误 */
    NoSuchAlgorithmException::class,
    /** [transform]参数错误 */
    NoSuchPaddingException::class,
    /** [key]参数错误 */
    InvalidKeyException::class,
    /** 解密失败 */
    IllegalBlockSizeException::class,
    /** 解密失败 */
    BadPaddingException::class,
)
fun fAesDecrypt(
    input: String,
    key: String,
    transform: String = DefaultTransform,
): String {
    return fAesDecrypt(
        input = input.toByteArray(),
        key = key,
        transform = transform,
    ).decodeToString()
}


/**
 * 解密
 */
@Throws(
    /** [transform]参数错误 */
    NoSuchAlgorithmException::class,
    /** [transform]参数错误 */
    NoSuchPaddingException::class,
    /** [key]参数错误 */
    InvalidKeyException::class,
    /** 解密失败 */
    IllegalBlockSizeException::class,
    /** 解密失败 */
    BadPaddingException::class,
)
fun fAesDecrypt(
    input: ByteArray,
    key: String,
    transform: String = DefaultTransform,
): ByteArray {
    return Cipher.getInstance(transform).apply {
        this.init(Cipher.DECRYPT_MODE, SecretKeySpec(key.toByteArray(), "AES"))
    }.let {
        val decode = Base64.decode(input, Base64.DEFAULT)
        it.doFinal(decode)
    }
}