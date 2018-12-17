package example.domain.planete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import java.util.List;

public class PlaneteAdaptater extends ArrayAdapter<Planete> {

    public PlaneteAdaptater(Context ctx, List<Planete> planetes) {
        super(ctx, 0, planetes);
    }

    public View getView(int position, View recup, ViewGroup parent) {
        // créer ou réutiliser un PlaneteView
        PlaneteView vueItem = (PlaneteView) recup;
        if (vueItem == null)
            vueItem = (PlaneteView) PlaneteView.create(parent);
        vueItem.setItem(super.getItem(position));
        return vueItem;
    }
}
