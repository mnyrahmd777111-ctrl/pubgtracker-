package com.track;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import java.util.Random;

public class MainActivity extends Activity {
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        final EditText pid = findViewById(R.id.pid);
        final Spinner server = findViewById(R.id.server);
        final Spinner device = findViewById(R.id.device);
        final TextView out = findViewById(R.id.out);
        final Button btn = findViewById(R.id.btn);

        String[] srv = {"أوروبا","الشرق الأوسط","أمريكا","آسيا"};
        String[] dev = {"جوال","آيباد","محاكي"};
        server.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, srv));
        device.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dev));

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final String id = pid.getText().toString().trim();
                if(id.isEmpty()){ Toast.makeText(MainActivity.this,"أدخل الآيدي",Toast.LENGTH_SHORT).show(); return; }
                out.setText("جاري التتبع...");
                final String s = server.getSelectedItem().toString();
                final String d = device.getSelectedItem().toString();
                final Random r = new Random();
                new Handler().postDelayed(new Runnable(){
                    public void run(){
                        String[] maps={"Erangel","Miramar","Sanhok","Livik","Vikendi"};
                        String[] ranks={"Gold","Platinum","Diamond","Crown","Ace","Conqueror"};
                        out.setText("تم التتبع!\n\nالآيدي: "+id+"\nالسيرفر: "+s+
                          "\nالجهاز: "+d+"\nالرانك: "+ranks[r.nextInt(ranks.length)]+
                          "\nالتقييم: "+(3000+r.nextInt(3000))+"\nالمستوى: "+(30+r.nextInt(50))+
                          "\nالحالة: في مباراة\nالخريطة: "+maps[r.nextInt(maps.length)]+
                          "\nالقطاع: "+"ABCDEFG".charAt(r.nextInt(7))+(1+r.nextInt(9))+
                          "\nالفريق: "+(1+r.nextInt(4))+"/4\nالدقة: "+(88+r.nextInt(11))+"%"+
                          "\nK/D: "+(1+r.nextInt(40)/10.0)+"\nفوز: "+(100+r.nextInt(400))+
                          "\nآخر اتصال: قبل "+(1+r.nextInt(30))+" دقيقة");
                    }
                }, 4000);
            }
        });
    }
}
