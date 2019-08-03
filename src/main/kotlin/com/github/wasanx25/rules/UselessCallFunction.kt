package com.github.wasanx25.rules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression

class UselessCallFunction : Rule() {

    override val issue = Issue(
        javaClass.simpleName,
        Severity.Style,
        "Use println only in development",
        Debt.FIVE_MINS
    )

    override fun visitCallExpression(expression: KtCallExpression) {
        super.visitCallExpression(expression)
        val functions = listOf(PRINTLN, PRINT)
        expression.psiOrParent.children.toList()
            .filter { it is KtNameReferenceExpression && functions.contains(it.text) }
            .onEach { report(CodeSmell(issue, Entity.from(expression), "Don't keep 'println()' or 'print()'")) }
    }

    companion object {
        private const val PRINTLN = "println"
        private const val PRINT   = "print"
    }
}
