package com.example.myshoppinglist.di

import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.domain.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideViewModel(
        repository: ShoppingListRepository
    ): ShoppingListViewModel = ShoppingListViewModel(repository)

    @Provides
    @Singleton
    fun provideRepository(): ShoppingListRepository = ShoppingListRepository()
}


