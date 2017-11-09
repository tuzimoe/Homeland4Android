package moe.eloli.tuzi.ui.nodes;

import moe.eloli.tuzi.data.network.model.adjusted.NodeListItem;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

import java.util.List;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/07
 * desc   :
 */
public interface NodesContract {

    interface View extends BaseView<Presenter> {

        void loadNodes(List<NodeListItem> nodeListItems);

    }

    interface Presenter extends BasePresenter {

        void loadNodes();

    }
}
