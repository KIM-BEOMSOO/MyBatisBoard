package com.example.myBatisBoard.util.paging;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PagingInfo {

    private int pageSize;
    private int maxPages;
    private int startPage;
    private int endPage;
    private int totalPage;
    private int offset;
    private int currentPage;

    public PagingInfo(int pageSize, int maxPages, int startPage, int endPage, int totalPage, int offset, int currentPage) {
        this.pageSize = pageSize;
        this.maxPages = maxPages;
        this.startPage = startPage;
        this.endPage = endPage;
        this.totalPage = totalPage;
        this.offset = offset;
        this.currentPage = currentPage;
    }
}
