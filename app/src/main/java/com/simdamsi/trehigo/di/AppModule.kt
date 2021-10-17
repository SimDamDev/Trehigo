package com.simdamsi.trehigo.di

import android.content.Context
import com.simdamsi.trehigo.db.AppDatabase
import com.simdamsi.trehigo.network.ApiClient
import com.simdamsi.trehigo.network.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    // TODO create ApiInterface in .network
    fun provideApiInterface(): ApiInterface {
        //TODO create ApiClient in .network
        return ApiClient.getClient()
    }

    @Provides
    // TODO create AppDatabase in .db
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase(context)
    }
}