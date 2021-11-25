package com.dqb.cloud_common.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PagingDto<T>  implements Serializable {

    private int  pageIndex;

    private int pageSize;

    private int total;

    private int pageCount;

    List<T> data;

    /**
     * @return the pageCount
     */
    public int getPageCount() {

        if (pageIndex > 0)
        {
            if (total % pageSize == 0)
            {
                pageCount = total / pageSize;
            }
            else
            {
                pageCount = total / pageSize + 1;
            }
        }
        return pageCount;
    }


}
