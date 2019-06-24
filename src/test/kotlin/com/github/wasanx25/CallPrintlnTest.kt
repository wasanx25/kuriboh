package com.github.wasanx25

import com.github.wasanx25.rules.CallPrintln
import io.gitlab.arturbosch.detekt.test.assertThat
import io.gitlab.arturbosch.detekt.test.lint
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class CallPrintlnTest : Spek({
    val subject by memoized { CallPrintln() }

    describe("CallPrintln rule") {
        it("reports to exists println() yet") {
            val code = """
                fun test() {
                    println("test1")
                    emptyList()
                    println("test2")
                    println("test3")
                }
            """

            assertThat(subject.lint(code)).hasSize(3)
        }
    }
})
