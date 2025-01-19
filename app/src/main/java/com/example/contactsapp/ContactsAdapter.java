package com.example.contactsapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contacts;

    public ContactsAdapter() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Contact 1",R.drawable.avatar1,"contact1@gmail.com"));
        contacts.add(new Contact("Contact 2",R.drawable.avatar2,"contact2@gmail.com"));
        contacts.add(new Contact("Contact 3",R.drawable.avatar3,"contact3@gmail.com"));
        contacts.add(new Contact("Contact 4",R.drawable.avatar4,"contact4@gmail.com"));
        contacts.add(new Contact("Contact 5",R.drawable.avatar5,"contact5@gmail.com"));
        contacts.add(new Contact("Contact 6",R.drawable.avatar6,"contact6@gmail.com"));
        contacts.add(new Contact("Contact 7",R.drawable.avatar7,"contact7@gmail.com"));
        contacts.add(new Contact("Contact 8",R.drawable.avatar8,"contact8@gmail.com"));
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.tv_name.setText(contact.getName());
        holder.tv_email.setText(contact.getEmail());
        holder.avatar.setImageResource(contact.getAvatar());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ContactActivity.class);
                intent.putExtra("contact",contact);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        (Activity) v.getContext(),
                        holder.card,
                        "cardtransition"
                );
                v.getContext().startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
