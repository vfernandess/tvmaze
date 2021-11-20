package com.voidx.core.view.util

import android.graphics.Bitmap
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.TransformationUtils
import com.bumptech.glide.util.Util
import java.nio.ByteBuffer
import java.security.MessageDigest

private const val ID = "com.voidx.core.view.util.RoundedCorners"
private val ID_BYTES = ID.toByteArray(com.bumptech.glide.load.Key.CHARSET)

class RoundedCorners(
    private val topLeft: Int,
    private val topRight: Int,
    private val bottomRight: Int,
    private val bottomLeft: Int
) : BitmapTransformation() {

    protected override fun transform(
        pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int
    ): Bitmap {
        return TransformationUtils.roundedCorners(
            pool,
            toTransform,
            topLeft.toFloat(),
            topRight.toFloat(),
            bottomRight.toFloat(),
            bottomLeft.toFloat()
        )
    }

    override fun equals(o: Any?): Boolean {
        if (o is RoundedCorners) {
            return topLeft == o.topLeft &&
                    topRight == o.topRight &&
                    bottomRight == o.bottomRight &&
                    bottomLeft == o.bottomLeft
        }
        return false
    }

    override fun hashCode(): Int {
        return Util.hashCode(
            ID.hashCode(),
            Util.hashCode(topLeft) +
                    Util.hashCode(topRight) +
                    Util.hashCode(bottomRight) +
                    Util.hashCode(bottomLeft)
        )
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(ID_BYTES)
        val radiusData = ByteBuffer
            .allocate(32)
            .putInt(topLeft)
            .putInt(topRight)
            .putInt(bottomRight)
            .putInt(bottomLeft)
            .array()
        messageDigest.update(radiusData)
    }
}