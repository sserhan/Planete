package example.domain.planete;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PlaneteView extends RelativeLayout {
    private TextView tvNom;
    private TextView tvDistance;
    private ImageView ivImage;

    private void findViews(){
        tvNom = findViewById(R.id.item_nom);
        tvDistance = findViewById(R.id.item_distance);
        ivImage = findViewById(R.id.item_image);
    }
    public PlaneteView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setItem(final Planete planete)
    {
        tvNom.setText(planete.getNom());
        tvDistance.setText(
                Integer.toString(planete.getDistance())
                        + " millions de km");
        ivImage.setImageResource(planete.getIdImage());
    }


    public static PlaneteView create(ViewGroup parent)
    {
        LayoutInflater li =
                LayoutInflater.from(parent.getContext());
        PlaneteView itemView;
        itemView = (PlaneteView)
                li.inflate(R.layout.item, parent, false);
        itemView.findViews();
        return itemView;
    }
}
