package miway.com.materialtest.pojo;

import org.kaerdan.twolevelexpandablerecyclerview.TwoLevelExpandableAdapter;

import java.util.List;

/**
 * Created by Mallinath on 6/20/2015.
 */
public class CustomDataSet implements TwoLevelExpandableAdapter.DataSet<CustomViewData, CustomViewData> {


    private final CustomViewData headerName;
    private final List<CustomViewData> subItems;

    public CustomDataSet(CustomViewData headerName, List<CustomViewData> subItems) {
        this.headerName = headerName;
        this.subItems = subItems;
    }

    @Override
    public CustomViewData getData() {
        return headerName;
    }

    @Override
    public List<CustomViewData> getChildren() {
        return subItems;
    }
}
