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
        this.mListe = this.getPlanetes();
        PlaneteAdaptater adapter = new PlaneteAdaptater(this,mListe);
        setListAdapter(adapter);
    }

    public List<Planete> getPlanetes(){
        Resources res = getResources();
        final String[] noms = res.getStringArray(R.array.noms);
        final int[] distances = res.getIntArray(R.array.distances);
        TypedArray imgs = getResources().obtainTypedArray(R.array.idImages);
        final int[] idImages = res.getIntArray(R.array.idImages);
        mListe = new ArrayList<Planete>();
        for (int i=0; i<noms.length; ++i) {
            mListe.add(new Planete(noms[i], distances[i], imgs.getResourceId(i, -1)));
        }
        return mListe;
    }
}
