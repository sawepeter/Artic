
package com.aliumujib.artic.ui.inject.components

import android.content.Context
import com.aliumujib.artic.data.repositories.articles.ArticlesRepoImpl
import com.aliumujib.artic.domain.repositories.articles.IArticlesRepository
import com.aliumujib.artic.remote.api.WordPressAPI
import com.aliumujib.artic.ui.inject.module.CacheModule
import com.aliumujib.artic.ui.inject.module.ContextModule
import com.aliumujib.artic.ui.inject.module.DataModule
import com.aliumujib.artic.ui.inject.module.RemoteModule
import dagger.Component
import javax.inject.Singleton

/**
 * Core component that all module's components depend on.
 *
 * @see Component
 */
@Singleton
@Component(modules = [
    ContextModule::class,
    RemoteModule::class,
    DataModule::class,
    CacheModule::class
])
interface CoreComponent {

    /**
     * Provide dependency graph Context
     *
     * @return Context
     */
    fun context(): Context

    /**
     * Provide dependency graph WordPressAPI
     *
     * @return WordPressAPI
     */
    fun wordPressAPI(): WordPressAPI

    /**
     * Provide dependency graph IArticlesRepository
     *
     * @return IArticlesRepository
     */
    fun articlesRepository(): IArticlesRepository


}