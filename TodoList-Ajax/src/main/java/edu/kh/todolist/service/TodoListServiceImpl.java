package edu.kh.todolist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.todolist.dto.Todo;
import edu.kh.todolist.mapper.TodoListMapper;

@Transactional // 내부 메서드 수행후 트랜잭션 처리 수행 - 예외 발생시 롤백 아니면 커밋
@Service // 너는 Service 역할임을 명시 + Bean
public class TodoListServiceImpl implements TodoListService{

	@Autowired // 등록된 bean중에서 같은 타입을 얻어와 대입(DI) - 의존성 주입
	private TodoListMapper mapper;
	
	@Override
	public Map<String, Object> selectTodoList() {
		
		// 1) 할 일 목록 조회
		List<Todo> todoList = mapper.selectTodoList();
		
		// 2) 완료된 할 일 개수 조회
		int completeCount = mapper.selectCompleteCount();
		
		// 3) Map 객체 생성 후 조회 결과 담기
		Map<String, Object> map = new HashMap<>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);

		// 4) Map 객체 반환
		return map;
	}
	
	// 할 일 추가
	@Override
	public int todoAdd(Todo todo) {
		return mapper.todoAdd(todo);
	}
	
	// 할 일 상세조회
	@Override
	public Todo todoDetail(int todoNo) {
		return mapper.todoDetail(todoNo);
	}
	
	// 완료 여부 변경
	@Override
	public int todoComplete(int todoNo) {
		return mapper.todoComplete(todoNo);
	}
	
	// 할 일 수정
	@Override
	public int todoUpdate(Todo todo) {
		return mapper.todoUpdate(todo);
	}
	
	// 삭제
	@Override
	public int todoDelete(int todoNo) {
		return mapper.todoDelete(todoNo);
	}

	// 제목 검색
	@Override
	public String searchTitle(int todoNo) {
		return mapper.searchTitle(todoNo);
	}
	
	// 전체 할 일 개수 조회
	@Override
	public int getTotalCount() {
		return mapper.getTotalCount();
	}
	
	// 완료된 할 일 개수 조회
	@Override
	public int getCompleteCount() {
		return mapper.selectCompleteCount();
	}
	
	// 할 일 전체 목록 비동기 요청 처리
	@Override
	public List<Todo> getTodoList() {
		return mapper.selectTodoList();
	}
}
