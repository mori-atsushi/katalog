package com.moriatsushi.katalog.compose.navigation

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class NavControllerTest {

    @Test
    fun push() {
        val initialDestination = TestDestination.Object
        val nextDestination = TestDestination.Data(0)

        val target = NavController<TestDestination>(initialDestination)
        assertThat(target.current.destination).isEqualTo(initialDestination)
        assertThat(target.current.index).isEqualTo(0)

        target.push(nextDestination)
        assertThat(target.current.destination).isEqualTo(nextDestination)
        assertThat(target.current.index).isEqualTo(1)
    }

    @Test
    fun back() {
        val initialDestination = TestDestination.Object
        val nextDestination = TestDestination.Data(0)

        val target = NavController<TestDestination>(initialDestination)
        val initialState = target.current

        target.push(nextDestination)
        assertThat(target.current.destination).isEqualTo(nextDestination)
        assertThat(target.current.index).isEqualTo(1)

        val actual = target.back()
        assertThat(actual).isTrue()
        assertThat(target.current.destination).isEqualTo(initialDestination)
        assertThat(target.current).isEqualTo(initialState)
    }

    @Test
    fun back_isTop() {
        val initialDestination = TestDestination.Object

        val target = NavController<TestDestination>(initialDestination)
        val initialState = target.current

        val actual = target.back()
        assertThat(actual).isFalse()

        assertThat(target.current.destination).isEqualTo(initialDestination)
        assertThat(target.current).isEqualTo(initialState)
    }

    @Test
    fun back_nested() {
        val hostDestination = TestDestination.Host(
            NavController(TestDestination.Data(0)),
        )

        val target = NavController<TestDestination>(hostDestination)
        hostDestination.childNavController.push(TestDestination.Data(1))

        val actual1 = target.back()
        assertThat(actual1).isTrue()

        val actual2 = target.back()
        assertThat(actual2).isFalse()
    }

    @Test
    fun hasState() {
        val initialDestination = TestDestination.Object
        val nextDestination = TestDestination.Data(0)

        val target = NavController<TestDestination>(initialDestination)

        target.push(nextDestination)
        val state = target.current
        val actual1 = target.hasState(state)
        assertThat(actual1).isTrue()

        target.back()
        val actual0 = target.hasState(state)
        assertThat(actual0).isFalse()
    }

    sealed class TestDestination : NavDestination {
        object Object : TestDestination()

        data class Data(
            val value: Int,
        ) : TestDestination()

        data class Host(
            override val childNavController: NavController<TestDestination>,
        ) : TestDestination()
    }
}
