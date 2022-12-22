package com.todo.todominiproject.service.todo;

import com.todo.todominiproject.domain.SearchType;
import com.todo.todominiproject.domain.TodoListPage;
import com.todo.todominiproject.entity.Todo;
import com.todo.todominiproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getList(int pageNum){

        int index = (pageNum-1)*10;
        int count = 10;

        return todoRepository.findAll(index, count);
    }


    public TodoListPage getPage(int pageNum) {

        Page<Todo> page = todoRepository.findAll(PageRequest.of(pageNum-1, 10, Sort.by("tno").ascending()));

        List<Todo> list = page.getContent();

        int totalCount = (int) page.getTotalElements();

        TodoListPage todoListPage = new TodoListPage(10, pageNum, list, totalCount);

        return todoListPage;
    }

    @Transactional
    public List<Todo> search(SearchType searchType) {

        List<Todo> todoList = null;

        switch (searchType.getSearchOption()){
            case "duedate":
                todoList = todoRepository.findByDuedateContaining(searchType.getKeyword());
                break;
            case "todo":
                todoList = todoRepository.findByTodoContaining(searchType.getKeyword());
                break;
        }

        return todoList;
    }

}
