package lucas.curso.aprendaingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import lucas.curso.aprendaingles.Fragments.BichosFragment;
import lucas.curso.aprendaingles.Fragments.NumerosFragment;

public class MainActivity extends AppCompatActivity {
    private SmartTabLayout stl;
    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        stl = findViewById(R.id.Nav);
        vp = findViewById(R.id.vp);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                FragmentPagerItems.with(this).add("Bichos", BichosFragment.class)
                        .add("Números", NumerosFragment.class).create());

        vp.setAdapter(adapter);
        stl.setViewPager(vp);
    }
}