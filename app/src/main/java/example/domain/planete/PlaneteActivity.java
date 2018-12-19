package example.domain.planete;

import android.app.ListActivity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PlaneteActivity extends ListActivity {
    protected List<Planete> mListe = new ArrayList<Planete>();
    @Override
    protected void onCreate(Bundle saveInstanteState) {
        super.onCreate(saveInstanteState);
        PlaneteDao planeteDao = new PlaneteDao(this);
        this.mListe = planeteDao.planeteList();
        PlaneteAdaptater adapter = new PlaneteAdaptater(this,mListe);
        setListAdapter(adapter);
    }
}
