package hello.service

import hello.domain.Memo

import org.springframework.data.repository.CrudRepository


interface MemoRepository extends CrudRepository<Memo, Long> {

}
