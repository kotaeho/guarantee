
package com.grandra.guarantee;

import java.util.List;

public class intereBody {

    private long pageNo;
    private long totalCount;
    private long numOfRows;
    private List<intereItem> items;

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(long numOfRows) {
        this.numOfRows = numOfRows;
    }

    public List<intereItem> getItems() {
        return items;
    }

    public void setItems(List<intereItem> items) {
        this.items = items;
    }

}
