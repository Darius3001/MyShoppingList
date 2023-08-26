package com.example.myshoppinglist.di

import android.app.Application
import androidx.room.Room
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.domain.ShoppingListRepository
import com.example.myshoppinglist.domain.datasource.ShoppingListDatabase
import com.example.myshoppinglist.domain.use_case.AddEntry
import com.example.myshoppinglist.domain.use_case.DeleteEntry
import com.example.myshoppinglist.domain.use_case.GetShoppingList
import com.example.myshoppinglist.domain.use_case.SetChecked
import com.example.myshoppinglist.domain.use_case.ShoppingListUseCases
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
    fun provideDatabase(app: Application): ShoppingListDatabase = Room.databaseBuilder(
        app,
        ShoppingListDatabase::class.java,
        ShoppingListDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideViewModel(
        useCases: ShoppingListUseCases
    ): ShoppingListViewModel = ShoppingListViewModel(useCases)

    @Provides
    @Singleton
    fun provideRepository(
        db: ShoppingListDatabase
    ): ShoppingListRepository = ShoppingListRepository(db.shoppingListDao())

    @Provides
    @Singleton
    fun provideUseCases(
        repository: ShoppingListRepository
    ): ShoppingListUseCases = ShoppingListUseCases(
        getShoppingList = GetShoppingList(repository),
        addEntry = AddEntry(repository),
        deleteEntry = DeleteEntry(repository),
        setChecked = SetChecked(repository)
    )
}


