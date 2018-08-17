package com.beaubien.cam_degree;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Beaubien on 7/2/2017.
 */

public class detail_fragment extends Fragment implements MainActivity.OnUpdateFragmentDetail
{
    lobe camshaft_lobe;

    TextView text_intake_duration;
    TextView text_intake_centerline;
    TextView text_exhaust_duration;
    TextView text_exhaust_centerline;
    TextView text_lobe_separation;
    TextView text_overlap;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.field, container, false);

        text_intake_duration    = (TextView) view.findViewById(R.id.value_intake_duration);
        text_intake_centerline  = (TextView) view.findViewById(R.id.value_intake_centerline);
        text_exhaust_duration   = (TextView) view.findViewById(R.id.value_exhaust_duration);
        text_exhaust_centerline = (TextView) view.findViewById(R.id.value_exhaust_centerline);
        text_lobe_separation    = (TextView) view.findViewById(R.id.value_LSA);
        text_overlap            = (TextView) view.findViewById(R.id.value_overlap);

        camshaft_lobe.refactor();

        text_intake_duration.setText(Float.toString(camshaft_lobe.getIntake_duration()));

        text_intake_centerline.setText(Float.toString(camshaft_lobe.getIntake_centerline()));

        text_exhaust_duration.setText(Float.toString(camshaft_lobe.getExhaust_duration()));

        text_exhaust_centerline.setText(Float.toString(camshaft_lobe.getExhaust_centerline()));

        text_lobe_separation.setText(Float.toString(camshaft_lobe.getLobe_separation()));

        text_overlap.setText(Float.toString(camshaft_lobe.getOverlap()));

        return view;
    }
    // Most of this was auto-generated, we'll just leave it for now
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public detail_fragment()
    {
        camshaft_lobe = new lobe();
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment.
     */
    public static detail_fragment newInstance(String param1, String param2)
    {
        detail_fragment fragment = new detail_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
       }
    }

    public void update_details(lobe lobes)
    {
        camshaft_lobe.set_intake_opens(lobes.getIntake_opens());
        camshaft_lobe.setIntake_closes(lobes.getIntake_closes());
        camshaft_lobe.setExhaust_opens(lobes.getExhaust_opens());
        camshaft_lobe.setExhaust_closes(lobes.getExhaust_closes());

    }
}
