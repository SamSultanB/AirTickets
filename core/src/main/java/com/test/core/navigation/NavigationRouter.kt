package com.test.core.navigation

interface NavigationRouter<T> {

    fun navigateTo(action: T)

    fun pop()

    fun replace(action: T)

}