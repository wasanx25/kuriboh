package com.github.wasanx25
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider
import com.github.wasanx25.rules.UselessCallFunction

class KuribohProvider : RuleSetProvider {
    override val ruleSetId: String = "sample"

    override fun instance(config: Config): RuleSet {
        return RuleSet(ruleSetId, listOf(
            UselessCallFunction()
        ))
    }
}
