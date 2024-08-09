package com.efikay.wbubtw.challenge.contest

import com.efikay.wbubtw.challenge.ChallengeResult

class RandomQuantityContest(
    @Suppress("FORBIDDEN_VARARG_PARAMETER_TYPE", "UNUSED_PARAMETER")
    vararg nothings: Nothing,
    private val displayName: String,
    private val displayDescription: String,
    private val resultTemplates: Map<IntRange, List<String>>,
    private val getQuantity: () -> Int,
    private val units: String? = null,
) : ChallengeContest {
    override fun execute(): ChallengeResult {
        val result = getQuantity()

        val (_, templates) = resultTemplates.entries.find { (range) -> range.contains(result) }!!

        return ChallengeResult(
            displayName = displayName,
            displayDescription = displayDescription,
            displayResult = templates.random().format(result, units),
        )
    }
}