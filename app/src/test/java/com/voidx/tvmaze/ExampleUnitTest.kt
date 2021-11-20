package com.voidx.tvmaze

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PotatoesChallenge {

    @Test
    fun `check how many potatoes has in the string`() {

        val potatoesMock = "potatoespotatoespotatoespotatoes"

        var startPosition = 0
        val potatoes = "potatoes"
        val potatoesLength = potatoes.length

        var count = 0

        while(startPosition < potatoesMock.length) {

            val thePotato = potatoesMock.substring(startPosition, startPosition + potatoesLength)

            if (thePotato == potatoes) {
                count += 1
            }

            startPosition += potatoesLength
        }

        assertEquals(4, count)
    }
}