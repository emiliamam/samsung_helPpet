package com.example.myapplication.Fragment_bottom_nav;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.how_help;
import com.example.myapplication.map;
import com.example.myapplication.profile_elit;
import com.example.myapplication.welcome_activity;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    ArrayList<String> s;
    ArrayAdapter arrayAdapter;
    int n=0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Button but_help = v.findViewById(R.id.but_help);
        Button but_redactor = v.findViewById(R.id.but_redactor);
        Button but_vet = v.findViewById(R.id.but_vet);
        Button but_priut = v.findViewById(R.id.but_pruit);




        but_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileFragment.this.getActivity(), how_help.class));
            }
        });
        but_redactor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileFragment.this.getActivity(), profile_elit.class));
            }
        });
        but_vet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ProfileFragment.this.getActivity(), welcome_activity.class));
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            {
                                PermissionListener permissionlistener = new PermissionListener() {
                                    @Override
                                    public void onPermissionGranted() {
                                        startActivity(new Intent(ProfileFragment.this.getActivity(), map.class));
                                    }

                                    @Override
                                    public void onPermissionDenied(List<String> deniedPermissions) {
                                        Toast.makeText(ProfileFragment.this.getActivity(), "???????????? ????????????????\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                                    }


                                };
                                TedPermission.create()
                                        .setPermissionListener(permissionlistener)
                                        .setDeniedMessage("?????? ?????????????????? ???????????? ???????????????????? ???????????????????????? ????????????????????")
                                        .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                                        .check();
                            }
                        }
                    }
                };
                thread.start();
            }
        });
        but_priut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ProfileFragment.this.getActivity(), welcome_activity.class));
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            {
                                PermissionListener permissionlistener = new PermissionListener() {
                                    @Override
                                    public void onPermissionGranted() {
                                        startActivity(new Intent(ProfileFragment.this.getActivity(), map.class));
                                    }

                                    @Override
                                    public void onPermissionDenied(List<String> deniedPermissions) {
                                        Toast.makeText(ProfileFragment.this.getActivity(), "???????????? ????????????????\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                                    }


                                };
                                TedPermission.create()
                                        .setPermissionListener(permissionlistener)
                                        .setDeniedMessage("?????? ?????????????????? ???????????? ???????????????????? ???????????????????????? ????????????????????")
                                        .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                                        .check();
                            }
                        }
                    }
                };
                thread.start();
            }
        });
//        s = new ArrayList<String >();
//        s.add("one");
//        s.add("two");
//        s.add("three");
//
//        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) v.findViewById(R.id.card);
//        arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.carditem, R.id.text_card_item, s);
//        swipeFlingAdapterView.setAdapter(arrayAdapter);
//        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
//            @Override
//            public void removeFirstObjectInAdapter() {
//                s.remove(0);
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onLeftCardExit(Object o) {
//
//            }
//
//            @Override
//            public void onRightCardExit(Object o) {
//
//            }
//
//            @Override
//            public void onAdapterAboutToEmpty(int i) {
//
//            }
//
//            @Override
//            public void onScroll(float v) {
//
//            }
//        });
        return v;
    }
}