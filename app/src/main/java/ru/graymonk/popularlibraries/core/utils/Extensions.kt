package ru.graymonk.popularlibraries.core.utils

import android.view.View
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


//fun ImageView.loadImage(url: String?) {
//    Glide.with(context)
//        .load(url)
//        .placeholder(R.drawable.ic_user_placeholder)
//        .into(this)
//}

fun <T : Any> Single<T>.subscribeByDefault(): Single<T> {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun Disposable.disposeBy(bag: CompositeDisposable) {
    bag.add(this)
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun <T : Any> Single<T>.doCompletableIf(
    predicate: Boolean,
    completableCreator: (data: T) -> Completable
): Single<T> {
    return if (predicate) {
        this.flatMap {
            completableCreator(it).andThen(Single.just(it))
        }
    } else {
        this
    }
}
