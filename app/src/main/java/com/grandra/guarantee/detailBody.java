
package com.grandra.guarantee;


public class detailBody {

    private detailItem item;
    private long pageNo;
    private long totalCount;
    private long numOfRows;

    public detailItem getItem() {
        return item;
    }

    public void setItem(detailItem item) {
        this.item = item;
    }

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

}
