package com.todo.todominiproject.domain;

import com.todo.todominiproject.entity.Todo;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoListPage {

    private int conuntPerPage;
    private int pageNum;
    private List<Todo> list;
    private int totalCount;
    private int startNum;
    private int endNum;
    private boolean prev;
    private boolean next;


    public TodoListPage(int conuntPerPage, int pageNum, List<Todo> list, int totalCount) {
        this.conuntPerPage = conuntPerPage;
        this.pageNum = pageNum;
        this.list = list;
        this.totalCount = totalCount;
        calPageInfo();
    }

    private void calPageInfo() {

        this.endNum = (int) ((Math.ceil((this.pageNum * 1.0) / 5)) * 5);
        this.startNum = this.endNum-4;

        int realEndNum = (int) Math.ceil((this.totalCount * 1.0) / conuntPerPage);

        this.endNum = realEndNum < this.endNum ? realEndNum : this.endNum;

        this.prev = this.startNum > 1;
        this.next = this.endNum < realEndNum;

    }


}
