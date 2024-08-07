package com.natifedanilharitonov.data.source.randomText

import kotlinx.coroutines.delay
import kotlin.random.Random

@Suppress("ktlint:standard:max-line-length")
internal class RandomTextSourceImpl : RandomTextSource {
    private val textList =
        listOf(
            "Be at miss or each good play home they. It leave taste mr in it fancy. She son lose does fond bred gave lady get. Sir her company conduct expense bed any. Sister depend change off piqued one. Contented continued any happiness instantly objection yet her allowance. Use correct day new brought tedious. By come this been in. Kept easy or sons my it done.",
            "And produce say the ten moments parties. Simple innate summer fat appear basket his desire joy. Outward clothes promise at gravity do excited. Sufficient particular impossible by reasonable oh expression is. Yet preference connection unpleasant yet melancholy but end appearance. And excellence partiality estimating terminated day everything.",
            "Style too own civil out along. Perfectly offending attempted add arranging age gentleman concluded. Get who uncommonly our expression ten increasing considered occasional travelling. Ever read tell year give may men call its. Piqued son turned fat income played end wicket. To do noisy downs round an happy books.",
            "Projecting surrounded literature yet delightful alteration but bed men. Open are from long why cold. If must snug by upon sang loud left. As me do preference entreaties compliment motionless ye literature. Day behaviour explained law remainder. Produce can cousins account you pasture. Peculiar delicate an pleasant provided do perceive.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident",
            "Facilis percipit consectetuer has ei. Vel at quod deserunt eloquentiam, vidisse salutandi ex vel. Eam ut augue consul, ignota perpetua interpretaris vis ne. Eu sea graeco legendos, velit perfecto instructior cu usu. Pro in lorem dolorem.",
            "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire",
            "But I must explain to you how all this mistaken idea of denouncing of a pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth the master-builder of human happiness.",
        )

    override suspend fun getRandomText(): String? {
        return if (Random.nextInt(100) < 5) {
            null // 10% chance for an error to return
        } else {
            delay(1000)
            textList.random()
        }
    }
}
