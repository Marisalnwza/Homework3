package com.example.homework3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3.model.WordItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //สร้าง Adapter object
        MyAdapter adapter = new MyAdapter();
        //สร้าง Layout manager
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        //เข้าถึง RecycleView ใน Layout
        RecyclerView rv = findViewById(R.id.word_list_recycler_view);
        rv.setLayoutManager(lm); //กำหนดLayout Managerใฟ้กัย RecycleView
        rv.setAdapter(adapter); // กำหนด Adapter ให้กับ RecycleView

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        WordItem[] items = {
                new WordItem(R.drawable.faculty_painting,"Faculty of Painting, Sculpture and Graphic Arts","คณะจิตรกรรมประติมากรรมและภาพพิมพ์"),
                new WordItem(R.drawable.faculty_architecture,"Faculty of Architecture","คณะสถาปัตยกรรมศาสตร์"),
                new WordItem(R.drawable.faculty_archaeology ,"Faculty of Archaeology","คณะโบราณคดี"),
                new WordItem(R.drawable.faculty_decorative,"Faculty of Decorative Arts","คณะมัณฑนศิลป์"),
                new WordItem(R.drawable.faculty_arts,"Faculty of Arts","คณะอักษรศาสตร์"),
                new WordItem(R.drawable.faculty_education,"Faculty of Education","คณะศึกษาศาสตร์"),
                new WordItem(R.drawable.faculty_science,"Faculty of Science","คณะวิทยาศาสตร์"),
                new WordItem(R.drawable.faculty_pharmacy,"Faculty of Pharmacy","คณะเภสัชศาสตร์"),
                new WordItem(R.drawable.faculty_engineering,"Faculty of Engineering and Industrial Technology","คณะวิศวกรรมศาสตร์และเทคโนโลยีอุตสาหกรรม"),
                new WordItem(R.drawable.faculty_music,"Faculty of Music","คณะดุริยางคศาสตร์"),
                new WordItem(R.drawable.faculty_animal,"Faculty of Animal Sciences and Agricultural Technology","คณะสัตวศาสตร์และเทคโนโลยีการเกษตร"),
                new WordItem(R.drawable.faculty_w,"Faculty of Management Science","คณะวิทยาการจัดการ"),
                new WordItem(R.drawable.faculty_ict,"Faculty of Information and Communication Technology","คณะเทคโนโลยีสารสนเทศและการสื่อสาร"),
                new WordItem(R.drawable.faculty_international,"Silpakorn University International College","วิทยาลัยนานาชาติ")

        };

        public MyAdapter(){

        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word,parent,false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.imageView.setImageResource(items[position].imageResID);
            holder.wordTextView.setText(items[position].word);
            holder.subwordTextView.setText(items[position].subword);

        }

        @Override
        public int getItemCount() {

            return items.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView wordTextView;
            TextView subwordTextView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
                wordTextView = itemView.findViewById(R.id.word_text_View);
                subwordTextView = itemView.findViewById(R.id.subword_text_view);
            }
        }
    }
}