package com.aliumujib.artic.domain.usecases.articles

import com.aliumujib.artic.domain.executor.PostExecutionThread
import com.aliumujib.artic.domain.repositories.articles.IArticlesRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.lang.IllegalStateException

@RunWith(MockitoJUnitRunner::class)
class UnBookmarkArticleTest {

    private lateinit var unBookmarkArticle: UnBookmarkArticle
    @Mock
    lateinit var articlesRepository: IArticlesRepository
    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        unBookmarkArticle = UnBookmarkArticle(articlesRepository, postExecutionThread)
    }


    @Test
    fun `test that calling bookmarkArticle completes`(){
        stubBookmarkCompletable(Completable.defer {
            Completable.complete()
        })

        val completableTest = unBookmarkArticle.buildUseCaseCompletable(UnBookmarkArticle.Params(articleId = any())).test()
        completableTest.assertComplete()
    }


    @Test(expected = IllegalStateException::class)
    fun `test that calling bookmarkArticle without params throws an exception`(){
        stubBookmarkCompletable(Completable.defer {
            Completable.complete()
        })

        val completableTest = unBookmarkArticle.buildUseCaseCompletable().test()
        completableTest.assertComplete()
    }


    private fun stubBookmarkCompletable(completable: Completable) {
        whenever(articlesRepository.unBookmarkArticle(any()))
            .thenReturn(completable)
    }

}