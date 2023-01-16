package ru.graymonk.popularlibraries.repository.implementation



//class GithubRepositoryImplFake :  {
//    private val repository =
//        listOf(
//            GithubUser(1,"John"),
//            GithubUser(2,"Sara"),
//            GithubUser(3,"Hudson"),
//            GithubUser(4,"Aang"),
//            GithubUser(5,"Kung Fury"),
//            GithubUser(6,"Ellen Ripley"),
//            GithubUser(7,"Sarah Conor"),
//            GithubUser(8,"Dwayne Hicks"),
//            GithubUser(9,"John McClane"),
//            GithubUser(10,"Alan Schaefer"),
//            GithubUser(11,"Tyler Durden"))


//     fun getUsers(): Single<List<GithubUser>> {
//        return Single.create {it.onSuccess(repository)}.delay(2L, TimeUnit.SECONDS)
//        return Single.create {.just(repository).delay(5L, TimeUnit.SECONDS)
//            it.onSuccess(repository)
//        }
//    }

//     fun getUserByLogin(id: Long): Single<GithubUser> {
//        return repository.find { it.id == id }
//    }
//}