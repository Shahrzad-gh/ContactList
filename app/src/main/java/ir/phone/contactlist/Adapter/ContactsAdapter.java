package ir.phone.contactlist.Adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import ir.phone.contactlist.Model.Contact;
import ir.phone.contactlist.R;

/**
 * Created by Shahrzad on 17/04/2018.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>{

    List<Contact> contacts;
    Context mycontext;

    public ContactsAdapter(List<Contact> contacts, Context mycontext) {
        this.contacts = contacts;
        this.mycontext = mycontext;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item,parent,false);

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, final int position) {

        Contact contact = contacts.get(position);
        holder.displayName.setText(contact.getDisplayName());
        holder.displayNumber.setText(contact.getDisplayPhoneNumber());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + contacts.get(position).getDisplayPhoneNumber()));
                if (ActivityCompat.checkSelfPermission(mycontext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    mycontext.startActivity(callIntent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView contactImage ;
        TextView displayName;
        TextView displayNumber;
        ImageView contactCall ;
        RelativeLayout relativeLayout;


        public ContactViewHolder(@NonNull View itemView) {

            super(itemView);
            contactImage = (ImageView) itemView.findViewById(R.id.contact_image);
            displayName = (TextView)itemView.findViewById(R.id.contat_name);
            displayNumber = (TextView)itemView.findViewById(R.id.contact_number);
            contactCall = (ImageView)itemView.findViewById(R.id.contact_call);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relative);
        }
    }
}
