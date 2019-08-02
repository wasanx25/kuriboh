package com.github.wasanx25

import com.github.wasanx25.rules.UselessCallFunction
import io.gitlab.arturbosch.detekt.test.assertThat
import io.gitlab.arturbosch.detekt.test.lint
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class UselessCallFunctionTest : Spek({
    val subject by memoized { UselessCallFunction() }

    describe("UselessCallFunction rule") {
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

    describe("UselessCallFunction rule") {
        it("reports to exists print() yet") {
            val code = """
                fun test() {
                    print("test1")
                    emptyList()
                    print("test2")
                    print("test3")
                }
            """

            assertThat(subject.lint(code)).hasSize(3)
        }
    }
})
