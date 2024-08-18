package com.example.myBatisBoard.util.paging;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PagingHelper {

    public PagingInfo calculatePaging(int totalPost, int currentPage) {
        int pageSize = 10; /*한 화면에 보여줄 게시글*/
        int maxPages = 10; /*최대 표출 페이지 수*/

        /*전체 페이지 수*/
        /*int totalPage = totalPost > 0 ? (int) Math.ceil((double) totalPost / pageSize) : 1 ;*/
        int totalPage = totalPost > 0 ? (int) Math.ceil((double) totalPost / pageSize) : 1 ;

        int startPage = ((currentPage - 1) / maxPages) * maxPages + 1;
        int endPage = Math.min(totalPage, startPage + maxPages - 1);

        int offset = (currentPage - 1) * pageSize;

        return new PagingInfo(pageSize, maxPages, startPage, endPage, totalPage, offset, currentPage);
    }
}

