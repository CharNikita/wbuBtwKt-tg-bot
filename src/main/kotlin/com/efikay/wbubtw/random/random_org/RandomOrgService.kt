package com.efikay.wbubtw.random.random_org

import com.efikay.wbubtw.random.RandomService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("secondary")
class RandomOrgService: RandomService {
    override fun getRandomNumber(): Int {
        TODO("Not yet implemented")
    }

    override fun getRandomNumbers(amount: Int): IntArray {
        TODO("Not yet implemented")
    }
}