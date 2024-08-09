package com.efikay.wbubtw.challenge

import com.efikay.wbubtw.challenge.contest.ChallengeContest
import com.efikay.wbubtw.challenge.contest.RandomChoiceContest
import com.efikay.wbubtw.challenge.contest.RandomQuantifiedChoiceContest
import com.efikay.wbubtw.challenge.contest.RandomQuantityContest
import com.efikay.wbubtw.random.service.RandomService
import org.springframework.stereotype.Service

@Service
class ChallengeService(private val randomService: RandomService) {
    val challenges: List<ChallengeContest> = listOf(
        RandomQuantityContest(
            displayName = "ICQ-challenge",
            getQuantity = { randomService.getRandomNumber(1..200) },
            displayDescription = "Измеряет ICQ точнее менсы (доказано британскими учеными)",
            resultTemplates = hashMapOf(
                1..39 to listOf(
                    "Ну ты и лузер! %d IQ. С таким только в деревене флексить",
                    "Мои соболезнования... %d ICQ"
                ),
                40..79 to listOf("Ну такое... Шо с тебя взять... 🤤 %d IQ"),
                80..99 to listOf("%d IQ!"),
                100..119 to listOf("%d IQ!!"),
                120..159 to listOf("%d IQ!!!"),
                160..200 to listOf("У вас исключительно высокий ICQ-level – %d")
            )
        ),
        RandomQuantityContest(
            displayName = "Тест на аутизм",
            getQuantity = { randomService.getRandomNumber(1..100) },
            displayDescription = "А есть ли смысл проверяться? Ну нажми",
            resultTemplates = hashMapOf(
                1..24 to listOf(
                    "Вы не аутист!",
                    "Ваш уровень аутизма оценен в %d%%"
                ),
                25..49 to listOf(
                    "Ты почти не аутист... Тест показал %d%%, ну можешь не париться"
                ),
                50..74 to listOf(
                    "Мы не можем точно определить, но у вас примерно 50-74%% аутизма. Много ли или мало – решать тебе"
                ),
                75..100 to listOf(
                    "Имеются серьезные основания полагать что... Думайте"
                ),
            )
        ),
        RandomChoiceContest(
            displayName = "Кто ты из смешариков",
            displayDescription = "Проверься! (или Бараш пострадает)",
            choices = listOf(
                "Нюша – маленькая свинка, всегда в поиске новых приключений. Она дружелюбна, умна и любознательна.",
                "Лосяш – лось, который часто путается в собственных мыслях. Он добрый и немного сонный.",
                "Совунья – сова, обладающая острым умом и любопытством. Она часто помогает решать сложные задачи.",
                "Кар Карыч – ворон, всегда в поиске чего-то вкусного. Он хитрый и изобретателен.",
                "Бараш – барашек, который любит спать и есть. Он добродушный и легко поддается влиянию других.",
                "Пин – пингвин, обладающий хорошим чувством юмора. Он всегда готов помочь друзьям.",
                "Копатыч – медведь, сильный и умелый. Он заботится о своих друзьях и всегда готов защитить их.",
            )
        ),
        RandomQuantifiedChoiceContest(
            displayName = "Травля",
            displayDescription = "Проверься на негатив (без негатива)",
            choicesWithTemplates = mapOf(
                "Травитель" to mapOf(
                    0..50 to listOf(
                        "Ты травитель на %d%%! Не сказать что твой день"
                    ),
                    51..100 to listOf(
                        "Ты сегодня в ударе! Твоя травля оценена на %d%%!"
                    )
                ),
                "Нейтрал" to mapOf(
                    0..100 to listOf(
                        "Сегодня ты – самый скучный человек в чате.",
                        "Ни рыба, ни мясо.",
                        "Что? Аааа, ты... Тебе сегодня нечем выделиться, обычный NPC"
                    )
                ),
                "Жертва травли" to mapOf(
                    1..100 to listOf(
                        "Сегодня затравить могут разве что только тебя! Берегись",
                        "Сегодня на тебя в секретном чате объявлена охота!"
                    )
                )
            ),
            getQuantity = { randomService.getRandomNumber(1..100) },
        )
    )

    fun generateChallengeResults(): List<ChallengeResult> = challenges.map { it.execute() }
}