package Paginator;

import java.util.List;

/**
 *
 * @author SlimSoft Technologies
 * @since 2017
 */
public abstract class PaginationHelper {

    private int pageSize;
    private int page;
    private int maxPages;

    public PaginationHelper(int pageSize) {
        this.pageSize = pageSize;
    }

    public abstract int getItemsCount();

    /**
     *
     * @param <T>
     * @return
     */
    public abstract List createPageDataList();

    public int getPageFirstItem() {
        return page * pageSize;
    }

    public int getPageLastItem() {
        int i = getPageFirstItem() + pageSize - 1;
        int count = getItemsCount() - 1;
        if (i > count) {
            i = count;
        }
        if (i < 0) {
            i = 0;
        }
        return i;
    }

    public boolean isHasNextPage() {
        return (page + 1) * pageSize + 1 <= getItemsCount();
    }

    /**
     * Determines whether there is a next page and gets the page number.
     *
     */
    public void nextPage() {
        if (isHasNextPage()) {
            page++;
        }
    }

    public boolean isHasPreviousPage() {
        return page > 0;
    }

    /**
     * Determines whether there is a previous page and gets the page number.
     *
     */
    public void previousPage() {
        if (isHasPreviousPage()) {
            page--;
        }
    }

    /**
     * Goes to the first page.
     *
     */
    public void firstPage() {
        if (isHasPreviousPage()) {
            page = 0;
        }
    }

    /**
     * Goes to the last page.
     *
     */
    public void lastPage() {
        if (isHasNextPage()) {
            page = Math.decrementExact(getMaxPages());
        }
    }

    /**
     * Determines the maximum number of pages as computed.
     *
     * @return the total number of pages, or 0
     */
    public int getMaxPages() {
        if (pageSize > 0) {
            // calculate how many pages there are
            maxPages = (getItemsCount() % pageSize == 0) ? (getItemsCount() / pageSize) : (Math.incrementExact(getItemsCount() / pageSize));
        }
        return maxPages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPage() {
        return page;
    }

}
