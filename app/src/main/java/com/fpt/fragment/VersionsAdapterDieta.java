package com.fpt.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chenao.healthylife.R;

import java.util.List;

public class VersionsAdapterDieta extends RecyclerView.Adapter<VersionsAdapterDieta.VersionVH> {

    List<VersionsDieta> versionsList;

    public VersionsAdapterDieta(List<VersionsDieta> versionsList) {
        this.versionsList = versionsList;
    }

    @NonNull
    @Override
    public VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new VersionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionVH holder, int position) {

        VersionsDieta versions = versionsList.get(position);
        holder.codeNameTxt.setText(versions.getCodename());
        holder.versionTxt.setText(versions.getVersion());
        holder.apiLevelTxt.setText(versions.getApiLevel());
        holder.descriptionTxt.setText(versions.getDescription());
        holder.imageView.setImageResource(versions.getImage());

        boolean isExpandable = versionsList.get(position).isExpandable();
        holder.expandibleLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        holder.version2Txt.setText(versions.getVersion2());
        holder.apiLevel2Txt.setText(versions.getApiLevel2());
        holder.description2Txt.setText(versions.getDescription2());
        holder.image2View.setImageResource(versions.getImage2());
    }

    @Override
    public int getItemCount() {
        return versionsList.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder {

        TextView codeNameTxt, versionTxt, apiLevelTxt, descriptionTxt;
        ImageView imageView;
        LinearLayout linearLayout;
        RelativeLayout expandibleLayout;

        TextView version2Txt, apiLevel2Txt, description2Txt;
        ImageView image2View;

        public VersionVH(@NonNull View itemView) {
            super(itemView);

            codeNameTxt = itemView.findViewById(R.id.code_name);
            versionTxt = itemView.findViewById(R.id.version);
            apiLevelTxt = itemView.findViewById(R.id.api_level);
            descriptionTxt = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.image);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandibleLayout = itemView.findViewById(R.id.expandable_layout);

            version2Txt = itemView.findViewById(R.id.version2);
            apiLevel2Txt = itemView.findViewById(R.id.api_level2);
            description2Txt = itemView.findViewById(R.id.description2);
            image2View = itemView.findViewById(R.id.image2);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VersionsDieta versions = versionsList.get(getAdapterPosition());
                    versions.setExpandable(!versions.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
