package com.rubypaper.persistence;

import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{//Board : 엔티티의 클래스 타입  Long : 기본키 타입
	
}
