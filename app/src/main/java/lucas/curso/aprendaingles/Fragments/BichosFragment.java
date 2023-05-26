package lucas.curso.aprendaingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import lucas.curso.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageButton btCachorro, btGato, btLeao, btMacaco, btOvelha, btVaca;
    private MediaPlayer mp;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BichosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BichosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        btCachorro = view.findViewById(R.id.bt_cachorro);
        btGato = view.findViewById(R.id.bt_gato);
        btLeao = view.findViewById(R.id.bt_leao);
        btMacaco = view.findViewById(R.id.bt_macaco);
        btOvelha = view.findViewById(R.id.bt_ovelha);
        btVaca = view.findViewById(R.id.bt_vaca);

        btCachorro.setOnClickListener(this);
        btGato.setOnClickListener(this);
        btLeao.setOnClickListener(this);
        btMacaco.setOnClickListener(this);
        btOvelha.setOnClickListener(this);
        btVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_cachorro:
                mp = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;
            case R.id.bt_gato:
                mp = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.bt_leao:
                mp = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.bt_macaco:
                mp = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.bt_ovelha:
                mp = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
            case R.id.bt_vaca:
            mp = MediaPlayer.create(getActivity(), R.raw.cow);
            tocarSom();
            break;
        }
    }
    public void tocarSom(){
        if(mp != null){
            mp.start();
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mp.release();
                }
            });
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp != null){
            mp.release();
            mp = null;
        }
    }
}




